package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;

import com.capgemini.service.WalletServiceImpl;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	
	@Autowired WalletServiceImpl walletService;
	
	
	//adding more money to wallet
	// user will enter his account id and required amount to be added
		@PostMapping(value = "/deposit", consumes = { "application/json" })
		public String deposit(@RequestBody Wallet input) {
			Wallet w = walletService.findAccount(input.getAccountId());
			double amount = input.getBalance();
			
			return walletService.deposite(w, amount);
		}
		

		// show wallet balance
		@GetMapping(value = "/profile/{id}")
		public Account userProfile(@PathVariable int id) {
			// to find a account by id
			Account a = walletService.userProfile(id);
			return a; 
		}

}
