package com.nju.util;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.8.
 */
public enum State implements Serializable {
/*
	会员资格激活
	办卡后，一次交纳1000元以上激活；
	会费通过银行卡支付（数据库中的银行卡账号）；
	会员资格暂停/恢复/停止
	有效期一年，到期后卡上费用不足将暂停其记录；一旦支付，则恢复，
	会员记录可用；暂停1年后未支付，会员记录停止 ；（系统自动完成）
	会员资格取消
	会员可通知系统取消资格（即停止）*/

	INACTIVE(1, "未激活"),
	NORMAL(2, "正常"),
	VIP(3, "高级"),
	ARREARAGE(4, "欠费"),
	STOP(5, "暂停");

	private int code;
	private String str;

	private State(int code, String str) {
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

	public static State getState(int code) {
		State type = null;
		switch (code) {
			case 1:
				type = State.INACTIVE;
				break;
			case 2:
				type = State.NORMAL;
				break;
			case 3:
				type = State.VIP;
				break;
			case 4:
				type = State.ARREARAGE;
				break;
			case 5:
				type = State.STOP;
				break;
			default:
				System.out.println("State:get State failed!code---" + code);
				type = State.INACTIVE;
		}
		return type;
	}

	public static State getState(String val) {
		State type = null;
		if (val.equals("未激活")) {
			type = State.INACTIVE;
		} else if (val.equals("正常")) {
			type = State.NORMAL;
		} else if (val.equals("高级")) {
			type = State.VIP;
		} else if (val.equals("欠费")) {
			type = State.ARREARAGE;
		} else if (val.equals("暂停")) {
			type = State.STOP;
		} else {
			System.out.println("State->getState-String:failed!String:" + val);
			type = State.INACTIVE;
		}
		return type;
	}

//	@Override
//	public String toString() {
//		return this.getStr();
//	}
}
