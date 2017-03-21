package com.nju.servlet.manager;

import com.nju.entity.Roomdisplay;
import com.nju.entity.User;
import com.nju.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class CheckInfoServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public CheckInfoServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/manager/checkInfo.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null && u.getUserType() == 3) {
			List<User> joinCheckList = userServiceImpl.findList(0);
			req.setAttribute("joinCheckList", joinCheckList);

			List<User> modifyList = userServiceImpl.findList(4);
			for (User temp : modifyList) {
				System.out.println(temp.toString());
			}
			Map<User, User> modifyMap = new HashMap<User, User>();
			for (User temp : modifyList) {
				String hostelno = temp.getUserno().substring(0, temp.getUserno().length() - 1);
				User raw = userServiceImpl.get(hostelno);
				modifyMap.put(raw, temp);
			}
			req.setAttribute("modifyMap", modifyMap);

			req.getRequestDispatcher(resp.encodeURL("/jsp/manager/checkInfo.jsp")).forward(req, resp);
		} else {
			System.out.println("manager->CheckInfoServlet  get user failed!");
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}