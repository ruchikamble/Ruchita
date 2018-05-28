package com.test.springBank.BankAppn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBank 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer = (Customer) context.getBean("cust");
		
		List<String> fName = new ArrayList<>();
		fName.add("Rashmi");
		fName.add("Ruchita");
		fName.add("Rohan");
		
		customer.setfName(fName);
		
		List<String> lName = new ArrayList<>();
		lName.add("Jaiswal");
		lName.add("Kamble");
		lName.add("Joshi");
		
		customer.setlName(lName);
		
		List<String> mobNumber = new ArrayList<>();
		mobNumber.add("9876543246");
		mobNumber.add("9876543246");
		mobNumber.add("9876543246");
		
		customer.setMobileNumber(mobNumber);
			
		SavingAccount account = (SavingAccount) context.getBean("save");
		account.setAccountId(1);
		account.setBalance(1000);
		
		List<SavingAccount> acc = new ArrayList<>();
		acc.add(account);
		
		SavingAccount account1 = (SavingAccount) context.getBean("save");
		account1.setAccountId(2);
		account1.setBalance(2000);
		acc.add(account1);
		
		SavingAccount account2 = (SavingAccount) context.getBean("save");
		account2.setAccountId(3);
		account2.setBalance(3000);
		acc.add(account2);
		
		customer.setSaving(acc);
		
		Address address = (Address) context.getBean("address");
		address.setStreet("Shankar Nagar");
		address.setZipCode(897867);
		address.setCity("Indore");
		
		List<Address> addr = new ArrayList<>();
		addr.add(address);
		
		Address address1 = (Address) context.getBean("address");
		address1.setStreet("Khadakpada");
		address1.setZipCode(897867);
		address1.setCity("Kalyan");
		addr.add(address1);
		
		Address address2 = (Address) context.getBean("address");
		address2.setStreet("Marketyard");
		address2.setZipCode(897867);
		address2.setCity("Pune");
		addr.add(address2);
		
		customer.setAddress(addr);
		
		System.out.println(customer.toString());
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("1.Deposit Amount");
			System.out.println("2.Withdraw Amount");
			System.out.println("3.Interest Amount");
			System.out.println("4. Display Customer");
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			
			switch (choice) {
			
			case 1:
				System.out.println("Enter the id");
				SavingAccount acnt = (SavingAccount) context.getBean("save");
				acnt.setAccountId(sc.nextInt());
				System.out.println("Enter the amount");
				double amt = sc.nextDouble();
				if(acc.contains(acnt))
				{
					int index = acc.indexOf(acnt);
					acnt = acc.get(index);
					acnt.depositAmount(amt);
				}
				break;

			case 2:
				System.out.println("Enter the id");
				int id1= sc.nextInt();
				Iterator<SavingAccount> itr1 = acc.iterator();
				while(itr1.hasNext())
				{
					SavingAccount acct = itr1.next();
					if(acct.getAccountId() == id1)
					{
						System.out.println("Enter amount to be withdrawn");
						double amt1 = sc.nextDouble();
						if(account.getBalance() > amt1)
						{
							account.withdrawAmount(amt1);
							System.out.println("The available balance is : "+account.getBalance());
						}
						else
						{
							System.out.println("Insufficient balance");
						}
					}
				}
				break;
				
			case 3:
				System.out.println(account.interestCalculation());
				break;
				
			case 4:
				System.out.println(customer.toString());
				break;
			}
			
		}while(choice != 0);
		
	}
	
}
