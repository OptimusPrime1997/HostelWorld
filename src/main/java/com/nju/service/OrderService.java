package com.nju.service;

import com.nju.entity.Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public interface OrderService {


	public void add(Order u);

	public void delete(String orderno);

	public void update(Order order);

	public Order get(String orderno);

	public List<Order> findAll();
}
