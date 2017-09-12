package com.kyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyj.mapper.LoginUserMapper;
import com.kyj.po.LoginUser;
import com.kyj.po.LoginUserExample;
import com.kyj.service.LoginUserService;
@Service
public class LoginUserServiceImpl implements LoginUserService {
	@Autowired
	private LoginUserMapper userMapper;
	@Override
	public LoginUser findUser(LoginUser user) throws Exception {
		LoginUserExample userExample = new LoginUserExample();
		LoginUserExample.Criteria criteria=userExample.createCriteria();  
		criteria.andUserIdEqualTo(user.getUserId());
		criteria.andUserPwdEqualTo(user.getUserPwd());
		
		List<LoginUser> list = userMapper.selectByExample(userExample);
		if(list.size() >0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
