package com.dnb.JDBCDemo.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.utils.DBUtils;

public class AccountRepositoryImpl implements AccountRepository {

	private AccountRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	private static AccountRepository accountRepository;
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		String createAccountStatement = "insert into account "+ "(accountId, accountHolderName, accountType, balance, contactNumber, address, accountCreateDate, dob, accountStatus)"+ " values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		if(connection.isPresent()) {
	
		try {
			preparedStatement = connection.get().prepareStatement(createAccountStatement);
			preparedStatement.setString(1, account.getAccountId());
			preparedStatement.setString(2, account.getAccountHolderName());
			preparedStatement.setString(3, account.getAccountType());
			preparedStatement.setFloat(4, account.getBalance());
			preparedStatement.setString(5, account.getContactNumber());
			preparedStatement.setString(6, account.getAddress());
			preparedStatement.setDate(7, Date.valueOf(account.getAccountCreateDate()));
			preparedStatement.setDate(8, Date.valueOf(account.getDob()));
			preparedStatement.setBoolean(9, account.isAccountStatus());
			
			int result = preparedStatement.executeUpdate();
			if(result > 0) {
				return account; //it should return the actual account object of OB
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(connection.isPresent()) {
				DBUtils.closeConnection(connection.get());
			}else {
				
			}
		}

		}
		
		return null;
	}
	
	public static AccountRepository getInstance() {
		// TODO Auto-generated method stub
		
		synchronized (AccountRepositoryImpl.class) {
			if(accountRepository==null) {
				accountRepository = new AccountRepositoryImpl();
			}
			
		}
		return accountRepository;

	}
	
	

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String query = "select * from account where accountId=?";
		if(connection.isPresent()) {
			try {
				preparedStatement = connection.get().prepareStatement(query);
				preparedStatement.setString(1, accountId);
				resultset = preparedStatement.executeQuery();
				if(resultset.next()) {
					Account account = new Account();
					account.setAccountId(resultset.getString("accountId"));
					account.setDob(resultset.getDate("dob").toLocalDate());
					return Optional.of(account);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return Optional.empty();
	}

	@Override
	public Optional<Account> deleteAccountById(String accountId) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String query = "delete from account where accountId=?";
		if(connection.isPresent()) {
				try {
					preparedStatement = connection.get().prepareStatement(query);
					preparedStatement.setString(1, accountId);
					//resultset = 
					preparedStatement.executeUpdate();
					//if(resultset.next()) {
						Account account = new Account();
						account.setAccountId(accountId);
						//(resultset.getString("accountId"));
						return Optional.ofNullable(account);
					//}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return null;
	}

	@Override
	public List<Account> getAllAccounts(String accountId) {
		// TODO Auto-generated method stub
		
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String query = "select * from account";
		List<Account> accounts = new ArrayList<>();
		if(connection.isPresent()) {
			try {
				preparedStatement = connection.get().prepareStatement(query);
				//preparedStatement.setString(1, accountId);
				resultset = preparedStatement.executeQuery();
				if(resultset.next()) {
					Account account = new Account();
					account.setAccountId(resultset.getString("accountId"));
					account.setDob(resultset.getDate("dob").toLocalDate());
					accounts.add(account);
					return accounts;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
