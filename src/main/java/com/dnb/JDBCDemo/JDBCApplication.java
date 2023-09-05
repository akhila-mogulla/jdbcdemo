package com.dnb.JDBCDemo;

import java.time.LocalDate;
import java.util.Scanner;

import com.dnb.JDBCDemo.dto.Account;
import com.dnb.JDBCDemo.service.AccountServiceImpl;

//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.Optional;

public class JDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String a ="Akhi";
		String b = null;
		Optional<String> opt = Optional.ofNullable(b);
		System.out.println(opt.isEmpty());
		
		//localDate to java.sql.date
		
		java.sql.Date date = Date.valueOf(LocalDate.now());
		System.out.println(date);*/
		
		Account account = new Account();
		/*account.setAccountHolderName("Akhila");
		account.setAccountId("13");
		account.setAccountType("Savings");
		account.setBalance(100000);
		account.setAccountStatus(true);
		account.setAddress("hyderabad");
		account.setContactNumber("98763554423");
		LocalDate ld = LocalDate.of( 2026 , 1 , 23 );
		account.setDob(ld );*/
		
		//AccountServiceImpl.getInstance().createAccount(account);
		//asi = new AccountServiceImpl();
		//System.out.println(asi.createAccount(account));
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("operations\n 1.create account \n 2.get account\n 3.delete the account.\n 4.Exit from code\n Enter any option: ");
			int condition=sc.nextInt();
		switch (condition) {
		case 1:AccountServiceImpl.getInstance().createAccount(account);
				System.out.println("created account");
			break;
		case 2:AccountServiceImpl.getInstance().getAccountById("12");
				System.out.println("you got the connection");
				break;
		case 3:AccountServiceImpl.getInstance().deleteAccountById("12");
				System.out.println("deleted successfully");
				break;
		case 4:System.out.println("thanks! you got exit...");
			System.exit(0);
		
		break;

		default: System.out.println("enter the proper value");
			break;
		}
		
		}
		
		
		
	}

}
