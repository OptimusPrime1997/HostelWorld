package com.nju.service.impl;

import com.nju.dao.OrderDao;
import com.nju.entity.Order;
import com.nju.service.OrderService;
import com.nju.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
//	public OrderServiceImpl() {
//		this.orderDaoImpl= DaoFactory.getOrderDao();
//	}
	@Autowired
	private OrderDao orderDaoImpl;

	public OrderDao getOrderDaoImpl() {
		return orderDaoImpl;
	}

	public void setOrderDaoImpl(OrderDao orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}

	public void add(Order u) {
		orderDaoImpl.add(u);
	}

	public void delete(String orderno) {
		orderDaoImpl.delete(orderno);
	}

	public void update(Order d) {
		orderDaoImpl.update(d);
	}

	public Order get(String orderno) {
		return orderDaoImpl.get(orderno);
	}

	public List<Order> findAll() {
		return orderDaoImpl.findAll();
	}

	public List<Order> findList(OrderState orderState, List<Order> orderList) {
		if (orderList == null) {
			orderList = findAll();
		}
		List<Order> resultList = new ArrayList<Order>();
		for (Order o : orderList) {
			if (o.getOrderState() == orderState) {
				resultList.add(o);
			}
		}
		return resultList;
	}

	public List<Order> findList(OrderState orderState) {
		return orderDaoImpl.findList(orderState);
	}

	public List<Order> findListByUser(String userno,OrderState orderState) {
		return orderDaoImpl.findListByUser(userno,orderState);
	}

	public List<Order> findListByUser(String userno) {
		return orderDaoImpl.findListByUser(userno);
	}

	public List<Order> findListByHostel(String hostelno,OrderState orderState) {
		return orderDaoImpl.findListByHostel(hostelno,orderState);
	}
}
