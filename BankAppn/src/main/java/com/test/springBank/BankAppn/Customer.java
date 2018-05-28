package com.test.springBank.BankAppn;

import java.util.List;

public class Customer 
{
	
	private List<String> fName;
	private List<String> lName;
	private List<String> mobileNumber;
	private List<String> email;
	private List<Address> address;
	private List<SavingAccount> saving;
	
	public List<String> getfName() {
		return fName;
	}



	public void setfName(List<String> fName) {
		this.fName = fName;
	}



	public List<String> getlName() {
		return lName;
	}



	public void setlName(List<String> lName) {
		this.lName = lName;
	}



	public List<String> getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(List<String> mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public List<String> getEmail() {
		return email;
	}



	public void setEmail(List<String> email) {
		this.email = email;
	}



	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}



	public List<SavingAccount> getSaving() {
		return saving;
	}



	public void setSaving(List<SavingAccount> saving) {
		this.saving = saving;
	}


	
	/*private String fname;
	private String lName;
	private String address;
	private long mobileNumber;
	private String email;
	private SavingAccount saving;
	
	public Customer(String fname, String lName, String address, long mobileNumber, String email, SavingAccount saving) {
		super();
		this.fname = fname;
		this.lName = lName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.saving = saving;
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
	
	
	public SavingAccount getSaving() {
		return saving;
	}

	public void setSaving(SavingAccount saving) {
		this.saving = saving;
	}
	
*/

	

	@Override
	public String toString() {
		return "Customer [fname=" + fName + ", lName=" + lName + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", saving=" + saving + "]";
	}
	
	

}
