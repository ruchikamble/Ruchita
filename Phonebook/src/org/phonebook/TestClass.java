package org.phonebook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args)
	{
		int choice;
		List<PhoneBook> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		PhoneBook phoneBook1 = new PhoneBook( "Rohan", "Joshi", "9873565678");
		PhoneBook phoneBook = new PhoneBook( "Ashu", "Kamble", "8763565678");
		list.add(phoneBook1);
		list.add(phoneBook);
		do
			{
				System.out.println("1. Add Data");
				System.out.println("2. Remove Data");
				System.out.println("3. Search by Number");
				System.out.println("4. Search by name");
				System.out.println("5. Search by sr no");
				System.out.println("6. Sort by Serial Number");
				System.out.println("7. Sort by Name");
				System.out.println("8. Display Records");
				System.out.println("Enter the choice");
			
				choice  = sc.nextInt();
			
				switch (choice) 
					{
						case 1:
							System.out.println("Enter the Details");
							System.out.println("Enter First Name");
							String fName = sc.next();
							System.out.println("Enter Last Name");
							String lName = sc.next();
							System.out.println("Enter Mobile Number");
							String mobNo = sc.next();
							PhoneBook phoneBook2 = new PhoneBook( fName, lName, mobNo);
							list.add(phoneBook2);
							break;
				
						case 2:
							System.out.println("Enter the Id to remove data : ");
							int removeId = sc.nextInt();
							list.remove(removeId);
							System.out.println("Records Deleted Successfully");
							//list.stream().forEach(i->{System.out.println(i);});
							break;
			    
						case 3:
							System.out.println("Enter the serial number to be searched");
							int searchByNo = sc.nextInt();
							Iterator<PhoneBook> itr  = list.iterator();
							while(itr.hasNext())
								{
									PhoneBook p = itr.next();
									int no = p.getSerialNo();
									if(no == searchByNo)
									{
										System.out.println(p.getSerialNo()+ " " + p.getFirstName()+ " " + p.getLastName()+ " " + p.getPhoneNo());
									}
									else
										System.out.println("Record Not found");
								}
							break;
				
						case 4:
							System.out.println("Enter the name to be searched");
							String searchByName = sc.next();
							Iterator<PhoneBook> itr1  = list.iterator();
							while(itr1.hasNext())
							{
								PhoneBook p = itr1.next();
								String name = p.getFirstName();
								if(name.equalsIgnoreCase(searchByName))
								{
									System.out.println(p.getSerialNo()+ " " + p.getFirstName()+ " " + p.getLastName()+ " " + p.getPhoneNo());
								}
								else
									System.out.println("Record Not found");
							}
							break;
				
						case 5:
							System.out.println("Enter the mobile number to be searched");
							String searchByMob = sc.next();
							Iterator<PhoneBook> itr2  = list.iterator();
							while(itr2.hasNext())
							{
								PhoneBook p = itr2.next();
								String mob = p.getPhoneNo();
								if(mob.equals(searchByMob))
								{
									System.out.println(p.getSerialNo()+ " " + p.getFirstName()+ " " + p.getLastName()+ " " + p.getPhoneNo());
								}
								else
									System.out.println("Record Not found");
							}
							break;
				
						case 6:
							Collections.sort(list, new IdComparator());
							list.stream().forEach(i-> {System.out.println(i.getSerialNo()+ " "+ i.getFirstName()+ " "+ i.getLastName() + " "+ i.getPhoneNo());});
							break;	
			
						case 7:
							Collections.sort(list, new NameComparator());
							list.stream().forEach(i-> {System.out.println(i.getFirstName()+ " ");});
							break;
				
						case 8:
							Iterator<PhoneBook> itr3 = list.iterator();
							if(list.size() > 0)
							{
								while(itr3.hasNext())
								{
									PhoneBook p = itr3.next();
									System.out.println(p.getSerialNo()+ " " + p.getFirstName()+ " " + p.getLastName()+ " " + p.getPhoneNo());
								}
							}
							else
								System.out.println("List is empty");
					}
			
			}while(choice != 0);
	

	}
}
