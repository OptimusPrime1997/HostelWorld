package com.nju.entity;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class Bankaccount {
	private String bankAccount;
	private double balance;
	private String password;

	public Bankaccount(String bankAccount, double balance, String password) {
		this.bankAccount = bankAccount;
		this.balance = balance;
		this.password = password;
	}

	public Bankaccount() {
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Bankaccount that = (Bankaccount) o;

		if (Double.compare(that.balance, balance) != 0) return false;
		if (bankAccount != null ? !bankAccount.equals(that.bankAccount) : that.bankAccount != null) return false;
		if (password != null ? !password.equals(that.password) : that.password != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = bankAccount != null ? bankAccount.hashCode() : 0;
		temp = Double.doubleToLongBits(balance);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Bankaccount{" +
				"bankAccount='" + bankAccount + '\'' +
				", balance=" + balance +
				", password='" + password + '\'' +
				'}';
	}
}
