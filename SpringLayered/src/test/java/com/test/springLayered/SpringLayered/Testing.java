package com.test.springLayered.SpringLayered;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.CustomerDaoImplementation;
import com.test.pojo.Customer;
import com.test.service.CustomerServiceImplementation;

public class Testing 
{
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerServiceImplementation service = (CustomerServiceImplementation) context.getBean("customerService");
	Customer customer = (Customer) context.getBean("customers");
	Customer cust = (Customer) context.getBean("customers");
	CustomerDaoImplementation custDao = (CustomerDaoImplementation) context.getBean("customerDao");
	
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
		assertEquals(customer.getfName(), customers.get(0).getfName());
	}
	
	@Test
	public void testDeleteCustomer() throws SQLException
	{
		int status = service.deleteCustomer(1);
		assertEquals(1, status);
	}
	
	@Test
	public void testShowAllCustomers() throws Exception 
	{
		List<Customer> list = service.showAllCustomers();
		assertEquals(1,list.size());
	}
	
	@Test
	public void testUpdateCustomers()
	{
		
		int status = service.updateCustomer(1,"jaiswal@gmail.com" );
		
		
		assertEquals("jaiswal@gmail.com", );
	}
	
}
	