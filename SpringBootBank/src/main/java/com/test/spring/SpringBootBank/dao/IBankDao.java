package com.test.spring.SpringBootBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Bank;

@Repository
public interface IBankDao extends JpaRepository<Bank, Long>
{
	//BankPojo createBank(BankPojo bank) throws BankException;
	
	//BankPojo showBankDetails(long bankId) throws BankException;
}
