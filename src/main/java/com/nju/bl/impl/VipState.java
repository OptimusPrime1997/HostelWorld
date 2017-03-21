package com.nju.bl.impl;

import com.nju.bl.UserContext;
import com.nju.bl.UserState;
import com.nju.util.State;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class VipState implements UserState {
	private UserContext userContext;

	public VipState(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}


	public void chargeOneThousand() {
		System.out.println("VipState->chargeOneThousand no");
	}

	public void consumeOneThousand() {
		System.out.println("VipState->consumeOneThousand nl");
	}

	public void arrearage() {
		System.out.println("VipState->arrearage");
		userContext.getUser().setState(State.ARREARAGE);
		userContext.setUserState(userContext.getArrearageState());
	}

	public void payBill() {
		System.out.println("VipState->payBill no");
	}

	public void stop() {
		System.out.println("VipState->stop");
		userContext.getUser().setState(State.STOP);
		userContext.setUserState(userContext.getStopState());
	}
}
