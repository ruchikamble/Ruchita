package com.test.springBank.BankAppn;

import java.util.List;

public class SavingAccount implements Account {
	

	double balance;
	int accountId;
	
	
	
	public SavingAccount() {
		
	}
	
	public SavingAccount( double balance, int accountId) {
		super();
		
		this.balance = balance;
		this.accountId = accountId;
		
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public void depositAmount(double amount) {
		this.balance = this.balance + amount;
		
	}

	public void withdrawAmount(double amount) {
		this.balance = this.balance - amount;
		
	}

	public double interestCalculation() {
		
		return  this.balance * 0.04 * 2;
	}

	@Override
	public String toString() {
		return "SavingAccount [balance=" + balance + ", accountId=" + accountId + "]";
	}



	
	
	

}
