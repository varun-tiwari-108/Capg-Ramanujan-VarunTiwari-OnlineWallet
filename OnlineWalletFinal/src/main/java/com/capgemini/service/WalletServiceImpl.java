package com.capgemini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.daos.AccountDAO;
import com.capgemini.daos.TransactionDAO;
import com.capgemini.daos.WalletDAO;
import com.capgemini.entities.Account;
import com.capgemini.entities.Wallet;
import com.capgemini.exception.ApplicationException;


@Service
@Transactional
public class WalletServiceImpl implements IWalletService{
	
	@Autowired
	AccountDAO dao;
	@Autowired
	WalletDAO walletDao;
	@Autowired
	TransactionDAO transactionDao;
	
	@Override
	public Account userProfile(int userId) {

		Account a = dao.findById(userId).orElse(new Account());
		
		if(a.getId() == 0) {
			throw new ApplicationException("Account not found!");
			
		}
		else {
			System.out.println(a.getWallet().getBalance()+" =================== ");
			return a;
		}

	}
	
	
	//adding money in wallet
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deposite(Wallet w, double amount) {

		if (amount >= 0) {
			double new_balance = w.getBalance() + amount;			
			updateBalance(w.getAccountId(),new_balance);
			System.out.println("deposite");
			return "Balance added Successfully";
		}

		return "Amount cannot be negative";
	}
	
	
	//updating the balance in the wallet
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(int accId, double amount) {

		Wallet w;
		Optional<Wallet> p = walletDao.findById(accId);
		if (p.isPresent())
			w = p.get();
		else
			throw new ApplicationException("Account not found!"); 

		w.setBalance(amount);
	}
	@Override
	@Transactional(readOnly = true)
	public Wallet findAccount(int accId) {

		Optional<Wallet> a = walletDao.findById(accId);
		if (a.isPresent()) 
			return a.get();
		else
			throw new ApplicationException("AccountId  not found!"); // throwing custom exception if account doesn't exist
		
	}


}
