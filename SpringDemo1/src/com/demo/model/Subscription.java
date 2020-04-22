package com.demo.model;

public class Subscription {

	private Long id;
	
	private String plan; //BASIC, SILVER, GOLD

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", plan=" + plan + "]";
	}
	
	
	
}
