package com.nju.servlet.user;

import com.nju.entity.Roomdisplay;
import com.nju.entity.User;
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
public class IndividualServlet extends HttpServlet {
	public IndividualServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/user/individual.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null && u.getUserType() == 1) {
			req.getRequestDispatcher(resp.encodeURL("/jsp/user/individual.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}