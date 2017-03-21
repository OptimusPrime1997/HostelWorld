package com.nju.servlet.hostel.action;

import com.nju.entity.*;
import com.nju.service.HostelplanService;
import com.nju.service.OrderService;
import com.nju.service.RoomService;
import com.nju.service.RoomdisplayService;
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
public class PublishPlanServlet extends HttpServlet {
	@Autowired
	private HostelplanService hostelplanServiceImpl;

	public HostelplanService getHostelplanServiceImpl() {
		return hostelplanServiceImpl;
	}

	public void setHostelplanServiceImpl(HostelplanService hostelplanServiceImpl) {
		this.hostelplanServiceImpl = hostelplanServiceImpl;
	}


	/**
	 * it's for delplan
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
		if (u != null) {
			String hostelplanno = req.getParameter("hostelplanno");
			if (hostelplanno != null) {
				hostelplanServiceImpl.delete(hostelplanno);
			} else {
				System.out.println("delete hostelplan error!");
			}
			req.getRequestDispatcher(resp.encodeURL("/HostelPlanServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelPlanServlet")).forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			String hostelno = u.getUserno();
			String start = req.getParameter("start_time");
			String end = req.getParameter("end_time");
			if (start == null) {
				start = "2017-03-21";
			}
			if (end == null) {
				end = "2018-03-21";
			}
			String hostelplanno = hostelno + Constant.getTimeFormatString();
			Date startDate = Date.valueOf(start);
			Date endDate = Date.valueOf(end);
			PlanState ps = PlanState.NOW;
			if (startDate.after(new Date(new java.util.Date().getTime()))) {
				System.out.println("startDate:" + startDate.toString() + "endDate:" + (new Date(new java.util.Date().getTime())).toString());
				ps = PlanState.FUTURE;
			}
			int price = Integer.parseInt(req.getParameter("price"));
			RoomType roomType = RoomType.getRoomType(Integer.parseInt(req.getParameter("roomType")));
//			Hostelplan(String hostelplanno, String hostelno, Date startDate, Date endDate, RoomType roomType, int price, PlanState planState) {
			Hostelplan hostelplan = new Hostelplan(hostelplanno, hostelno, startDate, endDate, roomType, price, ps);
			hostelplanServiceImpl.add(hostelplan);

			req.getRequestDispatcher(resp.encodeURL("/HostelPlanServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelPlanServlet")).forward(req, resp);
		}
	}
}
