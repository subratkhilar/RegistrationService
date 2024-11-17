package com.org.ms.registerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.ms.registerService.bean.Account;
import com.org.ms.registerService.dao.AccountDao;
@Service("accountService")
@CacheConfig(cacheNames = "accounts")
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
	@Cacheable()
	public List<Account> listofAccount() {
		System.out.println("calling service listofAccount() >> ");
		return accountDao.listofAccount();
	}

}
