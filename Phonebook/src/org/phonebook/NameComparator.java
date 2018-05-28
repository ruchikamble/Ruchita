package org.phonebook;

import java.util.Comparator;

public class NameComparator implements Comparator<PhoneBook> 
{

	@Override
	public int compare(PhoneBook o1, PhoneBook o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
		
	}

}
