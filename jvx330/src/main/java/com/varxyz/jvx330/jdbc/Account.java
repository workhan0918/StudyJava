package com.varxyz.jvx330.jdbc;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accountType;
	private double balance;
	private Date regDate;
}
