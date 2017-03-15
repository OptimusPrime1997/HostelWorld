package com.nju.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Deposit implements Serializable{
	private String depositno;
	private String bankAccount;
	private Timestamp time;
	private double depositAmount;

	public Deposit() {
	}

	public Deposit(String depositno, String bankAccount, Timestamp time, double depositAmount) {
		this.depositno = depositno;
		this.bankAccount = bankAccount;
		this.time = time;
		this.depositAmount = depositAmount;
	}

	public String getDepositno() {
		return depositno;
	}

	public void setDepositno(String depositno) {
		this.depositno = depositno;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Deposit deposit = (Deposit) o;

		if (Double.compare(deposit.depositAmount, depositAmount) != 0) return false;
		if (depositno != null ? !depositno.equals(deposit.depositno) : deposit.depositno != null) return false;
		if (bankAccount != null ? !bankAccount.equals(deposit.bankAccount) : deposit.bankAccount != null) return false;
		if (time != null ? !time.equals(deposit.time) : deposit.time != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = depositno != null ? depositno.hashCode() : 0;
		result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
		result = 31 * result + (time != null ? time.hashCode() : 0);
		temp = Double.doubleToLongBits(depositAmount);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Deposit{" +
				"depositno='" + depositno + '\'' +
				", bankAccount='" + bankAccount + '\'' +
				", time=" + time +
				", depositAmount=" + depositAmount +
				'}';
	}
}
