package com.nju.entity;

import com.nju.util.RoomType;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Room implements Serializable {
	private String hostelno;
	private String roomno;
	private RoomType roomType;
	private String roomTimeState;

	public Room() {
	}

	public Room(String hostelno, String roomno, RoomType roomType, String roomTimeState) {
		this.hostelno = hostelno;
		this.roomno = roomno;
		this.roomType = roomType;
		this.roomTimeState = roomTimeState;
	}

	public Room(String hostelno, String roomno, RoomType roomType) {
		this.hostelno = hostelno;
		this.roomno = roomno;
		this.roomType = roomType;
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

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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
		if (o == null || getClass() != o.getClass()) return false;

		Room room = (Room) o;

		if (hostelno != null ? !hostelno.equals(room.hostelno) : room.hostelno != null) return false;
		if (roomno != null ? !roomno.equals(room.roomno) : room.roomno != null) return false;
		if (roomType != null ? !roomType.equals(room.roomType) : room.roomType != null) return false;
		if (roomTimeState != null ? !roomTimeState.equals(room.roomTimeState) : room.roomTimeState != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hostelno != null ? hostelno.hashCode() : 0;
		result = 31 * result + (roomno != null ? roomno.hashCode() : 0);
		result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
		result = 31 * result + (roomTimeState != null ? roomTimeState.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Room{" +
				"hostelno='" + hostelno + '\'' +
				", roomno='" + roomno + '\'' +
				", roomType=" + roomType +
				", roomTimeState='" + roomTimeState + '\'' +
				'}';
	}
}
