package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.mapper.CustomerMapper;
import com.test.pojo.Customer;

public class CustomerDaoImplementation implements CustomerDaoInterface 
{
	//jdbc template object
	private JdbcTemplate jdbcTemplate ; 
	
	
	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//create customer method
	public int createCustomer(Customer customer) throws SQLException
	{
		
		String SQL = "insert into Customer  values (?,?,?,?,?,?)";  //insert query for create customer
		
		System.out.println(customer.getCustomerId() + customer.getAddressId() +customer.getAccountId() + customer.getfName()+ customer.getlName()+ customer.getEmail());
		
		return jdbcTemplate.update(SQL, customer.getCustomerId(), customer.getAddressId(), customer.getAccountId(), customer.getfName(), customer.getlName(), customer.getEmail());

	}

	//delete customer method
	public int deleteCustomer(int id) throws SQLException
	{
		String SQL = "delete from Customer where customerId = ?";        //delete query
		return jdbcTemplate.update(SQL,id);
		
	}

	//update customer
	public int updateCustomer(int id, String email) throws SQLException 
	{
		String SQL = "update Customer set email = ? where customerId = ?";     //update query
		return jdbcTemplate.update(SQL, email, id);
		
	}

	
	//method to list all customers
	public List<Customer> showAllCustomers() throws Exception
	{
		return jdbcTemplate.query("select * from Customer", new CustomerMapper());  //select query
	}

	
	
	

	

}
