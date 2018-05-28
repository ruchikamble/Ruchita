package com.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.test.pojo.Customer;

public class CustomerMapper implements RowMapper<Customer> 
{

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Customer customer = new Customer(rs.getInt("accountId"), rs.getInt("addressId"), rs.getInt("accountId"), rs.getString("fName"), rs.getString("lName"), rs.getString("email"));
		return customer;
	}

}
