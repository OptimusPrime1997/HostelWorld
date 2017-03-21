package com.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Payment implements Serializable, Comparable {
	private String payno;
	private String hostelno;
	private Timestamp paytime;
	private double inCome;
	private double ratio;
	private double fee;
	private double outcome;

	public Payment() {
	}

	public Payment(String payno, String hostelno,
	               Timestamp paytime, double inCome,
	               double ratio, double fee,
	               double outcome) {
		this.payno = payno;
		this.hostelno = hostelno;
		this.paytime = paytime;
		this.inCome = inCome;
		this.ratio = ratio;
		this.fee = fee;
		this.outcome = outcome;
	}

	public String getPayno() {
		return payno;
	}

	public void setPayno(String payno) {
		this.payno = payno;
	}

	public Timestamp getPaytime() {
		return paytime;
	}

	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}

	public String getHostelno() {
		return hostelno;
	}

	public void setHostelno(String hostelno) {
		this.hostelno = hostelno;
	}

	public double getInCome() {
		return inCome;
	}

	public void setInCome(double inCome) {
		this.inCome = inCome;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getOutcome() {
		return outcome;
	}

	public void setOutcome(double outcome) {
		this.outcome = outcome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Payment payment = (Payment) o;

		if (Double.compare(payment.inCome, inCome) != 0) return false;
		if (Double.compare(payment.ratio, ratio) != 0) return false;
		if (Double.compare(payment.fee, fee) != 0) return false;
		if (Double.compare(payment.outcome, outcome) != 0) return false;
		if (paytime != null ? !paytime.equals(payment.paytime) : payment.paytime != null) return false;
		if (payno != null ? !payno.equals(payment.payno) : payment.payno != null) return false;
		if (hostelno != null ? !hostelno.equals(payment.hostelno) : payment.hostelno != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = paytime != null ? paytime.hashCode() : 0;
		result = 31 * result + (payno != null ? payno.hashCode() : 0);
		result = 31 * result + (hostelno != null ? hostelno.hashCode() : 0);
		temp = Double.doubleToLongBits(inCome);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratio);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fee);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(outcome);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Payment{" +
				"payno='" + payno + '\'' +
				", hostelno='" + hostelno + '\'' +
				", paytime=" + paytime +
				", inCome=" + inCome +
				", ratio=" + ratio +
				", fee=" + fee +
				", outcome=" + outcome +
				'}';
	}

	public int compareTo(Object o) {
		return this.paytime.compareTo(((Payment) o).getPaytime());
	}
}

