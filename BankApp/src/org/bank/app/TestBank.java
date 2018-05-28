package org.bank.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestBank {

	public static void main(String[] args)
	{
		Customer customer = new  Customer("Ruchita", "Kamble", "Kalyan", 98765432, "ruchi@gmail.com");
		ArrayList<SavingAccount> list = new ArrayList<>();
		SavingAccount  account1 = new SavingAccount(customer, 1000, 201, 1);
		list.add(account1);
		
		Customer customer1 = new Customer("Rashmi", "Jaiswal", "Indore", 97534, "rshmi@gmail.com");
		ArrayList<FlexibleSavingAccount> list1 = new ArrayList<>();
		FlexibleSavingAccount  account2 = new FlexibleSavingAccount(customer1, 3000, 202, 2);
		list1.add(account2);
		
		Customer customer2 = new Customer("Rohan", "Joshi", "Pune", 97534, "rohan@gmail.com");
		ArrayList<CheckingAccount> list2 = new ArrayList<>();
		CheckingAccount  account3 = new CheckingAccount(customer2, 8000, 203, 3);
		list2.add(account3);


		Scanner sc = new Scanner(System.in);
		int ch;
		int choice;
		do
			{
				System.out.println("1.Savings Account");
				System.out.println("2.Flexible Savings Account");
				System.out.println("3.Checking Account");
				System.out.println("Enter the choice");
				ch = sc.nextInt();
			
				switch(ch)
					{
						case 1:
							System.out.println("1.Deposit Amount");
							System.out.println("2.Withdraw Amount");
							System.out.println("3.Interest Amount");
							System.out.println("Enter the choice");
							choice = sc.nextInt();
				
							if(choice == 1)
								{
									System.out.println("Enter the id");
									int id = sc.nextInt();
									Iterator<SavingAccount> itr1 = list.iterator();
									while(itr1.hasNext())
										{
											SavingAccount acc1 = itr1.next();
											if(acc1.id == id)
												{
													System.out.println("Enter the amount");
													double amt = sc.nextDouble();
													acc1.depositAmount(amt);
													System.out.println("Available balance is "+acc1.getBalance());
												}
					
										}
					
								}
							else if(choice == 2)
								{
									System.out.println("Enter the id");
									int id1 = sc.nextInt();
									Iterator<SavingAccount> itr2 = list.iterator();
									while(itr2.hasNext())
										{
											SavingAccount acc1 = itr2.next();
											if(acc1.id == id1)
												{
													System.out.println("Enter the amount");
													double amt = sc.nextDouble();
													if( acc1.getBalance() > amt)
														{
															acc1.withdrawAmount(amt);
															System.out.println("Available balance is "+acc1.getBalance());
														}
													else
														System.out.println("Insufficient balance");
												}
										}
				
								}
							else if(choice == 3)
								{
									System.out.println("Enter the id");
									int id2 = sc.nextInt();
									Iterator<SavingAccount> itr3 = list.iterator();
				
									while(itr3.hasNext())
										{
											SavingAccount acc1 = itr3.next();
											if(acc1.id == id2)
												{
						
													if( acc1.getBalance() > 0)
														{
															double interest = acc1.interestCalculation();
															System.out.println("Interest is : "+interest);
															System.out.println("Available balance is "+acc1.getBalance());
														}
													else
														System.out.println("Insufficient balance");
												}
										}
				
								}
				 
						case 2:
		
							System.out.println("1.Deposit Amount");
							System.out.println("2.Withdraw Amount");
							System.out.println("3.Interest Amount");
							System.out.println("Enter the choice");
							choice = sc.nextInt();
				
							if(choice == 1)
								{
									System.out.println("Enter the id");
									int id = sc.nextInt();
									Iterator<FlexibleSavingAccount> itr1 = list1.iterator();
									while(itr1.hasNext())
										{
											FlexibleSavingAccount acc1 = itr1.next();
											if(acc1.id == id)
												{
													System.out.println("Enter the amount");
													double amt = sc.nextDouble();
													acc1.depositAmount(amt);
													System.out.println("Available balance is "+acc1.getBalance());
												}
					
										}
					
								}
							else if(choice == 2)
								{
									System.out.println("Enter the id");
									int id1 = sc.nextInt();
									Iterator<FlexibleSavingAccount> itr2 = list1.iterator();
									while(itr2.hasNext())
										{
											FlexibleSavingAccount acc1 = itr2.next();
											if(acc1.id == id1)
												{
						
												System.out.println("Enter the amount");
												double amt = sc.nextDouble();
												if( acc1.getBalance() > amt)
													{
														acc1.withdrawAmount(amt);
														System.out.println("Available balance is "+acc1.getBalance());
													}
												else
													System.out.println("Insufficient balance");
												}
					
										}
				
								}	
			
							else if(choice == 3)
							{
								System.out.println("Enter the id");
								int id2 = sc.nextInt();
								Iterator<FlexibleSavingAccount> itr3 = list1.iterator();
				
								while(itr3.hasNext())
								{
									FlexibleSavingAccount acc1 = itr3.next();
									if(acc1.id == id2)
									{
										
										if( acc1.getBalance() > 0)
										{
											double interest = acc1.interestCalculation();
											System.out.println("Interest is : "+interest);
											System.out.println("Available balance is "+acc1.getBalance());
										}
										else
											System.out.println("Insufficient balance");
									}
								}
							}
			
		
						case 3:
				
							System.out.println("1.Deposit Amount");
							System.out.println("2.Withdraw Amount");
							System.out.println("3.Interest Amount");
							System.out.println("Enter the choice");
							choice = sc.nextInt();
				
							if(choice == 1)
							{
								System.out.println("Enter the id");
								int id = sc.nextInt();
								Iterator<CheckingAccount> itr1 = list2.iterator();
								while(itr1.hasNext())
								{
									CheckingAccount acc1 = itr1.next();
									if(acc1.id == id)
									{
										System.out.println("Enter the amount");
										double amt = sc.nextDouble();
										acc1.depositAmount(amt);
										System.out.println("Available balance is "+acc1.getBalance());
									}
					
								}
							}
							else if(choice == 2)
							{
								System.out.println("Enter the id");
								int id1 = sc.nextInt();
								Iterator<CheckingAccount> itr2 = list2.iterator();
								while(itr2.hasNext())
								{
									CheckingAccount acc1 = itr2.next();
									if(acc1.id == id1)
									{
						
										System.out.println("Enter the amount");
										double amt = sc.nextDouble();
										if( acc1.getBalance() > amt)
										{
											acc1.withdrawAmount(amt);
											System.out.println("Available balance is "+acc1.getBalance());
										}
										else
											System.out.println("Insufficient balance");
									}

								}
				
							}
				
							else if(choice == 3)
							{
								System.out.println("Enter the id");
								int id2 = sc.nextInt();
								Iterator<CheckingAccount> itr3 = list2.iterator();
				
								while(itr3.hasNext())
								{
									CheckingAccount acc1 = itr3.next();
									if(acc1.id == id2)
									{
						
										if( acc1.getBalance() > 0)
										{
											double interest = acc1.interestCalculation();
											System.out.println("Interest is : "+interest);
											System.out.println("Available balance is "+acc1.getBalance());
										}
										else
											System.out.println("Insufficient balance");
									}
								}
				
							}
			
					}

			}while(ch != 0);

	}
}
	

	

