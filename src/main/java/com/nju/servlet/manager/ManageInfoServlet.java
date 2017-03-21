package com.nju.servlet.manager;

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
public class ManageInfoServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public ManageInfoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/manager/manageInfo.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);

		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null && u.getUserType() == 3) {
			String userno = (String) req.getParameter("queryUserno");
			if (userno == null) {
				userno = "1710001";
			}
			System.out.println("---userno:" + userno);
			req.setAttribute("userno", userno);
//			List<Order> reservedList = orderServiceImpl.findListByUser(userno, OrderState.RESERVED);
////			List<Order> cancelList = orderServiceImpl.findListByHostel(u.getUserno(), OrderState.CANCEL);
//			List<Order> checkedList = orderServiceImpl.findListByUser(userno, OrderState.CHECKIN);
			List<Order> checkOutUserList = orderServiceImpl.findListByUser(userno, OrderState.CHECKOUT);

			/*个人日预定量*/
//			List<Order> dayReservedList = new ArrayList<Order>();
//			dayReservedList.addAll(reservedList);
//			dayReservedList.addAll(checkedList);
//			dayReservedList.addAll(checkOutList);
//			Map<Date, Integer> dayReservedMap = Constant.getOrderMap(dayReservedList);
//			List<Map.Entry<Date, Integer>> list = new ArrayList<Map.Entry<Date, Integer>>(dayReservedMap.entrySet());
//			Collections.sort(list, new Comparator<Map.Entry<Date, Integer>>() {
//				//升序排序
//				public int compare(Map.Entry<Date, Integer> o1,
//				                   Map.Entry<Date, Integer> o2) {
//					return o1.getKey().compareTo(o2.getKey());
//				}
//			});
//			req.setAttribute("dayReservedMap", list);
//			/*个人日入住量*/
//			List<Order> dayCheckedList = new ArrayList<Order>();
//			dayCheckedList.addAll(checkedList);
//			dayCheckedList.addAll(checkOutList);
//			Map<java.sql.Date, Integer> dayCheckedMap = Constant.getOrderMap(dayCheckedList);
//			List<Map.Entry<Date, Integer>> list2 = new ArrayList<Map.Entry<Date, Integer>>(dayCheckedMap.entrySet());
//			Collections.sort(list2, new Comparator<Map.Entry<Date, Integer>>() {
//				//升序排序
//				public int compare(Map.Entry<Date, Integer> o1,
//				                   Map.Entry<Date, Integer> o2) {
//					return o1.getKey().compareTo(o2.getKey());
//				}
//			});
			req.setAttribute("userList", checkOutUserList);

			/*酒店入住*/
			String hostelno = (String) req.getParameter("queryHostelno");
			if (hostelno == null) {
				hostelno = "1720001";
			}
			System.out.println("---hostelno:" + hostelno);
			req.setAttribute("hostelno", hostelno);
//			List<Order> reservedList = orderServiceImpl.findListByUser(userno, OrderState.RESERVED);
//			List<Order> cancelList = orderServiceImpl.findListByHostel(u.getUserno(), OrderState.CANCEL);
			List<Order> checkedList = orderServiceImpl.findListByHostel(hostelno, OrderState.CHECKIN);
			List<Order> checkOutList = orderServiceImpl.findListByHostel(hostelno, OrderState.CHECKOUT);
			List<Order> dayCheckedList = new ArrayList<Order>();
			dayCheckedList.addAll(checkedList);
			dayCheckedList.addAll(checkOutList);
//			for(Order o:dayCheckedList){
//				System.out.println("dayCheckedList:"+o.toString());
//			}
			Map<java.sql.Date, Integer> dayCheckedMap = Constant.getOrderMap(dayCheckedList);
			List<Map.Entry<Date, Integer>> list2 = new ArrayList<Map.Entry<Date, Integer>>(dayCheckedMap.entrySet());
			Collections.sort(list2, new Comparator<Map.Entry<Date, Integer>>() {
				//升序排序
				public int compare(Map.Entry<Date, Integer> o1,
				                   Map.Entry<Date, Integer> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
			});
			req.setAttribute("hostelList", list2);

			/*网站日营业额折线图---需要改进*/
			List<Order> allList = orderServiceImpl.findList(OrderState.CHECKOUT);
			req.setAttribute("allList", allList);
			/*if (reservedList != null && !reservedList.isEmpty()) {
				System.out.println("MyOrderServlet->dopost completedList size:" + reservedList.size());
				Collections.sort(reservedList, new Comparator<Order>() {
					public int compare(Order o1, Order o2) {
						return o1.getEndTime().compareTo(o1.getEndTime());
					}
				});
				req.setAttribute("reservedList", reservedList);
			} else {
				System.out.println("ConsumeServlet:get orderList failed!");
			}*/
			req.getRequestDispatcher(resp.encodeURL("/jsp/manager/manageInfo.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}