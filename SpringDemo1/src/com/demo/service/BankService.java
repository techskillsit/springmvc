package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.model.Bank;
 
public class BankService {

	@Autowired
	private Bank bank;
	
	public Bank fetchBank() {
		
		bank.setId(1L);
		bank.setName("IDBI");
		
		return bank;
	}

	
}
