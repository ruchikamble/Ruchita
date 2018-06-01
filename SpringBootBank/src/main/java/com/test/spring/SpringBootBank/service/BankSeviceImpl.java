package com.test.spring.SpringBootBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.IBankDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Bank;

@Service
public class BankSeviceImpl implements IBankService
{
	@Autowired
	private IBankDao bankDao;
	
	@Override
	public Bank createBank(Bank bank) throws BankException 
	{
		return bankDao.save(bank);
	}

	@Override
	public Bank showBankDetails(long bankId) throws BankException 
	{
		Optional<Bank> bankList = bankDao.findById(bankId);
		if(bankList.isPresent())
		{
			return bankList.get();
		}
		else
		{
			throw new BankException("Id does not exist");
		}
		
		
	}

	@Override
	public Bank updateAmount(Bank bank) throws BankException 
	{
		return bankDao.save(bank);
	}

}
