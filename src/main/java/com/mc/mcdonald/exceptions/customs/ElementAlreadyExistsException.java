package com.mc.mcdonald.exceptions.customs;

public class ElementAlreadyExistsException extends RuntimeException {
	public ElementAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
}
