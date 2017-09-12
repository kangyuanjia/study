package com.kyj.common;

/**
 * 业务层到请求转发层的响应信息类
 * <br>
 * 通过ThreadLocal关键字确保每个请求（线程）信息独立性 
 *
 * @author rong.zhu
 *
 */
public class MessageReturnTool {
	
	public static final int ERROR = -1;
	
	public static final int FAIL = -2;
	
	public static final int SUCCESS = 1;
	
	//当前线程（请求）的响应代码
	private static ThreadLocal<Integer> retCode = new ThreadLocal<Integer>();
	
	//当前线程(请求）的响应信息
	private static ThreadLocal<String> retMsg = new ThreadLocal<String>();
	
	//当前线程(请求) 的临时返回对象
	private static ThreadLocal<Object> retObj = new ThreadLocal<Object>();
	
	
	
	/**
	 * 设置当前线程响应代码
	 * @param code
	 */
	public static void setRetCode(int code) {
		retCode.set(code);
	}

	public static int getRetCode() {
		return retCode.get();
	}
	
	/**
	 * 设置当前线程响应信息
	 * @param msg
	 */
	public static void setRetMsg(String msg) {
		retMsg.set(msg);
	}
	
	public static String getRetMsg() {
		return retMsg.get();
	}
	
	/**
	 * 设置当前线程临时返回对象
	 * @param obj
	 */
	public static void setRetObj(Object obj) {
		retObj.set(obj);
	}
	
	public static Object getRetObj() {
		return retObj.get();
	}
	
	public static void refresh() {
		retCode.set(1);
		retMsg.remove();  //清除当前线程响应信息
		retObj.remove();  //清除当前线程返回对象
	}
	
}
