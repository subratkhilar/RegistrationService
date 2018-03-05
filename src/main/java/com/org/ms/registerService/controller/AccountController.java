package com.org.ms.registerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.ms.registerService.bean.Account;
import com.org.ms.registerService.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<String> createAccount(@RequestBody Account account) {
		return null;
	}
}
