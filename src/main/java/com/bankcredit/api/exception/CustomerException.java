package com.bankcredit.api.exception;

/**
 * Clase de manejo de las excepciones 
 *
 */
public class CustomerException extends Throwable {

	private static final long serialVersionUID = -4937992390538976767L;

	public CustomerException(final String message) {
		super(message);
	} 
	
	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}
}
