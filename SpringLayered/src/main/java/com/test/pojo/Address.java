package com.test.pojo;

public class Address 
{
	private int addressId;
	private String street;
	private String city;
	private int zipCode;
	
	public Address() { }

	public Address(int addressId, String street, String city, int zipCode) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode
				+ "]";
	}
	
	

}
