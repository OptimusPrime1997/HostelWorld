package com.nju.servlet.user.action;

import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.service.UserService;
import com.nju.util.Constant;
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

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class CancelServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			State state = u.getState();
			String orderno = req.getParameter("Orderno");
			if (orderno != null) {
				Order order = orderServiceImpl.get(orderno);
				order.setOrderState(OrderState.CANCEL);
				orderServiceImpl.update(order);

				User hostel = userServiceImpl.get(order.getHostelno());
				double backMoney = order.getPay() * Constant.BACKRATIO;
				u.setBalance(u.getBalance() - backMoney);
				userServiceImpl.update(u);
				hpSession.setAttribute("user", u);
				hostel.setBalance(hostel.getBalance() + backMoney);
				userServiceImpl.update(hostel);

				String greetings = "取消预定" + orderno + "成功！";
				resp.setContentType("text/plain");
				resp.getWriter().write(greetings);
			} else {
				String greetings = "取消预定出错！orderno is null!";
				resp.setContentType("text/plain");
				resp.getWriter().write(greetings);
			}
		} else {
			String greetings = "取消预定出错！";
			resp.setContentType("text/plain");
			resp.getWriter().write(greetings);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
