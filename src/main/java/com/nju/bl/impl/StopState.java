package com.nju.bl.impl;

import com.nju.bl.UserContext;
import com.nju.bl.UserState;

/**
 * Created by OptimusPrime on 2017.3.19.
 */
public class StopState implements UserState {
	private UserContext userContext;

	public StopState(UserContext userContext) {
		this.userContext = userContext;
	}

	public UserContext getUserContext() {
		return userContext;
	}

	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}

	public void chargeOneThousand() {
		System.out.println("StopState->chargeOneThousand no");
	}

	public void consumeOneThousand() {
		System.out.println("StopState->consumeOneThousand no");
	}

	public void arrearage() {
		System.out.println("StopState->arrearage no");
	}

	public void payBill() {
		System.out.println("StopState->payBill no");
	}

	public void stop() {
		System.out.println("StopState->stop no");
	}
}
