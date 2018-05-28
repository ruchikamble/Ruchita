package com.test.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.test.mapper.AccountMapper;
import com.test.pojo.Account;

public class SavingAccount implements AccountDao
{
	private JdbcTemplate jdbcTemplate;
	
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

	public int createAccount(Account account) 
	{
		return jdbcTemplate.update("insert into account values (?, ?, ?)", account.getAccountId(), account.getBalance(), account.getInterest());
	}

	public int deleteAccount(int id) {
		return jdbcTemplate.update("delete from account where accountId = ?", id);
	}
	
	
	@Override
	public List<Account> showAccount() {
	
		return jdbcTemplate.query("select * from account", new AccountMapper());
	}

}
