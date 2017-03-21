package com.nju.servlet.user.action;

import com.nju.entity.Bankaccount;
import com.nju.entity.User;
import com.nju.service.BankaccountService;
import com.nju.service.UserService;
import com.nju.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class ChargeServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private BankaccountService bankaccountServiceImpl;

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public BankaccountService getBankaccountServiceImpl() {
		return bankaccountServiceImpl;
	}

	public void setBankaccountServiceImpl(BankaccountService bankaccountServiceImpl) {
		this.bankaccountServiceImpl = bankaccountServiceImpl;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null) {
			double chargeAmount = Double.parseDouble(req.getParameter("chargeAmount"));
			Bankaccount bankaccount = bankaccountServiceImpl.get(u.getBankAccount());
			bankaccount.setBalance(bankaccount.getBalance() - chargeAmount);
			System.out.println("ChargeServlet->bankaccount transation success!");

			double balance = u.getBalance() + chargeAmount;
			u.setBalance(balance);
			if (chargeAmount >= 10000.0 && (u.getState() == State.INACTIVE || u.getState() == State.NORMAL)) {
				u.setState(State.VIP);
			} else if (chargeAmount >= 1000.0 && u.getState() == State.INACTIVE) {
				u.setState(State.NORMAL);
			}
			userServiceImpl.update(u);
			req.getRequestDispatcher(resp.encodeURL("/IndividualServlet")).forward(req, resp);
		} else {
			req.getRequestDispatcher(resp.encodeURL("/jsp/common/login.jsp")).forward(req, resp);
		}
	}
}
