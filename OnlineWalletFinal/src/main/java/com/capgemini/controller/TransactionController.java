package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Transaction;

import com.capgemini.service.TransactionServiceImpl;


@RestController
@RequestMapping("/transaction")

public class TransactionController {

	

	@Autowired TransactionServiceImpl transactionService;
	
	//transfer fund from one account to another
		@PostMapping(value = "/transfer", consumes = { "application/json" })
		public String transferMoney(@RequestBody Transaction t) {
			
			return transactionService.TransferAmount(t);
		}
	//list transaction history	
		@GetMapping(value = "/history/{senderId}")
		public List<Transaction> transactionHistory(@PathVariable int senderId) {
			// to find a account by id
			List<Transaction> history = transactionService.transactionHistory(senderId);
			return history; 
		}
}
