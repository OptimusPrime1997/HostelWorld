package com.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class PaymentPK implements Serializable {
	private String hostelno;
	private Timestamp paytime;

	public PaymentPK() {
	}

	public PaymentPK(String hostelno, Timestamp paytime) {
		this.hostelno = hostelno;
		this.paytime = paytime;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public Timestamp getPaytime() {
		return paytime;
	}

	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PaymentPK paymentPK = (PaymentPK) o;

		if (hostelno != null ? !hostelno.equals(paymentPK.hostelno) : paymentPK.hostelno != null) return false;
		if (paytime != null ? !paytime.equals(paymentPK.paytime) : paymentPK.paytime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = hostelno != null ? hostelno.hashCode() : 0;
		result = 31 * result + (paytime != null ? paytime.hashCode() : 0);
		return result;
	}
}
