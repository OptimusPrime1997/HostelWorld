package com.nju.util;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.8.
 */
public enum OrderState implements Serializable {
	RESERVED(1, "预定"),
	CANCEL(2, "取消"),
	CHECKIN(3, "入住"),
	CHECKOUT(4, "退房");

	private int code;
	private String str;

	OrderState(int code, String str) {
		this.code = code;
		this.str = str;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

//	@Override
//	public String toString() {
//		return this.getStr();
//	}

}
