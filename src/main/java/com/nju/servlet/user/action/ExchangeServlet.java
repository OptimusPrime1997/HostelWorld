package com.nju.servlet.user.action;

import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.UserService;
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
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class ExchangeServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		this.doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null && u.getUserType() == 1) {
			double balance=u.getBalance()+u.getScore()* Constant.exchangeRatio;
			u.setBalance(balance);
			u.setScore(0.0);
			userServiceImpl.update(u);
			session.setAttribute("user",u);
			req.getRequestDispatcher(resp.encodeURL("/IndividualServlet")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}
