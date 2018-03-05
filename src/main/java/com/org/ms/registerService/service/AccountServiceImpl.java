package com.org.ms.registerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ms.registerService.bean.Account;
import com.org.ms.registerService.dao.AccountDao;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public void createAccount(Account account) {
		accountDao.createAccount(account);

	}

	@Override
	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);

	}

	@Override
	public void editAccount(Account account) {
		accountDao.editAccount(account);
	}

	@Override
	public Account getAccountById(long accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public List<Account> listofAccount() {
		return accountDao.listofAccount();
	}

}
