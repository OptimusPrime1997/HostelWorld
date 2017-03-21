package com.nju.bl.impl;

import com.nju.bl.UserContext;
import com.nju.bl.UserState;
import com.nju.util.State;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class ArrearageState implements UserState {
	private UserContext userContext;

	public ArrearageState(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public void chargeOneThousand() {
		System.out.println("ArrearageState->chargeOneThousand");
	}

	public void consumeOneThousand() {
		System.out.println("ArrearageState->consumeOneThousand");
	}

	public void arrearage() {
		System.out.println("ArrearageState->arrearage");
	}

	public void payBill() {
		System.out.println("ArrearageState->payBill");
		userContext.getUser().setState(State.NORMAL);
		userContext.setUserState(userContext.getNormalState());
	}

	public void stop() {
		System.out.println("ArrearageState->stop");
		userContext.getUser().setState(State.STOP);
		userContext.setUserState(userContext.getStopState());
	}
}
