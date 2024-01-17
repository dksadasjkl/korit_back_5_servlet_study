package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.study.servlet_study.entity.Account;

public class AccountRepository {
	private static AccountRepository instance;
	private List<Account> accountList;
	
	private AccountRepository() {
		accountList = new ArrayList<>();
	}
	
	public static AccountRepository getInstance() {
		if (instance == null) {
			instance = new AccountRepository();
		} 
		return instance;
	}
	
	public int saveAccount(Account accont) {
		accountList.add(accont);
		return 1;
	}
	
	public Account findAccountByUsername(String username) {
		Account findAccount = null;
		
		for (Account accont : accountList) {
			if(accont.getUsername().equals(username)) {
				findAccount = accont;
				break;
			}			
		}
		return findAccount;
	}

}
