package com.nju.servlet.hostel.action;

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

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class CheckInServlet extends HttpServlet {
	@Autowired
	private OrderService orderServiceImpl;
	@Autowired
	private RoomdisplayService roomdisplayServiceImpl;
	@Autowired
	private RoomService roomServiceImpl;

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			int peopleNum = Integer.parseInt(req.getParameter("peopleNum"));
			int roomNum = Integer.parseInt(req.getParameter("roomNum"));
			String roomno = req.getParameter("roomno");
			String roomno1=roomno;
			String start = req.getParameter("Start");
			String end = req.getParameter("End");
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			RoomType roomType = RoomType.getRoomType(Integer.parseInt(req.getParameter("roomType")));
			String phoneNum = req.getParameter("phoneNum");
			System.out.println("peopleNum:" +
					"roomNum:" +
					"roomno:" +
					"Start:" +
					"End:" +
					"id:" +
					"name:" +
					"roomType:" +
					"phoneNum:");
			if (peopleNum == 2) {
				name = name + "&" + req.getParameter("name1");
			}
			if (roomNum == 2) {
				roomno1 = roomno + req.getParameter("roomno1");
			}

			String hostelno = u.getUserno();
			if (hostelno == null || "".equals(hostelno) || roomno == null || "".equals(roomno)
					|| start == null || "".equals(start) ||
					end == null || "".equals(end)) {
				hostelno = "1720001";
				roomno = "1001";
				start = "2017-03-21";
				end = "2017-03-22";
			}
			double saleRatio = 0.0;

			Date startTime = Date.valueOf(start);
			Date endTime = Date.valueOf(end);
			int dateDistance = Constant.getDateDistance(startTime, endTime);

			String ordertime = Constant.getTimeFormatString();
			String orderno = hostelno + ordertime;
			Roomdisplay rd = roomdisplayServiceImpl.get(hostelno, roomno);

			System.out.println("dateDistance:" + dateDistance +
					"price:" + rd.getPrice() +
					"roomNum:" + roomNum);
			double amount = 0.0;
			amount = dateDistance * rd.getPrice() * roomNum;
			double saleOff = amount * saleRatio;
			double pay = amount - saleOff;

			/*Order(String orderno, String hostelno,
					Timestamp ordertime, RoomType roomType,
			int roomPrice, Date startTime, Date endTime,
			int roomNum, double amount, double saleRatio,
			double saleOff, double pay, String memberno,
					PayType payType, OrderState orderState)*/
			Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
			Order order = new Order(orderno, hostelno, timestamp, roomType,
					rd.getPrice(), startTime, endTime, Integer.parseInt(roomno1),
					amount, saleRatio, saleOff, pay, null,
					PayType.CASH, OrderState.CHECKIN);
			orderServiceImpl.add(order);
//			Room(String hostelno, String roomno, RoomType roomType, String roomTimeState) ;
			String roomTimeState = Constant.getDateString(start, end);
			Room r = roomServiceImpl.get(hostelno, roomno);
			r.setRoomTimeState(r.getRoomTimeState() + roomTimeState);
			roomServiceImpl.update(r);
//			Room r=new Room(hostelno,roomno,rd.getRoomType(),roomTimeState);

			System.out.println("hostelno:" + hostelno + "roomno:" + roomno);
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelManageServlet")).forward(req, resp);
		}
	}
}
