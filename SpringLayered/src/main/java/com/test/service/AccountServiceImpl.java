package com.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.SavingAccount;
import com.test.pojo.Account;

public class AccountServiceImpl implements AccountService
{
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SavingAccount savingAccount = (SavingAccount) context.getBean("savingAccount");

	public int createAccount(Account account) {
		return this.savingAccount.createAccount(account);
	}

	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Account findById(int id) 
	{
		Account accountById = null;
		List<Account> list = this.savingAccount.showAccount();
		for (Account account : list) 
		{
			if(account.getAccountId() == id)
			{
				int index = list.indexOf(account);
				accountById = list.get(index);
			}
		}
		
		return accountById;
	}

	public void depositAmount(double amount, Account account) 
	{
		double amount1 = account.getBalance() + amount;
		account.setBalance(amount1);
		System.out.println(account.getBalance());
	}

	public void withdrawAmount(double amount, Account account) 
	{
		double amount1 = account.getBalance() - amount;
		account.setBalance(amount1);
		System.out.println(account.getBalance());
	}

	public void interestCalculation() {
		// TODO Auto-generated method stub
		
	}

}
