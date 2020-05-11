package com.capgemini.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "wallettransaction")
public class Transaction implements Serializable  {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int traId;
	@Column
	private int senderAccId;
	@Column
	private int receiverAccId;
	@Column
	private double amount;
	@Column
	private String time;
	
	
	public Transaction() {
		super();
	}


	public Transaction( int senderAccId, int receiverAccId, double amount, String time) {
		super();
		this.senderAccId = senderAccId;
		this.receiverAccId = receiverAccId;
		this.amount = amount;
		this.time = time;
	}


	public int getTraId() {
		return traId;
	}


	public void setTraId(int traId) {
		this.traId = traId;
	}


	public int getSenderAccId() {
		return senderAccId;
	}


	public void setSenderAccId(int senderAccId) {
		this.senderAccId = senderAccId;
	}


	public int getReceiverAccId() {
		return receiverAccId;
	}


	public void setReceiverAccId(int receiverAccId) {
		this.receiverAccId = receiverAccId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
}
