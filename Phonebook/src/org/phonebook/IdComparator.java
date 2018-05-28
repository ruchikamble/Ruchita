package org.phonebook;

import java.util.Comparator;

public class IdComparator implements Comparator<PhoneBook> 
{

	@Override
	public int compare(PhoneBook o1, PhoneBook o2) {
		if(o1.getSerialNo() == o2.getSerialNo())
			return 0;
		else if(o1.getSerialNo() > o2.getSerialNo())
			return 1;
		else return -1;
		
	}

}
