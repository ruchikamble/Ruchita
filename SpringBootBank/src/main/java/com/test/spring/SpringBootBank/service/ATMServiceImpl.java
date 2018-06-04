package com.test.spring.SpringBootBank.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger(ATMServiceImpl.class);
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
			logger.error("BankId does not exist");
			throw new BankException("Bank does not exist");
		}
		else
		{
			atm = wrapper.getAtm();
			atm.setBank(bank);
			atm1 = atmDao.save(atm);
		}
		
		if(atm1 == null)
		{
			logger.error("ATM does not created");
			throw new BankException("Error in creating ATM");
		}
		return atm1;
	}

	@Override
	public String addMoney(long atmId) throws BankException {
		ATM atm = this.getATMDetails(atmId);
		if(atm == null)
		{
			throw new BankException("Id does not exist");
		}
		else
		{
			System.out.println("Enter the amount");
			BigDecimal amt = sc.nextBigDecimal();
			Bank bank = atm.getBank();
			BigDecimal amtBank = bank.getAmount();
			if(amt.compareTo(BigDecimal.ZERO) > 0)
			{
				if(amt.compareTo(amtBank) == -1)
				{
					atm.setAmount(atm.getAmount().add(amt));
					bank.setAmount(amtBank.subtract(amt));
					bankService.updateAmount(bank);
					atmDao.save(atm);
					logger.info("Amount is added to the atm");
					return "amount is added";
				}
				else
				{
					logger.error("Insufficient balance");
					throw new BankException("Bank does not sufficient amount");
				}
			}
			else
			{
				logger.error("Invalid amount");
				throw new BankException("Amount should be greater than zero");
			}
		}
			
	}

	@Override
	public String withdrawMoney(long atmId) throws BankException {
		ATM atm = this.getATMDetails(atmId);
		if(atm == null)
		{
			throw new BankException("Id does not exist");
		}
		else
		{
			System.out.println("Enter the amount");
			BigDecimal amt = sc.nextBigDecimal();
			BigDecimal amtATM = atm.getAmount();
			if(amt.compareTo(BigDecimal.ZERO) > 0)
			{
				if(amt.compareTo(amtATM) == -1)
				{
					atm.setAmount(atm.getAmount().subtract(amt));
					atmDao.save(atm);
					logger.info("Amount is withdrawn successfully");
					return "amount is withdrawn";
				}
				else
				{
					logger.error("Insufficient balance");
					throw new BankException("ATM does not sufficient amount");
				}
			}
			else
			{
				logger.error("Invalid amount");
				throw new BankException("Amount should be greater than zero");
			}
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
