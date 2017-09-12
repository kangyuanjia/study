package com.kyj.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kyj.common.runtime.RuntimeConfigure;
import com.kyj.po.LoginUser;

/** 
 * <p>Title: LoginInterceptor </p> 
 * <p>Description:登陆认证拦截器</p> 
 * @author kangyuanjia 
 * @date 2016年4月7日 下午4:11:35 
 */ 
public class LoginInterceptor implements HandlerInterceptor {

	
	//进入 Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//获取请求的url
		String dynamicUrl = request.getPathInfo();
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(dynamicUrl == null ) 
			dynamicUrl = request.getRequestURI();
		if(dynamicUrl!=null){
			for(String action : RuntimeConfigure.resources_without_login){
				//System.out.println(dynamicUrl);
				if(dynamicUrl.contains(action)){
					return true;
				}
			}
		}
		/*System.out.println(dynamicUrl);
		
		if(dynamicUrl.contains("index.action") ||dynamicUrl.contains("userLogin.action") || dynamicUrl.contains("verifyCode.action")){
			return true;
		}*/
		
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信息
		//String username = (String) session.getAttribute("username");
		LoginUser loginUserData = (LoginUser) session.getAttribute("loginUserData");
		if(loginUserData == null){
			String type = ((HttpServletRequest)request).getHeader("X-Requested-With");
			if ("XMLHttpRequest".equalsIgnoreCase(type)) {
				response.setContentType("text/html;charset=UTF-8");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setHeader("Cache-Control", "no-cache, must-revalidate");
				response.getWriter().write("{\"sessionStatus\":\"timeout\",\"rows\":[],\"msg\":'会话过期！'}");
				response.getWriter().flush();
			}else{
				response.sendRedirect("/maven-spring-mybatis/index.action");
				//return;
			}			
		}else{
			//身份存在，放行
			return true;
		}
		
		//执行这里表示用户身份需要认证，跳转登陆页面
		//request.getRequestDispatcher("/maven-spring-mybatis/index.action").forward(request, response);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptor1...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
