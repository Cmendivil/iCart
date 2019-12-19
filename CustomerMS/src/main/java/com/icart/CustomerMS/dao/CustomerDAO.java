package com.icart.CustomerMS.dao;

import com.icart.CustomerMS.bean.CustomerBean;

public interface CustomerDAO {
	public CustomerBean getCustomerByEmail(String email);
	public String registerCustomer(CustomerBean cust);
}
