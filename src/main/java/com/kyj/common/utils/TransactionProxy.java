package com.kyj.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kyj.common.MessageReturnTool;

/**
 * 采用动态代理实现的事务控制类
 * @author rong.zhu
 *
 */
public class TransactionProxy implements InvocationHandler {
	//需要被代理的类
	private Object targetObj = null; 
	
	//所有被代理的方法，KEY是类名，VALUE是被代理的方法列表
	private static Map<String, List<String>> proxyedMethodMap = new HashMap<String, List<String>>();
	
	private static Logger logger = Logger.getLogger(TransactionProxy.class);
	
	static {
		//读取资源，加载所有需要被代理的类及其方法
		InputStream stream = null;
		try {
			Properties props = new Properties();
			stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tproxy.properties");
			props.load(stream);
			
			Set<Entry<Object, Object>> entrySets = props.entrySet();
			for(Entry<Object, Object> entry : entrySets) {
				String proxyedClass = entry.getKey().toString();
				String proxyedMethods = entry.getValue().toString();
				List<String> methodList = new ArrayList<String>();
				String [] array = proxyedMethods.split(",");
				for(int i=0; i<array.length; i++) {
					methodList.add(array[i]);
				}
				proxyedMethodMap.put(proxyedClass, methodList);
				
			}
			
		} catch (IOException e) {
			logger.error("加载配置文件tproxy.properties失败！");
		}finally{
			try {
				stream.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}
	
	
	/**
	 * 获取被代理后的类实例
	 * @param obj
	 * @return
	 */
	public Object newProxyInstance(Object obj) {
		this.targetObj = obj;
		return Proxy.newProxyInstance(this.targetObj.getClass().getClassLoader(), 
				this.targetObj.getClass().getInterfaces(), this);
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj  = null;
		if(this.isMethodProxyed(method)) {//判断方法是否被代理
			try{
				obj = method.invoke(this.targetObj, args);
				TransactionManager.commit();
				logger.debug("提交事务...");
			}catch(Exception e) {
			
				TransactionManager.rollback();
				logger.debug("回滚事务...");
				if (e instanceof InvocationTargetException) {    
	                InvocationTargetException inv = (InvocationTargetException) e;    
	            	MessageReturnTool.setRetCode(MessageReturnTool.ERROR);
					MessageReturnTool.setRetMsg(inv.getTargetException().getLocalizedMessage());
	                throw inv.getTargetException();    
	            } else {    
	            	MessageReturnTool.setRetCode(MessageReturnTool.ERROR);
					MessageReturnTool.setRetMsg(e.getLocalizedMessage());
	                throw new Exception("操作失败!", e);    
	            }    
			}finally {
				//释放连接
				ConnectionCenter.closeTransactionConnection();
				logger.debug("释放连接...");
			}
		}else {
			obj = method.invoke(this.targetObj, args);
		}
		return obj;
		
	}
	
	/**
	 * 判断当前方法是否被代理
	 * @return
	 */
	private boolean isMethodProxyed(Method method) {
		String targetObjClassName = this.targetObj.getClass().getSimpleName();
		String targetMethodName = method.getName();
		if(!proxyedMethodMap.containsKey(targetObjClassName)) {
			return false;
		}
		List<String> methodList = proxyedMethodMap.get(targetObjClassName);
		for(int i=0; i<methodList.size(); i++) {
			String preMethodName = methodList.get(i);
			if(preMethodName.equals(targetMethodName)){
				return true;
			}else if(preMethodName.endsWith("*")){
				String index = preMethodName.substring(0, preMethodName.indexOf("*"));
				if(targetMethodName.startsWith(index)) {
					return true;
				}
			}
		}
		return false;
		
	}
}
