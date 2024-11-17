package com.org.ms.registerService.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.org.ms.registerService.bean.Account;
import com.org.ms.registerService.dao.AccountDao;
//Account service test
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	@Mock
	private AccountDao accountDao;
	@InjectMocks
	private AccountService accService = new AccountServiceImpl();
	Account account = new Account();
	@Before
	public void beforeTest() {
		account.setAccountid(23456789);
		account.setAccountHolderName("harish");
		account.setAddress("NPL");
	}

	@Test
	public void testCreateAccount() {
		accService.createAccount(account);
		doNothing().when(accountDao).createAccount(account);
	}

	@Test
	public void testDeleteAccount() {
		
		accService.deleteAccount(account);
		doNothing().when(accountDao).deleteAccount(account);
	}

	@Test
	public void testEditAccount() {
		accService.editAccount(account);
		doNothing().when(accountDao).editAccount(account);
	}
//getAccountbId
	@Test
	public void testGetAccountById() {
		when(accountDao.getAccountById(account.getAccountid())).thenReturn(account);
		Account result = accService.getAccountById(account.getAccountid());
		assertEquals(account, result);
	}

	@Test
	public void testListofAccount() {
		List<Account> list = new ArrayList<>();
		list.add(account);
		when(accountDao.listofAccount()).thenReturn(list);
		List<Account> results = accService.listofAccount();
		assertEquals(list, results);
		
	}

}
