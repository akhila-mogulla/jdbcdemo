package com.dnb.JDBCDemo.repo;

import java.util.List;
import java.util.Optional;

import com.dnb.JDBCDemo.dto.Account;

public interface AccountRepository {
	
	public Account createAccount(Account account);
	
	public  Optional<Account> getAccountById(String accountId);
	
	public  Optional<Account> deleteAccountById(String accountId);
	
	public  List<Account> getAllAccounts(String accountId);

}
