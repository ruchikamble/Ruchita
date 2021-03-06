package com.test.spring.SpringBootBank;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.spring.SpringBootBank.exception.BankException;
import com.test.spring.SpringBootBank.pojo.Account;
import com.test.spring.SpringBootBank.service.IAccountService;

/*@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration*/
@ComponentScan("application.properties")
public class TestCases 
{
	@Autowired
	private IAccountService accountService;
	
	@Test
	public void testDeposit() throws BankException
	{
		Account account = accountService.getAccount(1L);
		System.out.println(account.toString());
		account.setAmount(account.getAmount().add(new BigDecimal(200)));
		Account account1 = accountService.depositAmount(1L, new BigDecimal(200));
		Assert.assertEquals(account.getAmount(), account1.getAmount());
	}

}
