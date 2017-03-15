package com.nju.entity;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class RoomPK implements Serializable {
	private String hostelno;
	private String roomno;

	public RoomPK(String hostelno, String roomno) {
		this.hostelno = hostelno;
		this.roomno = roomno;
	}

	public RoomPK() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RoomPK roomPK = (RoomPK) o;

		if (hostelno != null ? !hostelno.equals(roomPK.hostelno) : roomPK.hostelno != null) return false;
		if (roomno != null ? !roomno.equals(roomPK.roomno) : roomPK.roomno != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hostelno != null ? hostelno.hashCode() : 0;
		result = 31 * result + (roomno != null ? roomno.hashCode() : 0);
		return result;
	}
}
