package com.nju.bl.impl;

import com.nju.bl.UserContext;
import com.nju.bl.UserState;
import com.nju.util.State;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class InactiveState implements UserState {
	private UserContext userContext;

	public InactiveState(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}


	public void chargeOneThousand() {
		System.out.println("InactiveState->chargeOneThousand");
		userContext.getUser().setState(State.NORMAL);
		userContext.setUserState(userContext.getNormalState());
	}

	public void consumeOneThousand() {
		System.out.println("InactiveState->consumeOneThousand no");
	}

	public void arrearage() {
		System.out.println("InactiveState->arrearage no");
	}

	public void payBill() {
		System.out.println("InactiveState->payBill no");
	}

	public void stop() {
		System.out.println("InactiveState->stop");
		userContext.getUser().setState(State.STOP);
		userContext.setUserState(userContext.getStopState());
	}
}
