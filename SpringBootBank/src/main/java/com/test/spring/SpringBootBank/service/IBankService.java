package com.test.spring.SpringBootBank.service;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Bank;


public interface IBankService 
{
	Bank createBank(Bank bank) throws BankException;
	
	Bank showBankDetails(long bankId) throws BankException;	
	
	Bank updateAmount(Bank bank) throws BankException;
}
