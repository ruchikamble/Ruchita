package com.test.spring.SpringBootBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.service.BankSeviceImpl;
import com.test.spring.SpringBootBank.service.IBankService;

@RestController
public class BankController 
{
	@Autowired
	private BankSeviceImpl bankService ;
	
	@PostMapping(value = "/create")
	public ResponseEntity<Bank> createBank(@RequestBody Bank bank) throws BankException
	{
		Bank bankPojo = bankService.createBank(bank);
		
		if(bankPojo == null)
		{
			throw new BankException("Bank is not created successfully");
		}
		else
		{
			return new ResponseEntity<Bank>(bankPojo, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Bank> showBankDetails(@PathVariable(value="id") long bankId) throws BankException
	{
		Bank bankPojo = bankService.showBankDetails(bankId);
		return new ResponseEntity<Bank>(bankPojo, HttpStatus.OK);
	}
	
	
}
