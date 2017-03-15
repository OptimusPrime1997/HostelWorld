package com.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
public class DepositPK implements Serializable {
	private String depositno;
	private Timestamp time;


	public DepositPK() {
	}

	public DepositPK(String depositno, Timestamp time) {
		this.depositno = depositno;
		this.time = time;
	}

	public String getDepositno() {
		return depositno;
	}

	public void setDepositno(String depositno) {
		this.depositno = depositno;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DepositPK depositPK = (DepositPK) o;

		if (depositno != null ? !depositno.equals(depositPK.depositno) : depositPK.depositno != null) return false;
		if (time != null ? !time.equals(depositPK.time) : depositPK.time != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = depositno != null ? depositno.hashCode() : 0;
		result = 31 * result + (time != null ? time.hashCode() : 0);
		return result;
	}
}
