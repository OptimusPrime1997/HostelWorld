package com.nju.util;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.8.
 */
public enum RoomType implements Serializable {
	BIG("大床房", 1), STANDARD("标准间", 2);
	private String str;
	private int code;

	private RoomType(String str, int code) {
		this.str = str;
		this.code = code;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static RoomType getRoomType(int code) {
		RoomType type = null;
		switch (code) {
			case 1:
				type = RoomType.BIG;
				break;
			case 2:
				type = RoomType.STANDARD;
				break;
			default:
				System.out.println("RoomType:get roomtype failed!code---" + code);
				type = RoomType.BIG;
		}
		return type;
	}

	public static RoomType getRoomType(String val) {
		RoomType type = null;
		if (val.equals("大床房")) {
			type = RoomType.BIG;
		} else if (val.equals("标准间")) {
			type = RoomType.STANDARD;
		} else {
			System.out.println("RoomType->getRoomType-String:failed!String:" + val);
			type = RoomType.BIG;
		}
		return type;
	}

	@Override
	public String toString() {
		return this.getStr();
	}

}
