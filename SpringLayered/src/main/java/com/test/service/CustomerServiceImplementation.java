package com.test.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.controller.MyController;
import com.test.dao.CustomerDaoImplementation;
import com.test.pojo.Customer;

/**---Customer service Layer--**/
public class CustomerServiceImplementation  implements CustomerServiceInterface 
{
	
	/**---Application Context Object---**/
	private final ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**---Application Context Object---**/
	private final CustomerDaoImplementation customerDao = (CustomerDaoImplementation) context1.getBean("customerDao");
	
	
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

	/**---create customer method--**/
	public int createCustomer(final Customer customer) throws SQLException 
	{
		 return this.customerDao.createCustomer(customer);
		
	}

	/**---delete customer method---**/
	public int deleteCustomer(final int id) throws SQLException 
	{
		return this.customerDao.deleteCustomer(id);
	}

	/**---update customer method---**/
	public int updateCustomer(final int id, final String email) throws SQLException 
	{
		return this.customerDao.updateCustomer(id, email);
	}

	/**---show all customer method---**/
	public List<Customer> showAllCustomers() throws Exception 
	{
		final List<Customer> list = this.customerDao.showAllCustomers();
		System.out.println(list);
		return list;
	}

}
