package org.bank.app;

public interface Account 
{
	public void depositAmount(double amount);
	public void withdrawAmount(double amount);
	public double interestCalculation();
}
