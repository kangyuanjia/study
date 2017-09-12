package com.kyj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kyj.po.User;
import com.kyj.po.UserQueryVo;

@Service
public interface UserService {

	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;
	

	// 根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	// 删除用户信息
	public void deleteUser(int id) throws Exception;
	// 用户信息的综合 查询
	List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

	// 根据id查询用户信息
	public void Cache1(int id) throws Exception;
}
