package com.nju.servlet.user.action;

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
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class ModifyServlet extends HttpServlet {
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
		System.out.println("UModifyServlet->doGet");
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null && u.getUserType() == 1) {
			String name = req.getParameter("name");
			String id = req.getParameter("id");
			String phoneNum = req.getParameter("phoneNum");
			String address = req.getParameter("address");
			String bankAccount = req.getParameter("bankAccount");

			u.setName(name);
			u.setId(id);
			u.setPhoneNum(phoneNum);
			u.setAddress(address);
			u.setBankAccount(bankAccount);
			userServiceImpl.update(u);
			session.setAttribute("user", u);
			System.out.println("update user info successfully!");

			req.getRequestDispatcher(resp.encodeURL("/IndividualServlet")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}
