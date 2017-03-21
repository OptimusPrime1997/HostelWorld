package com.nju.servlet.common;

import com.nju.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class LogoutServlet extends HttpServlet {
	@Autowired
	private UserServiceImpl userServiceImpl;

	public LogoutServlet() {
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
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
		HttpSession hpSession=req.getSession();
		hpSession.invalidate();
		req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
	}
}