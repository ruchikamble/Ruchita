package com.test.spring.SpringBootBank.wrapper;

import com.test.spring.SpringBootBank.pojo.Account;

public class AccountBankCustWrapper 
{
	private Account account;
	private long bankId;
	private long customerId;
	
	public AccountBankCustWrapper() { }

	/**
	 * @param account
	 * @param bankId
	 * @param customerId
	 */
	public AccountBankCustWrapper(Account account, long bankId, long customerId) {
		super();
		this.account = account;
		this.bankId = bankId;
		this.customerId = customerId;
	}

	/**
	 * @return the account
	 */
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
	 * @return the bankId
	 */
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
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountBankCustWrapper [account=" + account + ", bankId=" + bankId + ", customerId=" + customerId + "]";
	}
	
	
}
