package com.nju.servlet.user.action;

import com.nju.entity.Order;
import com.nju.entity.Room;
import com.nju.entity.Roomdisplay;
import com.nju.entity.User;
import com.nju.service.OrderService;
import com.nju.service.RoomdisplayService;
import com.nju.service.UserService;
import com.nju.util.Constant;
import com.nju.util.OrderState;
import com.nju.util.PayType;
import com.nju.util.State;
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
public class MyReserveServlet extends HttpServlet {
	@Autowired
	private RoomdisplayService roomdisplayServiceImpl;
	@Autowired
	private OrderService orderServiceImpl;
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
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
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			State state = u.getState();
			if (state == State.VIP || state == State.NORMAL) {
				String hostelno = req.getParameter("Hostelno").trim();
				String roomno = req.getParameter("Roomno").trim();
				String start = req.getParameter("Start").trim();
				String end = req.getParameter("End").trim();
				if (hostelno == null || "".equals(hostelno) || roomno == null || "".equals(roomno)
						|| start == null || "".equals(start) ||
						end == null || "".equals(end)) {
					hostelno = "1720001";
					roomno = "1001";
					start = "2017-03-21";
					end = "2017-03-22";
				}
				double saleRatio = 0.0;
				if (state == State.VIP) {
					saleRatio = 0.1;
				} else {
					saleRatio = 0.0;
				}

				Date startTime = Date.valueOf(start);
				Date endTime = Date.valueOf(end);
				int dateDistance = Constant.getDateDistance(startTime, endTime);

				String ordertime = Constant.getTimeFormatString();
				String orderno = hostelno + ordertime;
				Roomdisplay rd = roomdisplayServiceImpl.get(hostelno, roomno);

				double amount = dateDistance * rd.getPrice();
				double saleOff = amount * saleRatio;
				double pay = amount - saleOff;

			/*Order(String orderno, String hostelno,
					Timestamp ordertime, RoomType roomType,
			int roomPrice, Date startTime, Date endTime,
			int roomNum, double amount, double saleRatio,
			double saleOff, double pay, String memberno,
					PayType payType, OrderState orderState)*/
				Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
				Order order = new Order(orderno, hostelno, timestamp, rd.getRoomType(),
						rd.getPrice(), startTime, endTime, Integer.parseInt(roomno),
						amount, saleRatio, saleOff, pay, u.getUserno(),
						PayType.MEMBERCARD, OrderState.RESERVED);
				orderServiceImpl.add(order);
				u.setBalance(u.getBalance() - pay);
				u.setScore(u.getScore()+pay);
				userServiceImpl.update(u);
				User hostel = userServiceImpl.get(hostelno);
				hostel.setBalance(hostel.getBalance() + pay);
				userServiceImpl.update(hostel);


//			Room(String hostelno, String roomno, RoomType roomType, String roomTimeState) ;
				String roomTimeState = Constant.getDateString(start, end);
				Room r = new Room(hostelno, roomno, rd.getRoomType(), roomTimeState);

				System.out.println("hostelno:" + hostelno + "roomno:" + roomno);
				String greetings = hostelno + "-" + roomno;
				resp.setContentType("text/plain");
				resp.getWriter().write(greetings);
			} else {
				String greetings = "您当前用户状态为" + state.getStr() + ",您不能进行预定!";
				resp.setContentType("text/plain");
				resp.getWriter().write(greetings);
			}
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		this.doGet(req,resp);
	}
}
