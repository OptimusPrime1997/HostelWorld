package com.nju.servlet.hostel.action;

import com.nju.entity.Order;
import com.nju.entity.Room;
import com.nju.entity.Roomdisplay;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.service.RoomService;
import com.nju.service.RoomdisplayService;
import com.nju.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class MakeCheckServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			String orderno = req.getParameter("orderno");
			Order order = orderServiceImpl.get(orderno);
			if (order.getOrderState() == OrderState.CHECKIN) {
				order.setOrderState(OrderState.CHECKOUT);
				orderServiceImpl.update(order);
			} else {
				System.out.println("The order state isn't CheckIn!");
			}
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			String orderno = req.getParameter("orderno");
			Order order = orderServiceImpl.get(orderno);
			if (order.getOrderState() == OrderState.RESERVED) {
				order.setOrderState(OrderState.CHECKIN);
				orderServiceImpl.update(order);
			} else {
				System.out.println("The order state isn't Reserved!");
			}
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		}
	}
}
