package org.bank.app;

public class Customer 
{
	private String fname;
	private String lName;
	private String address;
	private long mobileNumber;
	private String email;
	
	public Customer() {
		
	}

	public Customer(String fname, String lName, String address, long mobileNumber, String email) {
		super();
		this.fname = fname;
		this.lName = lName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
