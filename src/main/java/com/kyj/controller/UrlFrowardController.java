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
public class UrlFrowardController {
	
	@RequestMapping("/getPage")
	public ModelAndView getPage(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String page_name = request.getParameter("page_name");
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName(page_name);
		return modelAndView;
	}
}
