package com.test.pojo;

public class Customer 
{
	private int customerId;
	private int addressId;
	private int accountId;
	private String fName;
	private String lName;
	private String email;
	
	public Customer() { }

	public Customer(int customerId, int addressId, int accountId, String fName, String lName,
			String email) {
		super();
		this.customerId = customerId;
		this.addressId = addressId;
		this.accountId = accountId;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", addressId=" + addressId + ", accountId=" + accountId
				+ ", fName=" + fName + ", lName=" + lName + ", email=" + email + "]";
	}
	
	

}
