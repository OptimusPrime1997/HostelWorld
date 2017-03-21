package com.nju.util.factory;

import com.nju.service.*;
import com.nju.service.impl.*;

/**
 * Created by OptimusPrime on 2017.3.15.
 */
public class ServiceFactory {
	private static BankaccountService bankaccountService;
	private static DepositService depositService;
	private static HostelplanService hostelplanService;
	private static OrderService orderService;
	private static PaymentService paymentService;
	private static RoomService roomService;
	private static UserService userService;

	public static BankaccountService getBankaccountService() {
		if (bankaccountService == null) {
			bankaccountService = new BankaccountServiceImpl();
		}
		return bankaccountService;
	}

	public static DepositService getDepositService() {
		if (depositService == null) {
			depositService = new DepositServiceImpl();
		}
		return depositService;
	}

	public static HostelplanService getHostelplanService() {
		if (hostelplanService == null) {
			hostelplanService = new HostelplanServiceImpl();
		}
		return hostelplanService;
	}

	public static OrderService getOrderService() {
		if (orderService == null) {
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}

	public static PaymentService getPaymentService() {
		if (paymentService == null) {
			paymentService = new PaymentServiceImpl();
		}
		return paymentService;
	}

	public static RoomService getRoomService() {
		if (roomService == null) {
			roomService = new RoomServiceImpl();
		}
		return roomService;
	}

	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}
}
