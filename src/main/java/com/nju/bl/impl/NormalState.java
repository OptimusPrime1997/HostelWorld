package com.nju.bl.impl;

import com.nju.bl.UserContext;
import com.nju.bl.UserState;
import com.nju.util.State;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class NormalState implements UserState {
	private UserContext userContext;

	public NormalState(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}


	public void chargeOneThousand() {
		System.out.println("NormalState->chargeOneThousand no");

	}

	public void consumeOneThousand() {
		System.out.println("NormalState->consumeOneThousand");
		userContext.getUser().setState(State.VIP);
		userContext.setUserState(userContext.getVipState());
	}

	public void arrearage() {
		System.out.println("NormalState->arrearage");
		userContext.getUser().setState(State.ARREARAGE);
		userContext.setUserState(userContext.getArrearageState());
	}

	public void payBill() {
		System.out.println("NormalState->payBill no");
	}

	public void stop() {
		System.out.println("NormalState->stop");
		userContext.getUser().setState(State.STOP);
		userContext.setUserState(userContext.getStopState());
	}
}
