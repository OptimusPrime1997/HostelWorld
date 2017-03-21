package com.nju.servlet.manager;

import com.nju.entity.Order;
import com.nju.entity.Payment;
import com.nju.entity.User;
import com.nju.service.PaymentService;
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
import java.sql.Date;
import java.util.*;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class PayoffServlet extends HttpServlet {
	@Autowired
	private PaymentService paymentServiceImpl;
	@Autowired
	private UserService userServiceImpl;


	public PaymentService getPaymentServiceImpl() {
		return paymentServiceImpl;
	}

	public void setPaymentServiceImpl(PaymentService paymentServiceImpl) {
		this.paymentServiceImpl = paymentServiceImpl;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public PayoffServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/manager/payoff.jsp")).forward(req, resp);
		this.doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if(u!=null){
			System.out.println(u.toString());
		}

		if (u != null&&u.getUserType()==3) {
			List<User> hostelList=userServiceImpl.findToPay();
			req.setAttribute("unpayList",hostelList);
			List<Payment> paidList=paymentServiceImpl.findAll();
			Collections.sort(paidList);
			req.setAttribute("paidList",paidList);

			req.getRequestDispatcher(resp.encodeURL("/jsp/manager/payoff.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}