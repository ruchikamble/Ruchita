package com.test.springLayered.SpringLayered;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.CustomerDaoImplementation;
import com.test.exception.BankException;
import com.test.pojo.Account;
import com.test.pojo.Customer;
import com.test.service.AccountServiceImpl;
import com.test.service.CustomerServiceImplementation;

public class Testing 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	CustomerServiceImplementation service = (CustomerServiceImplementation) context.getBean("customerService");
	
	Customer customer = (Customer) context.getBean("customers");
	
	Customer cust = (Customer) context.getBean("customers");
	
	CustomerDaoImplementation custDao = (CustomerDaoImplementation) context.getBean("customerDao");
	
	AccountServiceImpl accountSeviceImpl = (AccountServiceImpl) context.getBean("accountService");
	
	Account account = (Account) context.getBean("account");
	
	@Test
	public void testCreateCustomer() throws Exception
	{
		customer.setAccountId(2);
		customer.setAddressId(2);
		customer.setCustomerId(2);
		customer.setfName("Rashmi");
		customer.setlName("Jaiswal");
		customer.setEmail("rashmi@gmail.com");
		
		int status = service.createCustomer(customer);
		
		List<Customer> customers = custDao.showAllCustomers();
		
		assertEquals(1, status);
		assertEquals(customer.getfName(), customers.get(1).getfName());
	}
	
	@Test
	public void testDeleteCustomer() throws BankException
	{
		int status = service.deleteCustomer(1);
		assertEquals(1, status);
	}
	
	@Test
	public void testShowAllCustomers()  
	{
		List<Customer> list = service.showAllCustomers();
		assertEquals(3,list.size());
	}
	
	@Test
	public void testUpdateCustomers() throws Exception
	{
		
		service.updateCustomer(3,"jaiswal@gmail.com" );
		
		List<Customer> customers = custDao.showAllCustomers();
		
		assertEquals("jaiswal@gmail.com", customers.get(0).getEmail());
	}
	
	@Test
	public void testFindById()
	{
		Account acc = accountSeviceImpl.findById(2);
		assertEquals(2000.0, acc.getBalance());
	}
	
	@Test
	public void testCreateAccount()
	{
		account.setAccountId(3);
		account.setBalance(2000);
		int status = accountSeviceImpl.createAccount(account);
		assertEquals(1, status);
	}
	
	@Test
	public void testDeleteAccount()
	{
		int status = accountSeviceImpl.deleteAccount(2);
		assertEquals(2, status);
	}
	
}
	