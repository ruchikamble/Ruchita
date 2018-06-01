package com.test.spring.SpringBootBank.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.pojo.Customer;
import com.test.spring.SpringBootBank.service.IAccountService;
import com.test.spring.SpringBootBank.service.IBankService;
import com.test.spring.SpringBootBank.service.ICustomerService;
import com.test.spring.SpringBootBank.wrapper.AccountBankCustWrapper;

@RestController
public class AccountController 
{
	Logger logger = Logger.getLogger(AccountController.class);
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IBankService bankService;
	
	@Autowired
	private ICustomerService custService;
	
	private Scanner sc= new Scanner(System.in);
	
	@PostMapping(value = "/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody AccountBankCustWrapper wrapper) throws BankException
	{
		Account account = accountService.createAccount(wrapper);
		if(account == null)
		{
			logger.error("Account is not created");
		}
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/depositAmt/{accId}")
	public ResponseEntity<?> depositAmount(@PathVariable long accId) throws BankException 
	{
		System.out.println("Enter the amount");
		
		double amount = accountService.depositAmount(accId, sc.nextDouble());
		 
		if(amount == 0)
		{
			logger.error("Amount is not deposited");
		}
		
		return new ResponseEntity<String>("Amount is deposited", HttpStatus.OK);
	}
}
