package com.nju.servlet.manager.action;

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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by OptimusPrime on 2017.3.20.
 */
@Component
public class ManagerPayServlet extends HttpServlet {
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private BankaccountService bankaccountServiceImpl;
	@Autowired
	private PaymentService paymentServiceImpl;

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

	/**
	 * it's for reject join apply
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null && u.getUserType() == 3) {
			String hostelno = req.getParameter("hostelno");
			System.out.println("hostelno:"+hostelno);
			if (hostelno != null) {
				userServiceImpl.delete(hostelno);
				System.out.println("join apply rejected!");
			}
			System.out.println("modify apply send successfully!");
			req.getRequestDispatcher(resp.encodeURL("/PayoffServlet")).forward(req, resp);
		} else {
			System.out.println("not member check in failed!");
			req.getRequestDispatcher(resp.encodeURL("/HostelInfoServlet")).forward(req, resp);
		}*/
		this.doPost(req,resp);
	}

	/**
	 * it's pass the join apply
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hpSession = req.getSession();
		User u = (User) hpSession.getAttribute("user");
		if (u != null&& u.getUserType() == 3) {
			String hostelno = req.getParameter("hostelno");
			String bankAccount=req.getParameter("bankAccount");

			System.out.println("hostelno:"+hostelno+"---bankAccount:"+bankAccount);
			if (hostelno != null && bankAccount!=null) {
				User user = userServiceImpl.get(hostelno);
				Bankaccount bankaccount=bankaccountServiceImpl.get(bankAccount);
				Bankaccount myBankaccount=bankaccountServiceImpl.get(u.getBankAccount());
				double balance=user.getBalance();
				myBankaccount.setBalance(myBankaccount.getBalance()-balance);
				bankaccount.setBalance(bankaccount.getBalance()+balance);
				user.setBalance(0);
				bankaccountServiceImpl.update(bankaccount);
				bankaccountServiceImpl.update(myBankaccount);
				userServiceImpl.update(user);
				/*Payment(String payno, String hostelno,
						Timestamp paytime, double inCome,double ratio, double fee,
				double outcome)*/
				String payno=hostelno+Constant.getTimeFormatString();
				Timestamp timestamp = new Timestamp((new java.util.Date()).getTime());
				double fee=balance*Constant.feeRatio;
				double outcome=balance-fee;
				Payment payment=new Payment(payno,hostelno,timestamp,balance,Constant.feeRatio,fee,outcome);
				paymentServiceImpl.add(payment);
				System.out.println("payoff successfully!");
			}
			req.getRequestDispatcher(resp.encodeURL("/PayoffServlet")).forward(req, resp);
		} else {
			System.out.println("pass check failed!");
			req.getRequestDispatcher(resp.encodeURL("/PayoffServlet")).forward(req, resp);
		}
	}
}