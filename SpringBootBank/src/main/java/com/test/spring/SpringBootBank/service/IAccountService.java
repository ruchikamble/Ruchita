package com.test.spring.SpringBootBank.service;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.wrapper.AccountBankCustWrapper;

public interface IAccountService 
{
	public Account createAccount(AccountBankCustWrapper wrapper) throws BankException;
	
	public Account getAccount(long accId) throws BankException;
	
	public double depositAmount(long accId, double amount) throws BankException;
	
	public double withdrawAmount(long accId, double amount) throws BankException; 
}
