package com.nju.servlet.user;

import com.nju.bl.UserState;
import com.nju.entity.Order;
import com.nju.entity.Room;
import com.nju.entity.Roomdisplay;
import com.nju.entity.User;
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
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class ReserveServlet extends HttpServlet {
	@Autowired
	private RoomdisplayService roomdisplayServiceImpl;
	@Autowired
	private OrderService orderServiceImpl;
	@Autowired
	private RoomService roomServiceImpl;

	public RoomdisplayService getRoomdisplayServiceImpl() {
		return roomdisplayServiceImpl;
	}

	public void setRoomdisplayServiceImpl(RoomdisplayService roomdisplayServiceImpl) {
		this.roomdisplayServiceImpl = roomdisplayServiceImpl;
	}

	public OrderService getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderService orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	public ReserveServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/user/reserve.jsp")).forward(req, resp);
		this.doPost(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
//		PrintWriter out=resp.getWriter();
//		out.println("ReserveServlet->dopost:println");
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		String start=req.getParameter("Start");
		String end=req.getParameter("End");
		if(start==null||end==null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			java.util.Date now=new java.util.Date();
			java.util.Date next=new Date(now.getTime()+24*3600*1000);
			start=sdf.format(now.getTime());
			end=sdf.format(next.getTime());
		}
//		查找需要加上日期

		if (u != null && u.getUserType() == 1) {
			List<Roomdisplay> roomdisplayList = roomdisplayServiceImpl.findAll();
			req.setAttribute("roomdisplayList", roomdisplayList);

			req.getRequestDispatcher(resp.encodeURL("/jsp/user/reserve.jsp")).forward(req, resp);
		} else {
			System.out.println("ReserveServlet get user failed!");
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}

	}
}