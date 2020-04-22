package com.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
 
public class Bank {

	private Long id;
	private String name;
	
	private List<Customer> cList; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getcList() {
		return cList;
	}

	public void setcLst(List<Customer> cList) {
		this.cList = cList;
	}
 

	 
	
	
}
