package com.nju.servlet.hostel;

import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.util.OrderState;
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
public class HostelManageServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public HostelManageServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/hostel/hostelManage.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null && user.getUserType() == 2) {
			List<Order> reservedList = orderServiceImpl.findListByHostel(user.getUserno(), OrderState.RESERVED);
			List<Order> checkInList = orderServiceImpl.findListByHostel(user.getUserno(), OrderState.CHECKIN);
			System.out.println("MyOrderServlet->dopost checkinlist size:" + checkInList.size());
			List<Order> checkOutList = orderServiceImpl.findListByHostel(user.getUserno(), OrderState.CHECKOUT);
			List<Order> cancelList = orderServiceImpl.findListByHostel(user.getUserno(), OrderState.CHECKOUT);
			checkOutList.addAll(cancelList);
			System.out.println("MyHostelOrderServlet->dopost completedList size:" + checkOutList.size());
			req.setAttribute("reservedList", reservedList);
			req.setAttribute("checkInList", checkInList);
			req.setAttribute("checkOutList", checkOutList);

			req.getRequestDispatcher(resp.encodeURL("/jsp/hostel/hostelManage.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/LoginServlet")).forward(req, resp);
		}
	}
}
