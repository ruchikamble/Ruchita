package com.test.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.controller.MyController;
import com.test.dao.CustomerDaoImplementation;
import com.test.pojo.Customer;

public class CustomerServiceImplementation  implements CustomerServiceInterface 
{
	ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerDaoImplementation customerDao = (CustomerDaoImplementation) context1.getBean("customerDao");
	//CustomerDaoImplementation customerDao = new CustomerDaoImplementation();
	
	
	/**
	 * @return the customerDao
	 */
	/*public CustomerDaoImplementation getCustomerDao() {
		return customerDao;
	}

	*//**
	 * @param customerDao the customerDao to set
	 * @throws SQLException 
	 *//*
	public void setCustomerDao(CustomerDaoImplementation customerDao) {
		this.customerDao = customerDao;
	}*/

	public int createCustomer(Customer customer) throws SQLException 
	{
		 return this.customerDao.createCustomer(customer);
		
	}

	public int deleteCustomer(int id) throws SQLException 
	{
		return this.customerDao.deleteCustomer(id);
	}

	public int updateCustomer(int id, String email) throws SQLException 
	{
		return this.customerDao.updateCustomer(id, email);
	}

	public List<Customer> showAllCustomers() throws Exception 
	{
		List<Customer> list = this.customerDao.showAllCustomers();
		System.out.println(list);
		return list;
	}

}
