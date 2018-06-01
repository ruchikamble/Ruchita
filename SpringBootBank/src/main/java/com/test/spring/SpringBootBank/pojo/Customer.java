package com.test.spring.SpringBootBank.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer 
{
	private long customerId;
	private String custName;
	private long pin;
	private Bank bank;
	
	public Customer() 
	{  }

	/**
	 * @param customerId
	 * @param bankId
	 * @param custName
	 * @param pin
	 */
	public Customer(long customerId, String custName, long pin, Bank bank) {
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.pin = pin;
		this.bank = bank;
	}

	/**
	 * @return the customerId
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the custName
	 */
	
	@Column(name = "custName")
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the pin
	 */
	@Column(name = "pin")
	public long getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(long pin) {
		this.pin = pin;
	}

	/**
	 * @return the bank
	 */
	
	@ManyToOne
	@JoinColumn( name = "bankId", nullable = false)
	public Bank getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName + ", pin=" + pin
				+ "]";
	}
	
	
	

}
