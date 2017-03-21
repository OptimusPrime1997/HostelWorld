package com.nju.entity;

import com.nju.util.PlanState;
import com.nju.util.RoomType;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Hostelplan implements Serializable {
	private String hostelplanno;
	private String hostelno;
	private Date startDate;
	private Date endDate;
	private RoomType roomType;
	private int price;
	private PlanState planState;

	public Hostelplan() {
	}

	public Hostelplan(String hostelplanno, String hostelno, Date startDate, Date endDate, RoomType roomType, int price, PlanState planState) {
		this.hostelplanno = hostelplanno;
		this.hostelno = hostelno;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomType = roomType;
		this.price = price;
		this.planState = planState;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getHostelplanno() {
		return hostelplanno;
	}

	public void setHostelplanno(String hostelplanno) {
		this.hostelplanno = hostelplanno;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PlanState getPlanState() {
		return planState;
	}

	public void setPlanState(PlanState planState) {
		this.planState = planState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Hostelplan)) return false;

		Hostelplan that = (Hostelplan) o;

		if (price != that.price) return false;
		if (!hostelplanno.equals(that.hostelplanno)) return false;
		if (!hostelno.equals(that.hostelno)) return false;
		if (!startDate.equals(that.startDate)) return false;
		if (!endDate.equals(that.endDate)) return false;
		return roomType == that.roomType;
	}

	@Override
	public int hashCode() {
		int result = hostelplanno.hashCode();
		result = 31 * result + hostelno.hashCode();
		result = 31 * result + startDate.hashCode();
		result = 31 * result + endDate.hashCode();
		result = 31 * result + roomType.hashCode();
		result = 31 * result + price;
		return result;
	}

	@Override
	public String toString() {
		return "Hostelplan{" +
				"hostelplanno='" + hostelplanno + '\'' +
				", hostelno='" + hostelno + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", roomType=" + roomType +
				", price=" + price +
				'}';
	}
}
