package com.test.spring.SpringBootBank.service;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Customer;


public interface ICustomerService 
{
	public Customer createCustomer(Customer customer) throws BankException;
	
	public Customer getCustomerDetails(long custId) throws BankException;
	
	public String deletecustomer(long custId) throws BankException;
	
	public Customer updateCustomer(Customer customer) throws BankException;

}
