package com.test.spring.SpringBootBank.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.ATM;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.service.IAtmService;
import com.test.spring.SpringBootBank.service.IBankService;
import com.test.spring.SpringBootBank.wrapper.BankATMWrapper;

@RestController
public class ATMController 
{
	private static Logger logger = Logger.getLogger(ATMController.class);
	@Autowired
	private IAtmService atmService;
	
	@Autowired
	private IBankService bankService;
	
	@PostMapping(value = "/createATM")
	public ResponseEntity<?> createATM(@RequestBody BankATMWrapper wrapper) throws BankException
	{
		ATM atm = atmService.createATM(wrapper);
		if(atm == null)
		{
			logger.error("ATM is not created");
		}
		return new ResponseEntity<ATM>(atm, HttpStatus.OK);
	}
}
