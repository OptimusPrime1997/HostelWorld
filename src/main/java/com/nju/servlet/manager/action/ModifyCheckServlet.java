package com.nju.servlet.manager.action;

import com.nju.entity.*;
import com.nju.service.*;
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
public class ModifyCheckServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	/**
	 * it's for reject modify apply
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null && u.getUserType() == 3) {
			String hostelno = req.getParameter("hostelno");
			if (hostelno != null) {
				userServiceImpl.delete(hostelno);
				System.out.println("join apply rejected!");
			}
			System.out.println("modifycheckservelt->doget:modify apply send successfully!");
			req.getRequestDispatcher(resp.encodeURL("/CheckInfoServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/CheckInfoServlet")).forward(req, resp);
		}

	}

	/**
	 * it's pass the modify apply
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null && u.getUserType() == 3) {
			String rawHostelno = req.getParameter("rawHostelno");
			String modifyHostelno = req.getParameter("modifyHostelno");
			System.out.println("rawHostelno:" + rawHostelno + "---modifyHostelno:" + modifyHostelno);
			if (rawHostelno != null && modifyHostelno != null) {
				User modifyHostel = userServiceImpl.get(modifyHostelno);
				userServiceImpl.delete(rawHostelno);
				userServiceImpl.delete(modifyHostelno);

				modifyHostel.setUserType(2);
				modifyHostel.setUserno(rawHostelno);
				userServiceImpl.save(modifyHostel);
				System.out.println("modifycheckservelt->dopost:modify apply pass successfully!");
			}
			req.getRequestDispatcher(resp.encodeURL("/CheckInfoServlet")).forward(req, resp);
		} else {
			System.out.println("pass check failed!");
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}
