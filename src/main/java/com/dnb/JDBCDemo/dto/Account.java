package com.dnb.JDBCDemo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Account {
	private String accountId;
	private String accountHolderName;
	private String accountType;
	private float balance;
	private String contactNumber;
	private String address;
	private LocalDate accountCreateDate = LocalDate.now();
	private LocalDate dob;
	private boolean accountStatus;
	
	
	

}
