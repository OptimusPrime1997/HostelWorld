package com.nju.entity;

import com.nju.util.State;

import java.io.Serializable;

/**
 * Created by OptimusPrime on 2017.3.10.
 */
public class User implements  Serializable{
	private String userno;
	private String password;
	private int userType;
	private String name;
	private String phoneNum;
	private double balance;
	private String address;
	private String bankAccount;
	private State state;

	public User() {
	}

	public User(String userno, String password, int userType, String name, String phoneNum, double balance, String address, String bankAccount, State state) {
		this.userno = userno;
		this.password = password;
		this.userType = userType;
		this.name = name;
		this.phoneNum = phoneNum;
		this.balance = balance;
		this.address = address;
		this.bankAccount = bankAccount;
		this.state = state;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (userType != user.userType) return false;
		if (Double.compare(user.balance, balance) != 0) return false;
		if (userno != null ? !userno.equals(user.userno) : user.userno != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (phoneNum != null ? !phoneNum.equals(user.phoneNum) : user.phoneNum != null) return false;
		if (address != null ? !address.equals(user.address) : user.address != null) return false;
		if (bankAccount != null ? !bankAccount.equals(user.bankAccount) : user.bankAccount != null) return false;
		if (state != null ? !state.equals(user.state) : user.state != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = userno != null ? userno.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + userType;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
		temp = Double.doubleToLongBits(balance);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (bankAccount != null ? bankAccount.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"userno='" + userno + '\'' +
				", password='" + password + '\'' +
				", userType=" + userType +
				", name='" + name + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				", balance=" + balance +
				", address='" + address + '\'' +
				", bankAccount='" + bankAccount + '\'' +
				", state=" + state +
				'}';
	}
}
