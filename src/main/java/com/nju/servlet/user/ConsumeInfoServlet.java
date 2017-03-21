package com.nju.servlet.user;

import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.util.Constant;
import com.nju.util.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class ConsumeInfoServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public ConsumeInfoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/user/consumeInfo.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null&&u.getUserType()==1) {
			List<Order> reservedList = orderServiceImpl.findListByUser(u.getUserno(), OrderState.RESERVED);
//			List<Order> cancelList = orderServiceImpl.findListByHostel(u.getUserno(), OrderState.CANCEL);
			List<Order> checkedList = orderServiceImpl.findListByUser(u.getUserno(), OrderState.CHECKIN);
			List<Order> checkOutList = orderServiceImpl.findListByUser(u.getUserno(), OrderState.CHECKOUT);

			/*日预定量*/
			List<Order> dayReservedList = new ArrayList<Order>();
			dayReservedList.addAll(reservedList);
			dayReservedList.addAll(checkedList);
			dayReservedList.addAll(checkOutList);
			Map<Date, Integer> dayReservedMap = Constant.getOrderMap(dayReservedList);
			List<Map.Entry<Date, Integer>> list = new ArrayList<Map.Entry<Date, Integer>>(dayReservedMap.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Date, Integer>>() {
				//升序排序
				public int compare(Map.Entry<Date, Integer> o1,
				                   Map.Entry<Date, Integer> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			req.setAttribute("dayReservedMap", list);
			/*日入住量*/
			List<Order> dayCheckedList = new ArrayList<Order>();
			dayCheckedList.addAll(checkedList);
			dayCheckedList.addAll(checkOutList);
			Map<java.sql.Date, Integer> dayCheckedMap = Constant.getOrderMap(dayCheckedList);
			List<Map.Entry<Date, Integer>> list2 = new ArrayList<Map.Entry<Date, Integer>>(dayReservedMap.entrySet());
			Collections.sort(list2, new Comparator<Map.Entry<Date, Integer>>() {
				//升序排序
				public int compare(Map.Entry<Date, Integer> o1,
				                   Map.Entry<Date, Integer> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			req.setAttribute("dayCheckedMap", list2);

			//			个人消费情况
			List<Order> myConsumeList = orderServiceImpl.findListByUser(u.getUserno());
			Collections.sort(myConsumeList, new Comparator<Order>() {
				public int compare(Order o1, Order o2) {
					return o1.getEndTime().compareTo(o1.getEndTime());
				}
			});
			req.setAttribute("myConsumeList", myConsumeList);

			req.getRequestDispatcher(resp.encodeURL("/jsp/user/consumeInfo.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}