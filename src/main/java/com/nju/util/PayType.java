package com.nju.util;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.8.
 */
public enum PayType implements Serializable {
	CASH(1, "现金"),
	MEMBERCARD(2, "会员卡");
	private int code;
	private String str;

	private PayType(int code, String str) {
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

	public static PayType getPayType(int code) {
		PayType type = null;
		switch (code) {
			case 1:
				type = PayType.CASH;
				break;
			case 2:
				type = PayType.MEMBERCARD;
				break;
			default:
				System.out.println("PayType:get PayType failed!code---" + code);
				type = PayType.CASH;
		}
		return type;
	}

	public static PayType getPayType(String val) {
		PayType type = null;
		if (val.equals("现金")) {
			type = PayType.CASH;
		} else if (val.equals("会员卡")) {
			type = PayType.MEMBERCARD;
		} else {
			System.out.println("PayType->getPayType-String:failed!String:" + val);
			type = PayType.CASH;
		}
		return type;
	}

	@Override
	public String toString() {
		return this.getStr();
	}
}
