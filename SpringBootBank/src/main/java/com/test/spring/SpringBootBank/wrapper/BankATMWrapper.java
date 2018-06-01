package com.test.spring.SpringBootBank.wrapper;

import com.test.spring.SpringBootBank.pojo.ATM;

public class BankATMWrapper 
{
	private ATM atm;
	private long bankId;
	
	public BankATMWrapper() { }

	/**
	 * @param atm
	 * @param bank
	 */
	public BankATMWrapper(ATM atm, long bankId) {
		super();
		this.atm = atm;
		this.bankId = bankId;
	}

	/**
	 * @return the atm
	 */
	public ATM getAtm() {
		return atm;
	}

	/**
	 * @param atm the atm to set
	 */
	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	/**
	 * @return the bank
	 */
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankATMWrapper [atm=" + atm + ", bank=" + bankId + "]";
	}
	
	
}
