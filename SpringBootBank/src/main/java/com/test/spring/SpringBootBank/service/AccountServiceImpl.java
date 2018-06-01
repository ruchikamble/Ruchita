package com.test.spring.SpringBootBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.IAccountDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.pojo.Customer;
import com.test.spring.SpringBootBank.wrapper.AccountBankCustWrapper;

@Service
public class AccountServiceImpl implements IAccountService
{
	@Autowired
	private IAccountDao accountDao;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IBankService bankService;
	
	@Autowired
	private ICustomerService custService;
	
	
	@Override
	public Account createAccount(AccountBankCustWrapper wrapper) throws BankException
	{
		Account account = null;
		Customer customer = custService.getCustomerDetails(wrapper.getCustomerId());
		if(customer == null)
		{
			throw new BankException("Invalid customer Id");
		}
		else
		{
			Bank bank = bankService.showBankDetails(customer.getBank().getBankId());
			account = wrapper.getAccount();
			account.setCustomer(customer);
			account.setBank(bank);
			return accountDao.save(account);
		}
		
	}
	
	
	@Override
	public double depositAmount(long accId, double amount) throws BankException 
	{
		Account account = null;
		double amt = 0;
		account = accountService.getAccount(accId);
		if(account == null)
		{
			throw new BankException("Account does not exist");
		}
		else
		{
			amt = account.getAmount() + amount;
			account.setAmount(amt);
			accountDao.save(account);
			Bank bank = account.getBank();
			double bankAmt = bank.getAmount() + amount;
			bank.setAmount(bankAmt);
			bankService.updateAmount(bank);
		}
		
		return amt;
	}

	@Override
	public double withdrawAmount(long accId, double amount) throws BankException {
		Account account = null;
		double amt = 0;
		account = accountService.getAccount(accId);
		if(account == null)
		{
			throw new BankException("Account does not exist");
		}
		else
		{
			amt = account.getAmount() - amount;
			account.setAmount(amt);
			accountDao.save(account);
			Bank bank = account.getBank();
			double bankAmt = bank.getAmount() - amount;
			bank.setAmount(bankAmt);
			bankService.updateAmount(bank);
		}
		
		return amt;
	}


	@Override
	public Account getAccount(long accId) throws BankException 
	{
		Optional<Account> accList = accountDao.findById(accId);
		if(accList.isPresent())
		{
			return accList.get();
		}
		else
		{
			throw new BankException("Id does not exist");
		}
	}

}
