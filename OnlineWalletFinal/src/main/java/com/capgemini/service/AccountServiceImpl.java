package com.capgemini.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.entities.Account;
import com.capgemini.entities.Login;
import com.capgemini.service.IAccountService;
import com.capgemini.daos.AccountDAO;

import com.capgemini.exception.ApplicationException;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

	@Autowired
	AccountDAO dao;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addAccount(Account a) {
	
		if (dao.existsById(a.getId()))
			throw new ApplicationException("Account already exists!!");
																	
		dao.save(a); // otherwise saving it in database

		System.out.println("Account added to the database");
		return 1;
	}


	public int loginAccount(Login user) {
		
		int userId=user.getUserId();
		String pass=user.getPass();
		
		if(dao.findByIdAndPass(userId, pass) != null)
		{
			return 1;
		}
		
		
		
		return 0;
	}

	

	

	
	
	
	


	
	
	
}
