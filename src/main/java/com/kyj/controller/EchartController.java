package com.kyj.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.json.GsonOption;
import com.kyj.common.CustomResponseMsg;
import com.kyj.common.verifcode.ImageValidCode;
import com.kyj.po.LoginUser;
import com.kyj.service.EchartService;
import com.kyj.service.LoginUserService;

/**
 * <p>
 * Title: LoginController
 * </p>
 * <p>
 * Description:Echarts
 * </p>
 * 
 * @author kangyuanjia
 * @date 2016年4月7日 下午4:09:18
 */
@Controller
@RequestMapping(value = "/echart")
public class EchartController {
	@Autowired
	private EchartService echartService;

	@ResponseBody
	@RequestMapping(value = "/selectRemoveCauses")
	public CustomResponseMsg selectRemoveCauses(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectRemoveCauses();
		// msg.msg = option.toString();
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/selectProductPrice")
	public CustomResponseMsg selectProductPrice(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectByExample();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectProductPrice1")
	public CustomResponseMsg selectProductPrice1(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectByExample_zhu();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectProductPrice2")
	public CustomResponseMsg selectProductPrice2(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectByExample_zhe();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectProductPrice3")
	public CustomResponseMsg selectProductPrice3(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectByExample_shan();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectProductPrice4")
	public CustomResponseMsg selectProductPrice4(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartService.selectByExample_zhe1();
		// msg.msg = option.toString();
		return msg;
	}

}
