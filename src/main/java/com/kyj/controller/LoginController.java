package com.kyj.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kyj.common.CustomResponseMsg;
import com.kyj.common.utils.DateUtils;
import com.kyj.common.verifcode.ImageValidCode;
import com.kyj.po.LoginUser;
import com.kyj.service.LoginUserService;

/**
 * <p>
 * Title: LoginController
 * </p>
 * <p>
 * Description:用户登录
 * </p>
 * 
 * @author kangyuanjia
 * @date 2016年4月7日 下午4:09:18
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	  private LoginUserService userService;
	// 登陆
	@ResponseBody
	@RequestMapping(value = "/userLogin")
	public CustomResponseMsg login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		password = java.net.URLDecoder.decode(password, "UTF-8");
		System.out.println("password ="+password );
		//CustomHttpSession session = SessionManager.getSession(request, response);
		HttpSession session = request.getSession();
		System.out.println("verifyCode="+(String)session.getAttribute("verifyCode"));
		if(!verifyCode.equals((String)session.getAttribute("verifyCode"))){
			msg.errorCode = -1;
			msg.msg = "验证码错误";
			return msg;
		}	
		
		// 调用service进行用户身份验证
		LoginUser loginUserData = new LoginUser();
		loginUserData.setUserId(userId);
		loginUserData.setUserPwd(password);
		loginUserData = userService.findUser(loginUserData);
		if(loginUserData != null && loginUserData.getUserName()!=null && loginUserData.getUserName()!= ""){
			session.setAttribute("username", loginUserData.getUserName());
			msg.data = loginUserData;
			session.setAttribute("loginUserData", loginUserData);
			session.setAttribute("loginTime", DateUtils.getDateTime(new Date()));
		}else{
			msg.errorCode = -2;
			msg.msg = "用户名或密码错误";
		}
		return msg;
	}

	// 退出
	@ResponseBody
	@RequestMapping("/logout")
	public CustomResponseMsg logout(HttpSession session) throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// 清除session
		session.invalidate();
		msg.msg="操作成功！";
		// 重定向到商品列表页面
		return msg;
	}
	// 退出
	@ResponseBody
	@RequestMapping("/getUser")
	public CustomResponseMsg getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// 清除session
		HttpSession session = request.getSession();
		LoginUser loginUserData = (LoginUser) session.getAttribute("loginUserData");
		String loginTime = (String) session.getAttribute("loginTime");
		loginUserData.setUserPwd(loginTime);
		msg.msg="操作成功！";
		msg.data = loginUserData;
		// 重定向到商品列表页面
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/verifyCode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 生成随机类
		Random random = new Random();
		String rand = "";
		for (int i = 0; i < 4; i++) {
			rand += String.valueOf(random.nextInt(10));
		}
		BufferedImage image = ImageValidCode.getImage(rand);

		// 将认证码存入SESSION
		request.getSession().setAttribute("verifyCode", rand);

		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
		response.flushBuffer();
	}
	// 退出
	
	@RequestMapping("/index")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
