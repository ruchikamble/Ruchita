package com.test.springBank.BankAppn;

public interface Account 
{
	public void depositAmount(double amount);
	public void withdrawAmount(double amount);
	public double interestCalculation();
}

