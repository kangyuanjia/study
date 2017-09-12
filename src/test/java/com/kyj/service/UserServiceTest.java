package com.kyj.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kyj.po.User;
import com.kyj.po.UserCustom;
import com.kyj.po.UserQueryVo;

/**
 * <p>
 * Title: UserServiceTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author kangyuanjia
 * @date 2016年4月8日 上午12:52:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring*xml" })
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void testFindUserById() throws Exception {
		User user = userService.findUserById(1);
		assertThat(user, notNullValue());
	}

	@Test
	public void testFindUserByName() throws Exception {
		List<User> userList = userService.findUserByName("%三%");
		assertThat(userList.size(), greaterThan(0));
	}

	@Test
	public void testFindUserList() throws Exception {
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		// 由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		// userCustom.setSex("1");
		userCustom.setUsername("小明");
		// 传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		// 将ids通过userQueryVo传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		List<User> userList = userService.findUserList(userQueryVo);
		System.out.println(userList.size());
		assertThat(userList.size(), greaterThan(0));
	}

	@Test
	public void testCache1() throws Exception {
		 userService.Cache1(1);
	}

	@Test
	public void testCache2() throws Exception {
		User user1 =userService.findUserById(1);
		System.out.println(user1.getUsername());
		User user2 =userService.findUserById(1);
		System.out.println(user2.getUsername());
		assertThat(user1.getUsername(), equalTo(user2.getUsername()));
	}
}
