package com.nju.util;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.8.
 */
public enum RoomState implements Serializable {
	RESERVED(1, "预定"),
	CHECKIN(2, "入住"),
	EMPTY(3, "空闲");

	private int code;
	private String state;

	RoomState(int code, String state) {
		this.code = code;
		this.state = state;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static RoomState getRoomState(int code) {
		RoomState type = null;
		switch (code) {
			case 1:
				type = RoomState.RESERVED;
				break;
			case 2:
				type = RoomState.CHECKIN;
				break;
			case 3:
				type = RoomState.EMPTY;
				break;
			default:
				System.out.println("RoomState:get RoomState failed!code---" + code);
				type = RoomState.EMPTY;
		}
		return type;
	}

	public static RoomState getRoomState(String val) {
		RoomState type = null;
		if (val.equals("预定")) {
			type = RoomState.RESERVED;
		} else if (val.equals("入住")) {
			type = RoomState.CHECKIN;
		} else if (val.equals("空闲")) {
			type = RoomState.EMPTY;
		} else {
			System.out.println("RoomState->getRoomState-String:failed!String:" + val);
			type = RoomState.EMPTY;
		}
		return type;
	}

	@Override
	public String toString() {
		return this.getState();
	}
}
