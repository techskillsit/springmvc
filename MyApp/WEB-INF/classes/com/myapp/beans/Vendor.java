package com.myapp.beans;

import org.springframework.stereotype.Component;

@Component
public class Vendor {
	private String name;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", city=" + city + "]";
	}

	
}
