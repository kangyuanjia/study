package com.kyj.service;

import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Option;

@Service
public interface EchartService {
	
	public Option selectRemoveCauses() throws Exception;
	public Option selectByExample() throws Exception;
	public Option selectByExample_zhu() throws Exception;
	public Option selectByExample_zhe() throws Exception;
	public Option selectByExample_zhe1() throws Exception;
	public Option selectByExample_shan() throws Exception;
	

}
