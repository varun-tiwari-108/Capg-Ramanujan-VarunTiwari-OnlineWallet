package com.capgemini.service;

import com.capgemini.entities.Account;
import com.capgemini.entities.Login;


public  interface IAccountService {
		public int addAccount(Account a);
		public int loginAccount(Login user);
	
	
}
