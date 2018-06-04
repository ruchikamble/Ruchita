package com.test.spring.SpringBootBank.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction 
{
	private long transactionId;
	private Customer customer;
	private Account account;
	private BigDecimal amount;
	private String transactionType;
	
	public Transaction() { }

	/**
	 * @param transactionId
	 * @param customer
	 * @param account
	 * @param amount
	 * @param transactionType
	 */
	public Transaction(long transactionId, Customer customer, Account account, BigDecimal amount, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.account = account;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	/**
	 * @return the transactionId
	 */
	
	@Column(name = "transactionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the customer
	 */
	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
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
	 * @return the account
	 */
	
	@ManyToOne
	@JoinColumn(name = "bankId", nullable = false)
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the amount
	 */
	@Column(name = "amount")
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionType
	 */
	@Column(name = "transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", account=" + account
				+ ", amount=" + amount + ", transactionType=" + transactionType + "]";
	}
	
	
}
