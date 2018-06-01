package com.test.spring.SpringBootBank.controller;

import java.util.Optional;

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
import com.test.spring.SpringBootBank.pojo.Customer;
import com.test.spring.SpringBootBank.service.IBankService;
import com.test.spring.SpringBootBank.service.ICustomerService;
import com.test.spring.SpringBootBank.wrapper.BankCustomerWrapper;

@RestController
public class CustomerController 
{
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IBankService bankService;
	
	
	
	@PostMapping(value = "/createCust")
	public ResponseEntity<?> createCustomer(@RequestBody BankCustomerWrapper wrapper)
	{
		Customer cust = null;
		try 
		{
			Bank bank = bankService.showBankDetails(wrapper.getBankId());
			//System.out.println(bank.toString());
			if(bank == null)
			{
				return new ResponseEntity<String>("Bank does not exist", HttpStatus.OK);
			}
			else
			{
				System.out.println(bank.toString());
				cust = wrapper.getCustomer();
				cust.setBank(bank);
				Customer custum = customerService.createCustomer(cust);
				System.out.println(cust.toString());
				return new ResponseEntity<Customer>(custum, HttpStatus.OK);
			}
		} 
		catch (BankException e) 
		{
			e.getMessage();
			return new  ResponseEntity<String>("Customer creation failed", HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getCust/{custId}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable long custId)
	{
		Customer customer = null;
		try 
		{
			 customer = customerService.getCustomerDetails(custId);

		} 
		catch (BankException e) 
		{
			e.getMessage();
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping(value="/deleteCust/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable long custId)
	{
		try {
			customerService.deletecustomer(custId);
		} catch (BankException e) {
			e.getMessage();
		}
		
		return new ResponseEntity<String>("Customer is deleted successfully", HttpStatus.OK);
	}
}
