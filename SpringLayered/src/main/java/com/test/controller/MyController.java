package com.test.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.exception.BankException;
import com.test.pojo.Account;
import com.test.pojo.Customer;
import com.test.service.AccountServiceImpl;
import com.test.service.CustomerServiceImplementation;


public class MyController {

	/*---Application context object---*/
	static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
	/*---Customer pojo object---*/
	static Customer customer = (Customer) context.getBean("customers");
	
	/*---CustomerServiceImplementation object---*/
	static CustomerServiceImplementation serviceImplementation = (CustomerServiceImplementation) context.getBean("customerService");
	
	/*---AccountServiceImplementation object---*/
	static AccountServiceImpl accountSeviceImpl = (AccountServiceImpl) context.getBean("accountService");
	
	static Account account = (Account) context.getBean("account");
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) throws Exception
	{
		
		int choice;
		
		do
		{
			System.out.println("1. Create Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer");
			System.out.println("4. Display List of Customer");
			System.out.println("5.Create Account");
			System.out.println("6. Deposit");
			System.out.println("7. Withdraw");
			System.out.println("Enter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
			
			// Create customer
			case 1:
				customer.setCustomerId(1);
				customer.setAccountId(1);
				customer.setAddressId(1);
				customer.setfName("Rohan");
				customer.setlName("Joshi");
				customer.setEmail("rohan@gmail.com");
				serviceImplementation.createCustomer(customer);
				break;

				//Update customer
			case 2:
				System.out.println("Enter Id");
				int idUpdate = sc.nextInt();
				Account accountUpdate = accountSeviceImpl.findById(idUpdate);
				if(accountUpdate != null)
					serviceImplementation.updateCustomer(1, "joshi@gmail.com");
				else
					throw new BankException("Invalid Id");
				
				break;
				
				//delete customer
			case 3:
				System.out.println("Enter Id");
				final int idDelete = sc.nextInt();
				final Account accountDelete = accountSeviceImpl.findById(idDelete);
				if(accountDelete != null)
				{
					serviceImplementation.deleteCustomer(1);
				}
				else
				{
					throw new BankException("Invalid Id");
				}
				break;
				
				//display customer
			case 4:
				serviceImplementation.showAllCustomers();
				break;
			
			case 5:
				//create account
				account.setAccountId(2);
				account.setBalance(2000);
				accountSeviceImpl.createAccount(account);
				break;
				
			case 6:
				//deposit amount
				System.out.println("Enter the id");
				final int idDeposit = sc.nextInt();
				
				final Account accountDeposit = accountSeviceImpl.findById(idDeposit);   //validating
				
				if(accountDeposit != null)
				{
					System.out.println("Enter the amount");
					final double balance = sc.nextDouble();
					accountSeviceImpl.depositAmount(balance, accountDeposit);
				}
				else
				{
					throw new BankException("Invalid Id");
				}
				break;
				
			case 7:
				//withdraw amount
				System.out.println("Enter the id");
				final int idWithdraw = sc.nextInt();
				
				final Account accountWithdraw = accountSeviceImpl.findById(idWithdraw);  //validating
				
				if(accountWithdraw != null)
				{
					System.out.println("Enter the amount");
					final double balance = sc.nextDouble();
					accountSeviceImpl.withdrawAmount(balance, accountWithdraw);
				}
				else
				{
					throw new BankException("Invalid Id");
				}
				break;
				
			}
			
		}while(choice != 0);
		
	}

}
