package com.nju.servlet.hostel.action;

import com.nju.entity.*;
import com.nju.service.*;
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
public class HostelModifyServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	/**
	 * it's for delplan
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		HttpSession hpSession = req.getSession();
//		User u = (User) hpSession.getAttribute("user");
//		if (u != null) {
//			req.getRequestDispatcher(resp.encodeURL("/HostelInfoServlet")).forward(req, resp);
//		} else {
//			System.out.println("not member check in failed!");
//			req.getRequestDispatcher(resp.encodeURL("/HostelInfoServlet")).forward(req, resp);
//		}
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			/*User(String userno, String password, int userType,
			String name, String phoneNum, String id, 
			double balance, double score, String address, 
					String bankAccount, State state) */
			String name = req.getParameter("name");
			String phoneNum = req.getParameter("phoneNum");
			String address = req.getParameter("address");
			String bankAccount = req.getParameter("bankAccount");
			User temp=new User(u.getUserno(),u.getPassword(),
					u.getUserType(),u.getName(),u.getPhoneNum()
					,u.getId(),u.getBalance(),u.getScore()
					,u.getAddress(),u.getBankAccount(),u.getState());
			
			if(name!=null){
				temp.setName(name);
			}
			if(phoneNum!=null){
				temp.setPhoneNum(phoneNum);
			}
			if(address!=null){
				temp.setAddress(address);
			}
			if(bankAccount!=null){
				temp.setBankAccount(bankAccount);
			}
			temp.setUserno(u.getUserno().substring(0,7) + "0");
			temp.setUserType(4);
//			hpSession.setAttribute("user",u);
			userServiceImpl.save(temp);
			System.out.println("modify apply send successfully!");
			req.getRequestDispatcher(resp.encodeURL("/HostelInfoServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelInfoServlet")).forward(req, resp);
		}
	}
}
