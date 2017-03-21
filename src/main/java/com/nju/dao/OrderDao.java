package com.nju.dao;


import com.nju.entity.Order;
import com.nju.util.OrderState;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface OrderDao {

	public void add(Order u);

	public void delete(String orderno);

	public void update(Order order);

	public Order get(String orderno);

	public List<Order> findAll();

	public List<Order> findListByUser(String userno, OrderState orderState);

	public List<Order> findListByHostel(String hostelno, OrderState orderState);

	public List<Order> findListByUser(String userno);

	public List<Order> findList(OrderState orderState);
}
