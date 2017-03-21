package com.nju.servlet.user;

import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.util.OrderState;
import com.nju.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class MyOrderServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public MyOrderServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/user/myOrder.jsp")).forward(req, resp);
		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null && u.getUserType() == 1) {
			List<Order> allList = orderServiceImpl.findListByUser(u.getUserno());
			if (allList != null && !allList.isEmpty()) {
				for (Order o : allList) {
					System.out.println(o.toString());
				}
				List<Order> reservedList = orderServiceImpl.findList(OrderState.RESERVED, allList);
				List<Order> checkInList = orderServiceImpl.findList(OrderState.CHECKIN, allList);
				System.out.println("MyOrderServlet->dopost checkinlist size:" + checkInList.size());
				List<Order> checkOutList = orderServiceImpl.findList(OrderState.CHECKOUT, allList);
				List<Order> cancelList = orderServiceImpl.findList(OrderState.CANCEL, allList);
				checkOutList.addAll(cancelList);
				System.out.println("MyOrderServlet->dopost completedList size:" + checkOutList.size());
//				req.setAttribute("allList", allList);
				req.setAttribute("reservedList", reservedList);
				req.setAttribute("checkInList", checkInList);
				req.setAttribute("checkOutList", checkOutList);
			} else {
				System.out.println("MyOrderServlet:get orderList failed!");
			}
			req.getRequestDispatcher(resp.encodeURL("/jsp/user/myOrder.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}