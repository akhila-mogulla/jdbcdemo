package com.dnb.JDBCDemo.service;

import java.util.Optional;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.repo.AccountRepository;
import com.dnb.JDBCDemo.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {
	private static AccountService accountService = null;
	
	private Account AccountServiceImpl(Account account) {
		// TODO Auto-generated constructor stub
		return account;
	}

	public static AccountService getInstance() {
		// TODO Auto-generated method stub
		
		synchronized (AccountRepositoryImpl.class) {
			if(accountService==null) {
				accountService = new AccountServiceImpl();
			}
			
		}
		return accountService;

	}
	AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		//AccountRepositoryImpl.getInstance().createAccount(account);
		//accountService = (AccountService) AccountRepositoryImpl.getInstance().createAccount(account);
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.createAccount(account);
		
		//return account;
		
	}
	


	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		//AccountRepository accountRepository = AccountRepositoryImpl.getInstance();
		return accountRepository.getAccountById(accountId);
		//return null;
	}

	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		//return null;
		return accountRepository.deleteAccountById(accountId);
	}

}
