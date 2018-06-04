package com.test.spring.SpringBootBank.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.ITransactionDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService 
{
	private Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Autowired
	private ITransactionDao transacDao;

	@Override
	public String createTransaction(Transaction transaction) {
		transacDao.save(transaction);
		return "Transaction report is saved successfully";
	}

	@Override
	public Transaction generateTransaction(long transId) throws BankException  {
		Optional<Transaction> list = transacDao.findById(transId);
		if(list.isPresent())
		{
			Transaction transaction = list.get();
			return transaction;
		}
		else
		{
			logger.error("Transaction does not exist");
			throw new BankException("Invalid Transaction Id");
		}
		
	}
	
}
