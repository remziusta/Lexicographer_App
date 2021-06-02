package com.app.lexicographer.exception;

public class NotFoundWordList extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundWordList(String message) {
		super(message);
	}

}
