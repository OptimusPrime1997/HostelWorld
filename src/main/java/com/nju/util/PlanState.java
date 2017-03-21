package com.nju.util;

/**
 * Created by OptimusPrime on 2017.3.18.
 */
public enum PlanState {
	PAST(1, "过去"),
	NOW(2, "现在"),
	FUTURE(3, "未来");
	private int code;
	private String str;

	private PlanState(int code, String str) {
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

	public static PlanState getPlanState(int code) {
		PlanState type = null;
		switch (code) {
			case 1:
				type = PlanState.PAST;
				break;
			case 2:
				type = PlanState.NOW;
				break;
			case 3:
				type = PlanState.FUTURE;
				break;
			default:
				System.out.println("PlanState:get PlanState failed!code---" + code);
				type = PlanState.PAST;
		}
		return type;
	}

	public static PlanState getPlanState(String val) {
		PlanState type = null;
		if (val.equals("过去")) {
			type = PlanState.PAST;
		} else if (val.equals("现在")) {
			type = PlanState.NOW;
		} else if (val.equals("未来")) {
			type = PlanState.FUTURE;
		} else {
			System.out.println("PlanState->getPlanState-String:failed!String:" + val);
			type = PlanState.PAST;
		}
		return type;
	}

//	@Override
//	public String toString() {
//		return this.getStr();
//	}
}
