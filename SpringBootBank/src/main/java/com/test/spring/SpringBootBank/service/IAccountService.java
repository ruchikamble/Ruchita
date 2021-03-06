package com.test.spring.SpringBootBank.service;

import java.math.BigDecimal;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.wrapper.AccountBankCustWrapper;

public interface IAccountService 
{
	public Account createAccount(AccountBankCustWrapper wrapper) throws BankException;
	
	public Account getAccount(long accId) throws BankException;
	
	public Account depositAmount(long accId, BigDecimal amount) throws BankException;
	
	public String withdrawAmount(long accId) throws BankException; 
}
