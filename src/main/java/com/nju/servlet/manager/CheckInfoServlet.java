package com.nju.servlet.manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
public class CheckInfoServlet extends HttpServlet {
	public CheckInfoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		req.getRequestDispatcher(resp.encodeURL("/jsp/manager/checkInfo.jsp")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
	}
}