package org.phonebook;

public class PhoneBook 
{
	
	private static int serialNo = 1;
	private String firstName;
	private String lastName;
	private String phoneNo;
	
	public PhoneBook( String firstName, String lastName, String phoneNo) {
		super();
		//this.serialNo = serialNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	public int getSerialNo() {
		return serialNo++;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}

