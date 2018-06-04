package com.test.spring.SpringBootBank.pojo;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank 
{
	private long bankId;
	private String bankName;
	private BigDecimal amount;
	
	
	public Bank() 
	{
		
	}

	/**
	 * @param bankId
	 * @param bankName
	 * @param amount
	 */
	public Bank(long bankId, String bankName, BigDecimal amount) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.amount = amount;
		
	}

	/**
	 * @return the bankId
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bankId" , nullable = false)
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	@Column(name = "bankName")
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	 * @return the custList
	 */
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankPojo [bankId=" + bankId + ", bankName=" + bankName + ", amount=" + amount + "]";
	}
	
	

}
