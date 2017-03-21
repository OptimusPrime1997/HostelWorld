package com.nju.servlet.hostel;

import com.nju.entity.Room;
import com.nju.entity.User;
import com.nju.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
@Component
public class HostelRoomServlet extends HttpServlet {
	@Autowired
	private RoomService roomServiceImpl;

	public RoomService getRoomServiceImpl() {
		return roomServiceImpl;
	}

	public void setRoomServiceImpl(RoomService roomServiceImpl) {
		this.roomServiceImpl = roomServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u != null && u.getUserType() == 2) {
			List<Room> allRoom = roomServiceImpl.findListByHostel(u.getUserno());
			for (Room r : allRoom) {
				System.out.println("HostelRoom->Room:" + r.toString());
			}
			req.setAttribute("allRoom", allRoom);
			req.getRequestDispatcher(resp.encodeURL("/jsp/hostel/hostelRoom.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}
