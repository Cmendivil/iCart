package com.icart.CustomerMS.service;

import com.icart.CustomerMS.bean.CustomerBean;

public interface CustomerService {
	public CustomerBean getCustomerByEmail(String email);
	public String registerCustomer(CustomerBean cust);
}
