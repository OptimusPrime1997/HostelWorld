package com.nju.util.factory;

import com.nju.dao.*;
import com.nju.dao.impl.*;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
public class DaoFactory {
	private static BankaccountDao bankaccountDao;
	private static DepositDao depositDao;
	private static HostelplanDao hostelplanDao;
	private static OrderDao orderDao;
	private static PaymentDao paymentDao;
	private static RoomDao roomDao;
	private static UserDao userDao;

	public static BankaccountDao getBankaccountDao() {
		if (bankaccountDao == null) {
			bankaccountDao = new BankaccountDaoImpl();
		}
		return bankaccountDao;
	}

	public static DepositDao getDepositDao() {
		if (depositDao == null) {
			depositDao = new DepositDaoImpl();
		}
		return depositDao;
	}

	public static HostelplanDao getHostelplanDao() {
		if (hostelplanDao == null) {
			hostelplanDao = new HostelplanDaoImpl();
		}
		return hostelplanDao;
	}

	public static OrderDao getOrderDao() {
		if (orderDao == null) {
			orderDao = new OrderDaoImpl();
		}
		return orderDao;
	}

	public static PaymentDao getPaymentDao() {
		if (paymentDao == null) {
			paymentDao = new PaymentDaoImpl();
		}
		return paymentDao;
	}

	public static RoomDao getRoomDao() {
		if (roomDao == null) {
			roomDao = new RoomDaoImpl();
		}
		return roomDao;
	}

	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
}
