package com.org.ms.registerService.dao;

import java.util.List;

import com.org.ms.registerService.bean.Account;

public interface AccountDao {
	public void createAccount(Account account);

	public void deleteAccount(Account account);

	public void editAccount(Account account);

	public Account getAccountById(long accountId);

	public List<Account> listofAccount();
}
