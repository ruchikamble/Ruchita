package com.test.spring.SpringBootBank.service;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Transaction;

public interface ITransactionService 
{
	public String createTransaction(Transaction transaction);
	
	public Transaction generateTransaction(long transId) throws BankException;
}
