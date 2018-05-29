package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.pojo.Customer;

public interface CustomerDaoInterface 
{
	public int createCustomer(Customer customer) throws SQLException;
	
	public int deleteCustomer(int id) throws SQLException;
	
	public int updateCustomer(int id, String email) throws SQLException;
	
	public List<Customer> showAllCustomers() throws Exception;

}
