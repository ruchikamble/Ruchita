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
@Table(name = "ATM")
public class ATM 
{
	private long atmID;
	private BigDecimal amount;
	
	private Bank bank;
	
	public ATM() { }

	/**
	 * @param atmID
	 * @param amount
	 * @param money
	 * @param bank
	 */
	public ATM(long atmID, BigDecimal amount, Bank bank) {
		super();
		this.atmID = atmID;
		this.amount = amount;
		
		this.bank = bank;
	}

	/**
	 * @return the atmID
	 */
	
	@Column(name = "atmID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getAtmID() {
		return atmID;
	}

	/**
	 * @param atmID the atmID to set
	 */
	public void setAtmID(long atmID) {
		this.atmID = atmID;
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
		return "ATM [atmID=" + atmID + ", amount=" + amount + ", bank=" + bank + "]";
	}

	
}
