package com.nju.servlet.common;

import com.nju.entity.User;
import com.nju.service.UserService;
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
public class LoginServlet extends HttpServlet {
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
		req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		String userid = req.getParameter("userno");
		String password = req.getParameter("password");
		System.out.println("userid:" + userid + "password:" + password);
		if (userid != null && password != null) {
			if (userServiceImpl == null) {
				System.out.println("autowired failed!");
			}
			User user = userServiceImpl.checkLogin(userid, password);
			if (user != null) {
				System.out.println("LoginServlet:dopost->" + user.toString());
				HttpSession session = req.getSession(true);
				session.setAttribute("userno", userid);
				session.setAttribute("userType", user.getUserType());
				session.setAttribute("user", user);
				String url = "/LoginServlet";
				switch (user.getUserType()) {
					case 1:
						url = "/ReserveServlet";
						break;
					case 2:
						url = "/HostelManageServlet";
						break;
					case 3:
						url = "/CheckInfoServlet";
						break;
					default:
						System.out.println("LoginServlet->dopost error!");
				}
//				req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
				req.getRequestDispatcher(resp.encodeURL(url)).forward(req, resp);
			} else {
				System.out.println("You input the password is wrong!");
				req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
			}
		}


	}
}
