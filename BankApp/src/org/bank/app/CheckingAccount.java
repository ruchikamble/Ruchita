package org.bank.app;

public class CheckingAccount implements Account
{
	Customer customer;
	double balance;
	int accountId;
	int id;
	double interestAmt;
	public CheckingAccount(Customer customer, double balance, int accountId, int id) {
		super();
		this.customer = customer;
		this.balance = balance;
		this.accountId = accountId;
		this.id = id;
		//this.interestAmt = interestAmt;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getInterestAmt() {
		return interestAmt;
	}
	
	@Override
	public void depositAmount(double amount) {
		this.balance = balance + amount;
		
	}
	@Override
	public void withdrawAmount(double amount) {
		this.balance = balance - amount;
		
	}
	@Override
	public double interestCalculation() {
		return interestAmt = this.balance * 0.03 * 2;
		
	}
	
	

}
