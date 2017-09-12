package com.kyj.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonOption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*xml" })
public class EchartMapServiceTest {
	@Autowired
	EchartMapService echartMapService;
	@Test
	public void testSelectMap4() throws Exception {
		Option option =  echartMapService.selectMap4();
		System.out.println(JSON.toJSONString(option));
	}
	
	@Test
	public void testSelectMap5() throws Exception {
		Option option =  echartMapService.selectMap5();
		System.out.println(JSON.toJSONString(option));
	}

}
