package com.test.service;

import com.test.pojo.Account;

public interface AccountService 
{
public int createAccount(Account account);
	
	public int deleteAccount(int id);
	
	public void depositAmount(double amount, Account account );
	
	public void withdrawAmount(double amount, Account account);
	
	public void interestCalculation();

}
