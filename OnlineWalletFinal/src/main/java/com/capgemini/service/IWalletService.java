package com.capgemini.service;

import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;

public interface IWalletService {
	
	
	public String deposite(Wallet w, double amount);
	public void updateBalance(int accId, double amount);
	public Wallet findAccount(int accId);
	public Account userProfile(int userId);

}
