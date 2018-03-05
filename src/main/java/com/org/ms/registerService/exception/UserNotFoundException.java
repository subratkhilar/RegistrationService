package com.org.ms.registerService.exception;

/**
 * @author A669825
 *
 */
public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
