package com.dnb.JDBCDemo.service;

import java.util.Optional;

import com.dnb.JDBCDemo.dto.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Optional<Account> getAccountById(String accountId);
	
	public  Optional<Account> deleteAccountById(String accountId);

}
