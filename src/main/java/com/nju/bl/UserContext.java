package com.nju.bl;

import com.nju.bl.impl.*;
import com.nju.entity.User;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class UserContext {
	private UserState userState;
	private UserState inactiveState;
	private UserState normalState;
	private UserState vipState;
	private UserState arrearageState;
	private UserState stopState;
	private User user;

	public UserContext(User user) {
		this.user = user;
		this.inactiveState = new InactiveState(this);
		this.normalState = new NormalState(this);
		this.vipState = new VipState(this);
		this.arrearageState = new ArrearageState(this);
		this.stopState = new StopState(this);
		switch (user.getState()) {
			case INACTIVE:
				this.userState = inactiveState;
				break;
			case NORMAL:
				this.userState = normalState;
				break;
			case VIP:
				this.userState = vipState;
				break;
			case ARREARAGE:
				this.userState = arrearageState;
				break;
			case STOP:
				this.userState = stopState;
				break;
			default:
				System.out.println("UserContext initial method error!");
				break;
		}
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}

	public UserState getInactiveState() {
		return inactiveState;
	}

	public void setInactiveState(UserState inactiveState) {
		this.inactiveState = inactiveState;
	}

	public UserState getNormalState() {
		return normalState;
	}

	public void setNormalState(UserState normalState) {
		this.normalState = normalState;
	}

	public UserState getVipState() {
		return vipState;
	}

	public void setVipState(UserState vipState) {
		this.vipState = vipState;
	}

	public UserState getArrearageState() {
		return arrearageState;
	}

	public void setArrearageState(UserState arrearageState) {
		this.arrearageState = arrearageState;
	}

	public UserState getStopState() {
		return stopState;
	}

	public void setStopState(UserState stopState) {
		this.stopState = stopState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void chargeOneThousand() {
		System.out.println("UserContext->chargeOneThousand");
		userState.chargeOneThousand();
	}

	public void consumeOneThousand() {
		System.out.println("UserContext->consumeOneThousand");
		userState.consumeOneThousand();
	}

	public void arrearage() {
		System.out.println("UserContext->arrearage");
		userState.arrearage();
	}

	public void payBill() {
		System.out.println("UserContext->payBill");
		userState.payBill();
	}

	public void stop() {
		System.out.println("UserContext->stop");
		userState.stop();
	}
}
