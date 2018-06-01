package com.test.spring.SpringBootBank.exception;

public class BankException extends Exception
{
	private String message;

	/**
	 * @param message
	 */
	public BankException(String message) {
		super();
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankException [message=" + message + "]";
	}
	
	

}
