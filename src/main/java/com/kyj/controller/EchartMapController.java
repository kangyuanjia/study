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
import com.kyj.service.EchartMapService;
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
@RequestMapping(value = "/echartMap")
public class EchartMapController {
	@Autowired
	private EchartMapService echartMapService;

	@ResponseBody
	@RequestMapping(value = "/selectMap1")
	public CustomResponseMsg selectMap(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartMapService.selectMap1();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectMap2")
	public CustomResponseMsg selectMap2(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartMapService.selectMap2();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectMap3")
	public CustomResponseMsg selectMap3(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartMapService.selectMap3();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectMap4")
	public CustomResponseMsg selectMap4(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartMapService.selectMap4();
		// msg.msg = option.toString();
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectMap5")
	public CustomResponseMsg selectMap5(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomResponseMsg msg = new CustomResponseMsg();
		// Option option= echartService.selectRemoveCauses();
		msg.data = echartMapService.selectMap5();
		// msg.msg = option.toString();
		return msg;
	}
	

}
