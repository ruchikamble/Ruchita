package com.test.service;

import java.util.List;

import com.test.exception.BankException;
import com.test.pojo.Customer;

public interface CustomerServiceInterface 
{
	public int createCustomer(Customer customer) throws BankException;
	
	public int deleteCustomer(int id) throws BankException;
	
	public int updateCustomer(int id, String email) throws BankException;
	
	public List<Customer> showAllCustomers() ;

}
