package com.test.spring.SpringBootBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.ICustomerDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	private ICustomerDao custDao;

	@Override
	public Customer createCustomer(Customer customer) throws BankException {
		Customer cust = custDao.save(customer);
		if(cust == null)
		{
			throw new BankException("Customer creation failed !!");
		}
		else
		{
			return cust;
		}
		
	}

	@Override
	public Customer getCustomerDetails(long custId) throws BankException {
		
		Optional<Customer> custList = custDao.findById(custId);
		if(custList.isPresent())
		{
			return custList.get();
		}
		else
		{
			throw new BankException("Id does not exist");
		}
	}

	@Override
	public String deletecustomer(long custId) throws BankException {
		Optional<Customer> custList = custDao.findById(custId);
		if(custList.isPresent())
		{
			custDao.deleteById(custId);
			return "Customer is deleted successfully";
		}
		else
		{
			throw new BankException("Id does not exist");
		}

	}

	@Override
	public Customer updateCustomer(Customer customer) throws BankException {
		// TODO Auto-generated method stub
		return null;
	}

}
