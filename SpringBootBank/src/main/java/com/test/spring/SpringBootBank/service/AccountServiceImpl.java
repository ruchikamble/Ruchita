package com.test.spring.SpringBootBank.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.IAccountDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.pojo.Customer;
import com.test.spring.SpringBootBank.pojo.Transaction;
import com.test.spring.SpringBootBank.wrapper.AccountBankCustWrapper;

@Service
public class AccountServiceImpl implements IAccountService
{
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	private IAccountDao accountDao;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IBankService bankService;
	
	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private ITransactionService transactionService;
	
	private Scanner sc = new Scanner(System.in);
	
	
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
	public String depositAmount(long accId) throws BankException 
	{
		Account account = null;
		Transaction transaction = new Transaction();

		account = accountService.getAccount(accId);
		if(account == null)
		{
			throw new BankException("Account does not exist");
		}
		else
		{
			System.out.println("Enter amount");
			BigDecimal amount = sc.nextBigDecimal();
			Bank bank = account.getBank();
			if(amount.compareTo(BigDecimal.ZERO) > 0)
			{
					account.setAmount(account.getAmount().add(amount));
					bank.setAmount(bank.getAmount().subtract(amount));
					bankService.updateAmount(bank);
					accountDao.save(account);
					transaction.setAccount(account);
					transaction.setCustomer(account.getCustomer());
					transaction.setAmount(amount);
					transaction.setTransactionType("Credited");
					transactionService.createTransaction(transaction);
					logger.info("amount is deposited successfully");
					return "amount is deposited";
				}
				
			else
			{
				logger.error("Invalid amount");
				throw new BankException("Invalid amount requested");
			}
			
		}
		
		
	}

	@Override
	public String withdrawAmount(long accId) throws BankException {
		Account account = null;
		Transaction transaction = new Transaction();
		account = accountService.getAccount(accId);
		if(account == null)
		{
			throw new BankException("Account does not exist");
		}
		else
		{
			System.out.println("Enter amount");
			BigDecimal amount = sc.nextBigDecimal();
			Bank bank = account.getBank();
			if(amount.compareTo(BigDecimal.ZERO) > 0)
			{
				if(amount.compareTo(bank.getAmount()) == -1)
				{
					account.setAmount(account.getAmount().subtract(amount));
					bank.setAmount(bank.getAmount().subtract(amount));
					bankService.updateAmount(bank);
					accountDao.save(account);
					transaction.setAccount(account);
					transaction.setCustomer(account.getCustomer());
					transaction.setAmount(amount);
					transaction.setTransactionType("Debited");
					transactionService.createTransaction(transaction);
					System.out.println(transaction.toString());
					logger.info("amount is withdrawn successfully");
					return "amount is withdrawn";
				}
				else
				{
					logger.error("Insufficient amount");
					throw new BankException("Amount is not sufficient in bank");
				}
			}
			else
			{
				logger.error("Invalid amount");
				throw new BankException("Invalid amount requested");
			}
		}
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
