package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.Customer;
import com.demo.model.Subscription;

public class CustomerService {
//fetch info from DB and pass on to controller 
	//if needed, process the logic.. 
	
	private List<Customer> list;
	 
	private void populateCutomers(){
		list = new ArrayList<>();
		Customer c1 = new Customer(1,"John Doe", "Kingston Street");
		Customer c2 = new Customer(2,"Jane Doe", "Harlington Street");
		Customer c3 = new Customer(3,"Vijay Chauhan", "Some island");
		
		Subscription s1 = new Subscription();
		s1.setId(1L);
		s1.setPlan("BASIC");
		c1.setSubscription(s1);
		c2.setSubscription(s1);
		c3.setSubscription(s1);
		
		list.add(c1);
		list.add(c2);
		list.add(c3); //{ 3000X, 4000X, 5000X }
	}

	public List<Customer> fetchCustomers() {
		populateCutomers();
		return this.list;
	}
	
	
}
