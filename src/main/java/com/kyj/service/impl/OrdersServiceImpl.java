package com.kyj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyj.mapper.OrdersMapper;
import com.kyj.mapper.OrdersMapperCustom;
import com.kyj.po.Orders;
import com.kyj.po.OrdersCustom;
import com.kyj.po.User;
import com.kyj.po.UserExample;
import com.kyj.po.UserQueryVo;
import com.kyj.service.OrdersService;

/** 
 * <p>Title: UserServiceImpl </p> 
 * <p>Description:</p> 
 * @author kangyuanjia 
 * @date 2016年4月7日 下午10:31:44 
 */ 
@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
	private OrdersMapperCustom ordersMapperCustom;
	
	@Override
	public List<OrdersCustom> findOrdersUser() throws Exception {
		List<OrdersCustom> ordersList = ordersMapperCustom.findOrdersUser();
		return ordersList;
	}
	@Override
	public List<Orders> findOrdersUserResultMap() throws Exception {
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserResultMap();
		return ordersList;
	}
	@Override
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception {
		List<Orders> ordersList = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		return ordersList;
	}
	@Override
	public List<User> findUserAndItemsResultMap() throws Exception {
		List<User> userList = ordersMapperCustom.findUserAndItemsResultMap();
		return userList;
	}
	@Override
	public List<Orders> findOrdersUserLazyLoading() throws Exception {
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserLazyLoading();
		return ordersList;
	}

}
