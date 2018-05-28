package com.test.pojo;

public class Account 
{
	private int AccountId;
	private double balance;
	private float interest = 0.04f;
	
	
	public Account() 
	{
		
	}
	/**
	 * @param accountId
	 * @param balance
	 * @param interest
	 */
	public Account(int accountId, double balance, float interest) {
		super();
		AccountId = accountId;
		this.balance = balance;
		this.interest = interest;
	}
	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return AccountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the interest
	 */
	public float getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(float interest) {
		this.interest = interest;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [AccountId=" + AccountId + ", balance=" + balance + ", interest=" + interest + "]";
	}
	
	
	


}
