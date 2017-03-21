package com.nju.servlet.common;

import com.nju.entity.User;
import com.nju.service.UserService;
import com.nju.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class UpdateServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		List<User> userList = userServiceImpl.findList(1);
		for (User u : userList) {
//			UserContext userContext=new UserContext(u);
//			if (u.getBalance() < 0 ) {
//				userContext.arrearage();
//				userServiceImpl.update(userContext.getUser());
//			}
			if(u.getBalance()<0&&u.getState()==State.NORMAL){
				u.setState(State.ARREARAGE);
				userServiceImpl.update(u);
			}
//			处理一年到期


		}
	}
}
