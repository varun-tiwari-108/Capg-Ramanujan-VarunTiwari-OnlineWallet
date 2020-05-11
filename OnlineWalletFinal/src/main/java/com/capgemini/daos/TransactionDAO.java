package com.capgemini.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Transaction;


@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
	List<Transaction> findBySenderAccId(int senderAccId);

}