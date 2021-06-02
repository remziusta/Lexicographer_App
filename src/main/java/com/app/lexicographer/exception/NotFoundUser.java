package com.app.lexicographer.exception;

public class NotFoundUser extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundUser(String message) {
		super(message);
	}
	
	
}
