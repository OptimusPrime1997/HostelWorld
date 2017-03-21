package com.nju.servlet.hostel;

import com.nju.entity.Hostelplan;
import com.nju.entity.Order;
import com.nju.entity.User;
import com.nju.service.HostelplanService;
import com.nju.util.OrderState;
import com.nju.util.PlanState;
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
 * Created by OptimusPrime on 2017.3.15.
 */
@Component
public class HostelPlanServlet extends HttpServlet {
	@Autowired
	private HostelplanService hostelplanServiceImpl;

	public HostelplanService getHostelplanServiceImpl() {
		return hostelplanServiceImpl;
	}

	public void setHostelplanServiceImpl(HostelplanService hostelplanServiceImpl) {
		this.hostelplanServiceImpl = hostelplanServiceImpl;
	}

	public HostelPlanServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		req.getRequestDispatcher(resp.encodeURL("/jsp/hostel/hostelPlan.jsp")).forward(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null && user.getUserType() == 2) {
			List<Hostelplan> allList = hostelplanServiceImpl.findList(user.getUserno());
			List<Hostelplan> nowList = hostelplanServiceImpl.findList(user.getUserno(), PlanState.NOW);
			System.out.println("MyHostelHostelplanServlet->dopost allList size:" + allList.size() + "nowList size:" + nowList.size());
			for (Hostelplan p : allList) {
				System.out.println(p.toString());
			}
			req.setAttribute("nowList", nowList);
			req.setAttribute("allList", allList);

			req.getRequestDispatcher(resp.encodeURL("/jsp/hostel/hostelPlan.jsp")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}