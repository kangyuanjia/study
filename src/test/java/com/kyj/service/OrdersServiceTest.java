package com.kyj.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kyj.po.Orders;
import com.kyj.po.OrdersCustom;
import com.kyj.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring*xml" })
public class OrdersServiceTest {
	@Autowired
	private OrdersService ordersService;

	@Test
	public void testFindOrdersUser() throws Exception {
		/*一对一查询*/
		List<OrdersCustom> list = ordersService.findOrdersUser();
		assertThat(list.size(), greaterThan(0));
	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		List<Orders> list = ordersService.findOrdersUserResultMap();
		assertThat(list.size(), greaterThan(0));
	}

	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		/*一对多查询*/
		List<Orders> list = ordersService.findOrdersAndOrderDetailResultMap();
		assertThat(list.size(), greaterThan(0));
	}

	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		/*多对多查询*/
		List<User> list = ordersService.findUserAndItemsResultMap();
		assertThat(list.size(), greaterThan(0));
	}

	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		List<Orders> list = ordersService.findOrdersUserLazyLoading();

		// 遍历上边的订单列表
		for (Orders orders : list) {
			// 执行getUser()去查询用户信息，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user.getUsername());
		}
		assertThat(list.size(), greaterThan(0));
	}

}
