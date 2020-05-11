package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Transaction;
import com.capgemini.entities.Wallet;

public interface ITransactionService 
{
	public Wallet findAccount(int accId);
	public String TransferAmount(Transaction t);
	public void updateBalance(int accId, double amount);
	public List<Transaction> transactionHistory(int senderId) ;
}
