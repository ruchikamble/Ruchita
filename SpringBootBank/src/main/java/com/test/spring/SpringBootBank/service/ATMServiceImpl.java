package com.test.spring.SpringBootBank.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.spring.SpringBootBank.dao.IAtmDao;
import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.ATM;
import com.test.spring.SpringBootBank.pojo.Bank;
import com.test.spring.SpringBootBank.wrapper.BankATMWrapper;

@Service
public class ATMServiceImpl implements IAtmService
{
	@Autowired
	private IAtmDao atmDao;
	
	@Autowired
	private IBankService bankService;
	
	private Scanner sc = new Scanner(System.in);

	@Override
	public ATM createATM(BankATMWrapper wrapper) throws BankException 
	{
		ATM atm = null;
		ATM atm1 = null;
		Bank bank = bankService.showBankDetails(wrapper.getBankId());
		if(bank == null)
		{
			throw new BankException("Bank does not exist");
		}
		else
		{
			atm = wrapper.getAtm();
			atm.setBank(bank);
			atm1 = atmDao.save(atm);
			double amt = (bank.getAmount()) - (wrapper.getAtm().getAmount());
			bank.setAmount(amt);
			bankService.updateAmount(bank);
		}
		
		if(atm1 == null)
		{
			throw new BankException("Error in creating ATM");
		}
		return atm1;
	}

	@Override
	public double addMoney(long atmId) throws BankException {
		ATM atm = this.getATMDetails(atmId);
		if(atm == null)
		{
			throw new BankException("Id does not exist");
		}
		else
		{
			System.out.println("Enter the amount");
			double amt = sc.nextDouble();
			atm.setAmount(atm.getAmount() + amt);
			atmDao.save(atm);
			Bank bank = atm.getBank();
			bank.setAmount(bank.getAmount() - amt);
			bankService.updateAmount(bank);
		}
		return 0;
	}

	@Override
	public double withdrawMoney(long atmId) throws BankException {
		ATM atm = this.getATMDetails(atmId);
		if(atm == null)
		{
			throw new BankException("Id does not exist");
		}
		else
		{
			System.out.println("Enter the amount");
			double amt = sc.nextDouble();
			if(amt > atm.getAmount())
			{
			atm.setAmount(atm.getAmount() - amt);
			atmDao.save(atm);
			}
			throw new BankException("Insufficient amount in atm");
		}
		
	}

	@Override
	public ATM getATMDetails(long atmId) throws BankException {
		Optional<ATM> atmList = atmDao.findById(atmId);
		if(atmList.isPresent())
		{
			return  atmList.get();
		}
		return null;
	}

}
