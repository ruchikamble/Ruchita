package com.test.spring.SpringBootBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Transaction;
import com.test.spring.SpringBootBank.service.ITransactionService;

@RestController
public class TransactionController 
{
	@Autowired
	ITransactionService transactionService;
	
	@GetMapping(value = "/getTrans/{id}")
	public ResponseEntity<?> generateTransaction(@PathVariable long id) throws BankException
	{
		Transaction transaction = transactionService.generateTransaction(id);
		return new ResponseEntity<Transaction> (transaction, HttpStatus.OK);
	}
}
