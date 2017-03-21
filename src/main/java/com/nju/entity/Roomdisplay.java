package com.nju.entity;

import com.nju.util.RoomType;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.16.
 */
public class Roomdisplay implements Serializable {
	private String hostelname;
	private String hostelno;
	private int price;
	private RoomType roomType;
	private String roomno;
	private String roomTimeState;
	private String address;
	public Roomdisplay() {

	}

	public Roomdisplay(String hostelname, String hostelno, int price, RoomType roomType, String roomno, String roomTimeState, String address) {
		this.hostelname = hostelname;
		this.hostelno = hostelno;
		this.price = price;
		this.roomType = roomType;
		this.roomno = roomno;
		this.roomTimeState = roomTimeState;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHostelname() {
		return hostelname;
	}

	public void setHostelname(String hostelname) {
		this.hostelname = hostelname;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoomTimeState() {
		return roomTimeState;
	}

	public void setRoomTimeState(String roomTimeState) {
		this.roomTimeState = roomTimeState;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Roomdisplay)) return false;

		Roomdisplay that = (Roomdisplay) o;

		if (getPrice() != that.getPrice()) return false;
		if (!getHostelname().equals(that.getHostelname())) return false;
		if (!getHostelno().equals(that.getHostelno())) return false;
		if (getRoomType() != that.getRoomType()) return false;
		if (!getRoomno().equals(that.getRoomno())) return false;
		if (!getAddress().equals(that.getAddress())) return false;
		return getRoomTimeState() != null ? getRoomTimeState().equals(that.getRoomTimeState()) : that.getRoomTimeState() == null;
	}

	@Override
	public int hashCode() {
		int result = getHostelname().hashCode();
		result = 31 * result + getHostelno().hashCode();
		result = 31 * result + getPrice();
		result = 31 * result + getRoomType().hashCode();
		result = 31 * result + getRoomno().hashCode();
		result = 31 * result + getAddress().hashCode();
		return result;
	}
}
