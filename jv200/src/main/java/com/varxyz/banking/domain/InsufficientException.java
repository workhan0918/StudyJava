package com.varxyz.banking.domain;

public class InsufficientException extends RuntimeException {
	public InsufficientException(String msg) {
		super(msg);
	}
}
