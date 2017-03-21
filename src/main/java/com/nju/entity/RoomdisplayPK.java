package com.nju.entity;

/**
 * Created by OptimusPrime on 2017.3.16.
 */
public class RoomdisplayPK {
	private String hostelno;
	private String roomno;

	public RoomdisplayPK(String hostelno, String roomno) {
		this.hostelno = hostelno;
		this.roomno = roomno;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
}
