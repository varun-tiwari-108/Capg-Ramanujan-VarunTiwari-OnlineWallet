package com.capgemini.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
	public Account findByIdAndPass(int userId,String pass);

}
