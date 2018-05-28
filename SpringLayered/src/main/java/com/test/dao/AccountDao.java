package com.test.dao;

import java.util.List;

import com.test.pojo.Account;

public interface AccountDao 
{
	public int createAccount(Account account);
	
	public int deleteAccount(int id);
	
	public List<Account> showAccount();
	

}
