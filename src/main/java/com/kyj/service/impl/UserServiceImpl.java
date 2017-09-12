package com.kyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyj.mapper.UserMapper;
import com.kyj.po.User;
import com.kyj.po.UserExample;
import com.kyj.po.UserQueryVo;
import com.kyj.service.UserService;

/** 
 * <p>Title: UserServiceImpl </p> 
 * <p>Description:</p> 
 * @author kangyuanjia 
 * @date 2016年4月7日 下午10:31:44 
 */ 
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(int id) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}
	
	@Override
	public void Cache1(int id) throws Exception {
		User user1 = userMapper.selectByPrimaryKey(id);
		System.out.println(user1.getUsername());
		User user2 = userMapper.selectByPrimaryKey(id);
		System.out.println(user2.getUsername());
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();  
		criteria.andUsernameLike(name) ;
		List<User> list = userMapper.selectByExample(userExample);
		return list;
	}
	
	@Override
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria=userExample.createCriteria();  
		criteria.andIdIn(userQueryVo.getIds());
		
		UserExample.Criteria criteria2=userExample.createCriteria();  
		criteria2.andUsernameEqualTo(userQueryVo.getUserCustom().getUsername());
		userExample.or(criteria2);
		List<User> list = userMapper.selectByExample(userExample);
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		userMapper.insert(user);
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	}

}
