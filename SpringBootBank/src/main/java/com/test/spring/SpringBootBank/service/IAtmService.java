package com.test.spring.SpringBootBank.service;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.ATM;
import com.test.spring.SpringBootBank.wrapper.BankATMWrapper;

public interface IAtmService 
{
	public ATM createATM(BankATMWrapper wrapper) throws BankException;
	
	public ATM getATMDetails(long atmId) throws BankException;
	
	public String addMoney(long atmId) throws BankException;
	
	public String withdrawMoney(long atmId) throws BankException;
}
