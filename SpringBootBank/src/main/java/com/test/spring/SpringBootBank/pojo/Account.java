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
@Table(name = "account")
public class Account 
{
	private long accountId;
	private double amount;
	private Customer customer;
	private Bank bank;
	
	public Account() { }

	/**
	 * @param accountId
	 * @param amount
	 * @param customer
	 * @param bank
	 */
	public Account(long accountId, double amount, Customer customer, Bank bank) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.customer = customer;
		this.bank = bank;
	}

	/**
	 * @return the accountId
	 */
	
	@Column(name = "accountId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the amount
	 */
	
	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne
	@JoinColumn(name = "customerId" , nullable = false)
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the bank
	 */
	
	@ManyToOne
	@JoinColumn(name = "bankId" , nullable = false)
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
		return "Account [accountId=" + accountId + ", amount=" + amount + ", customer=" + customer + ", bank=" + bank
				+ "]";
	}
	
	
}
