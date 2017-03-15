package com.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.11.
 */
public class OrderPK implements Serializable {
	private String hostelno;
	private Timestamp ordertime;


	public OrderPK() {
	}

	public OrderPK(String hostelno, Timestamp ordertime) {
		this.hostelno = hostelno;
		this.ordertime = ordertime;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public Timestamp getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		OrderPK depositPK = (OrderPK) o;

		if (hostelno != null ? !hostelno.equals(depositPK.hostelno) : depositPK.hostelno != null) return false;
		if (ordertime != null ? !ordertime.equals(depositPK.ordertime) : depositPK.ordertime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hostelno != null ? hostelno.hashCode() : 0;
		result = 31 * result + (ordertime != null ? ordertime.hashCode() : 0);
		return result;
	}
}
