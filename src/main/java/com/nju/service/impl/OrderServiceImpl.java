package com.nju.service.impl;

import com.nju.dao.OrderDao;
import com.nju.entity.Order;
import com.nju.entity.Order;
import com.nju.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

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
}
