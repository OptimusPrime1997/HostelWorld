package com.nju.servlet.common;

import com.nju.entity.User;
import com.nju.service.UserService;
import com.nju.service.impl.UserServiceImpl;
import com.nju.util.Constant;
import com.nju.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class RegisteServlet extends HttpServlet {
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
		req.getRequestDispatcher(resp.encodeURL("/jsp/common/registe.jsp")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		String address = req.getParameter("address");
		String bankAccount = req.getParameter("bankAccount");
//		System.out.println(req.getParameter("userType"));
		int userType = Integer.parseInt(req.getParameter("userType"));

		String name = req.getParameter("name");
		String phoneNum = req.getParameter("phoneNum");
		String password = req.getParameter("passwordInput");
		if(password==null){
			password="123456";
		}
		String id = req.getParameter("id");
		double balance = 0;
		User newU = new User();
		newU.setAddress(address);
		newU.setBalance(balance);
		newU.setBankAccount(bankAccount);
		newU.setName(name);
		newU.setPassword(password);
		if (userType == 1) {
			newU.setUserType(userType);
		} else {
			newU.setUserType(0);
		}
		if (userType == 1) {
			newU.setState(State.INACTIVE);
		} else {
			newU.setState(State.NORMAL);
		}
		newU.setPhoneNum(phoneNum);
		newU.setId(id);
		System.out.println(newU.toString());
		String userno = userServiceImpl.add(newU);

//		login
		if (userno != null && password != null) {
			System.out.println("The userno you get:" + userno);
			if (userServiceImpl == null) {
				System.out.println("autowired failed!");
			}
			User user = userServiceImpl.checkLogin(userno, password);
			if (user != null) {
				HttpSession session = req.getSession(true);
				/*session.setAttribute("userno", userno);
				session.setAttribute("userType", user.getUserType());*/
				session.setAttribute("user", user);
				String url = "/RegisteServlet";
				switch (user.getUserType()) {
					case 0:
						url = "/jsp/common/login.jsp";
						break;
					case 1:
						url = "/IndividualServlet";
						break;
					/*case 3:
						url = "/CheckInfoServlet";
						break;*/
					default:
						System.out.println("RegisteServlet->dopost error!");
				}
				req.getRequestDispatcher(resp.encodeURL(url)).forward(req, resp);
			} else {
				System.out.println("Your registration is failed!");
				req.getRequestDispatcher(resp.encodeURL("/jsp/common/registe.jsp")).forward(req, resp);
			}
		}
	}
}
