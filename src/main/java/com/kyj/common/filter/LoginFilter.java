package com.kyj.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.kyj.po.LoginUser;

public class LoginFilter implements Filter {
	private static Logger logger = Logger.getLogger(LoginFilter.class);
	
	/** 无需登录的资源*/
	private List<String> resources_without_login = new ArrayList<String>();
	
	/** 跳转页面，一般为登录页面*/
	private String redirectUrl = null;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String dynamicUrl = req.getPathInfo();
		if(dynamicUrl == null ) 
			dynamicUrl = req.getRequestURI();
		if(dynamicUrl!=null){
			for(String action : resources_without_login){
				if(dynamicUrl.contains(action)){
					chain.doFilter(request, response);
					return;
				}
			}
		}
		HttpSession session = req.getSession();
		LoginUser loginUserData = (LoginUser) session.getAttribute("loginUserData");
		if(loginUserData == null){
			String type = ((HttpServletRequest)request).getHeader("X-Requested-With");
			if ("XMLHttpRequest".equalsIgnoreCase(type)) {
				response.setContentType("text/html;charset=UTF-8");
				res.setHeader("Pragma", "no-cache");
				res.setDateHeader("Expires", 0);
				res.setHeader("Cache-Control", "no-cache, must-revalidate");
				response.getWriter().write("{\"sessionStatus\":\"timeout\",\"rows\":[],\"msg\":'会话过期！'}");
				response.getWriter().flush();
				return;
			}else{
				 res.sendRedirect("/maven-spring-mybatis/login.html");
				 return;
			}			
		}else{
			chain.doFilter(request, response);
		}
	
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		resources_without_login.clear();
		redirectUrl = fConfig.getInitParameter("redirectUrl");
		if(redirectUrl == null || redirectUrl.equals("")) {
			logger.error("登录过滤器没有配置跳转页面");
			throw new ServletException("登录过滤器没有配置跳转页面");
		}
		
		String resources = fConfig.getInitParameter("withoutLoginResources");
		if(resources != null) {
			StringTokenizer rs = new StringTokenizer(resources, ";");
			while(rs.hasMoreTokens()) {
				String s = rs.nextToken();
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
             	Matcher m = p.matcher(s);
             	String ss = m.replaceAll("");

				resources_without_login.add(ss);
			}
		}
	}
	
	public void destroy() {
		
	}
	

}
