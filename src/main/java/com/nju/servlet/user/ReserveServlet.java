package com.nju.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
public class ReserveServlet extends HttpServlet {
	public ReserveServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		req.getRequestDispatcher(resp.encodeURL("/jsp/user/reserve.jsp")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		PrintWriter out=resp.getWriter();
		out.println("ReserveServlet->dopost:println");
	}
}