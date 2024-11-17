package com.org.ms.registerService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.org.ms.registerService.bean.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	private String sql = "";
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createAccount(Account account) {
		entityManager.persist(account);
	}

	@Override
	public void deleteAccount(Account account) {
		entityManager.remove(account);
	}

	@Override
	public void editAccount(Account account) {
		entityManager.flush();
	}

	@Override
	public Account getAccountById(long accountId) {
		/*sql = "from Account a where a.accountid=?";*/
		return (Account) entityManager.find(Account.class,accountId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listofAccount() {
		System.out.println("calling Dao  listofAccount() >> ");
		sql = "from Account";
		return entityManager.createQuery(sql).getResultList();
	}

}
