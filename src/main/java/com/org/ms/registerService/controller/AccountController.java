package com.org.ms.registerService.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.ms.registerService.bean.Account;
import com.org.ms.registerService.exception.AccountNotFoundException;
import com.org.ms.registerService.service.AccountService;

@RestController
@Transactional
public class AccountController {
	private Logger logger = Logger.getLogger(AccountController.class);
	@Autowired
	private AccountService accountService;
	private String message = "";

	@RequestMapping(value = "/createAccounts", method = RequestMethod.POST)
	public ResponseEntity<String> createAccount(@RequestBody Account account) {
		try {
			accountService.createAccount(account);
			message = "Account created sucessfully";
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAcc/{accountId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccount(@PathVariable("accountId") long accountId) {
		Account account = accountService.getAccountById(accountId);
		if (account == null || account.equals("")) {
			message = "Account Id " + accountId + "not exist";
			throw new AccountNotFoundException(message);
		}
		message = "Account Id " + accountId + "Deleted sucessfully!";
		accountService.deleteAccount(account);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/listOfAllAcc", method = RequestMethod.GET,produces="application/json")
	public List<Account> getAllAccoutList() {
		return accountService.listofAccount();
	}

	@RequestMapping(value = "/editAccDetails", method = RequestMethod.PUT)
	public ResponseEntity<String> editAccountDetails(@RequestBody Account account) {
		try {
			accountService.editAccount(account);
			message = "Account updated sucessfully!!";
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAccdetailsById/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable("accountId") long accountId) {
		Account account = accountService.getAccountById(accountId);
		if (account == null || account.equals("")) {
			message = "Account Id " + accountId + "not exist";
			throw new AccountNotFoundException(message);
		}
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
}
