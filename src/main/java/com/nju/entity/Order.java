package com.nju.entity;

import com.nju.util.OrderState;
import com.nju.util.PayType;
import com.nju.util.RoomType;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Order implements Serializable {
	private String orderno;
	private String hostelno;
	private Timestamp ordertime;
	private RoomType roomType;
	private int roomPrice;
	private Date startTime;
	private Date endTime;
	private int roomNum;
	private double amount;
	private double saleRatio;
	private double saleOff;
	private double pay;
	private String memberno;
	private PayType payType;
	private OrderState orderState;

	public Order() {
	}

	public Order(String orderno, String hostelno,
	             Timestamp ordertime, RoomType roomType,
	             int roomPrice, Date startTime, Date endTime,
	             int roomNum, double amount, double saleRatio,
	             double saleOff, double pay, String memberno,
	             PayType payType, OrderState orderState) {
		this.orderno = orderno;
		this.hostelno = hostelno;
		this.ordertime = ordertime;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.startTime = startTime;
		this.endTime = endTime;
		this.roomNum = roomNum;
		this.amount = amount;
		this.saleRatio = saleRatio;
		this.saleOff = saleOff;
		this.pay = pay;
		this.memberno = memberno;
		this.payType = payType;
		this.orderState = orderState;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public Timestamp getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	public double getSaleOff() {
		return saleOff;
	}

	public void setSaleOff(double saleOff) {
		this.saleOff = saleOff;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getMemberno() {
		return memberno;
	}

	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		if (roomPrice != order.roomPrice) return false;
		if (roomNum != order.roomNum) return false;
		if (Double.compare(order.amount, amount) != 0) return false;
		if (Double.compare(order.saleRatio, saleRatio) != 0) return false;
		if (Double.compare(order.saleOff, saleOff) != 0) return false;
		if (Double.compare(order.pay, pay) != 0) return false;
		if (roomType != null ? !roomType.equals(order.roomType) : order.roomType != null) return false;
		if (startTime != null ? !startTime.equals(order.startTime) : order.startTime != null) return false;
		if (endTime != null ? !endTime.equals(order.endTime) : order.endTime != null) return false;
		if (hostelno != null ? !hostelno.equals(order.hostelno) : order.hostelno != null) return false;
		if (orderno != null ? !orderno.equals(order.orderno) : order.orderno != null) return false;
		if (memberno != null ? !memberno.equals(order.memberno) : order.memberno != null) return false;
		if (payType != null ? !payType.equals(order.payType) : order.payType != null) return false;
		if (orderState != null ? !orderState.equals(order.orderState) : order.orderState != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = hostelno != null ? hostelno.hashCode() : 0;
		result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
		result = 31 * result + roomPrice;
		result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
		result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
		result = 31 * result + roomNum;
		temp = Double.doubleToLongBits(amount);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saleRatio);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saleOff);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pay);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (memberno != null ? memberno.hashCode() : 0);
		result = 31 * result + (orderno != null ? orderno.hashCode() : 0);
		result = 31 * result + (payType != null ? payType.hashCode() : 0);
		result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Order{" +
				"hostelno='" + hostelno + '\'' +
				", ordertime=" + ordertime +
				", roomType=" + roomType +
				", roomPrice=" + roomPrice +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", roomNum=" + roomNum +
				", amount=" + amount +
				", saleRatio=" + saleRatio +
				", saleOff=" + saleOff +
				", pay=" + pay +
				", memberno='" + memberno + '\'' +
				", payType=" + payType +
				", orderState=" + orderState +
				'}';
	}
}
