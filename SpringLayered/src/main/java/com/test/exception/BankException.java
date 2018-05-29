package com.test.exception;

public class BankException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7828214587686013573L;
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
