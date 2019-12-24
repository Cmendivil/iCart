package com.icart.SellerMS.bean;

import java.util.List;

public class Seller {
	
	
	private String name;
	private String password;
	private String phone;
	private String address;
	private String email_id;
	private List<Deals> deals;
	
	
	public List<Deals> getDeals() {
		return deals;
	}
	public void setDeals(List<Deals> deals) {
		this.deals = deals;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
