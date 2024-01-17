package com.study.servlet_study.service;

import com.study.servlet_study.entity.Account;
import com.study.servlet_study.repository.AccountRepository;

public class AccountService {
	
	private static AccountService instance;
	private AccountRepository accountRepository;
	
	private AccountService() {
		accountRepository = AccountRepository.getInstance();
	}

	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
		
	}

	public int addAccount(Account accoont) {
		return accountRepository.saveAccount(accoont); //1
	}
	
	public Account getAccount(String username) {
		return accountRepository.findAccountByUsername(username);
	}

}
