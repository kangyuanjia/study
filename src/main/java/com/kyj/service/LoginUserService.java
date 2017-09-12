package com.kyj.service;

import org.springframework.stereotype.Service;

import com.kyj.po.LoginUser;

@Service
public interface LoginUserService {

	// 根据用户名列查询用户列表
	public LoginUser findUser(LoginUser user) throws Exception;
}
