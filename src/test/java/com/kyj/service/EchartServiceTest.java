package com.kyj.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.abel533.echarts.json.GsonOption;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring*xml" })
public class EchartServiceTest {

	@Autowired
	EchartService echartService;
	@Test
	public void testSelectRemoveCauses() throws Exception{
		GsonOption option= (GsonOption) echartService.selectRemoveCauses();
		System.out.println(option.toString());
	}

}
