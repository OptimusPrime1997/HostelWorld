package com.nju.service.test;

import com.nju.entity.Order;
import com.nju.service.impl.OrderServiceImpl;
import com.nju.util.OrderState;
import com.nju.util.PayType;
import com.nju.util.RoomType;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class OrderServiceImplTest {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	private Timestamp timestamp = new Timestamp(new Date().getTime());
	public String getOrderno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		return "1720002" + sdf.format(timestamp.getTime());
	}

	public OrderServiceImplTest() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		orderServiceImpl = (OrderServiceImpl) factory.getBean("orderServiceImpl");
	}

	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}


	//	@Test
	public void Aadd() throws Exception {
//		172000120170310112526	2017-03-10 11:25:26	STANDARD	188	2017-03-09	2017-03-10	1001	188	0	0	188	1710001	RESERVED	MEMBERCARD
		Order u = new Order(getOrderno(), "1720001", timestamp,
				RoomType.STANDARD, 188, java.sql.Date.valueOf("2017-03-13")
				, java.sql.Date.valueOf("2017-03-14"), 1002, 188, 0, 0, 188, "1710001", PayType.MEMBERCARD, OrderState.RESERVED);
		orderServiceImpl.add(u);
		System.out.println("add member order successfully!id:" + u.getOrdertime());
	}

	//	@Test
	public void Ddelete() throws Exception {
		orderServiceImpl.delete(getOrderno());
		System.out.println("delete member order successfully!id:" + "1710100");
	}

	//	@Test
	public void Bupdate() throws Exception {
		Order u = new Order(getOrderno(), "1720001", timestamp,
				RoomType.STANDARD, 188, java.sql.Date.valueOf("2017-03-13")
				, java.sql.Date.valueOf("2017-03-14"), 1005, 188, 0, 0, 188, "1710001", PayType.MEMBERCARD, OrderState.RESERVED);

		orderServiceImpl.update(u);
		System.out.println("update member order successfully!id:" + u.getOrdertime());
	}

	//	@Test
	public void Cget() throws Exception {
		String uid = getOrderno();
		Order order = orderServiceImpl.get(uid);
		if (order != null) {
			System.out.println(order.toString());
		} else {
			System.out.println("get order failed!");
		}

	}

	//	@Test
	public void EfindAll() throws Exception {
		List<Order> orderList = orderServiceImpl.findAll();
		for (Order u : orderList) {
			System.out.println("List:" + u.toString());
		}
	}

	public static void main(String[] args) {
		OrderServiceImplTest usit = new OrderServiceImplTest();
		try {
			usit.Aadd();
			usit.Bupdate();
			usit.Cget();
			usit.Ddelete();
			usit.EfindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}