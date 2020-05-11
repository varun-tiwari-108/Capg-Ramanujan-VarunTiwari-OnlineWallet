package com.capgemini.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.service.AccountServiceImpl;


import com.capgemini.entities.Account;
import com.capgemini.entities.Login;
import com.capgemini.entities.User;
import com.capgemini.entities.Wallet;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired AccountServiceImpl accountService;


	@PostMapping(value = "/register", consumes = { "application/json" })
	public int addAccount(@RequestBody User user) {
		
		Account account = new Account(user.getUsername(),user.getPass(),user.getPhone(), new Wallet(1000.0));
		return accountService.addAccount(account);
		
	}
	
	@PostMapping(value = "/login", consumes = { "application/json" })
	public int loginAccount(@RequestBody Login user)
	{
		return accountService.loginAccount(user);
	}

		
	
	
}
