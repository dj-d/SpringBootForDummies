package com.mc.mcdonald.exceptions.customs;

public class ElementNotFoundException extends RuntimeException {
	public ElementNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
