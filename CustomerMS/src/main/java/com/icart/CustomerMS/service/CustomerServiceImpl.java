package com.icart.CustomerMS.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icart.CustomerMS.bean.CustomerBean;
import com.icart.CustomerMS.dao.CustomerDAO;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDAO customerDAOImpl;
	public CustomerBean getCustomerByEmail(String email) {
		return customerDAOImpl.getCustomerByEmail(email);
	}
	
	public String registerCustomer(CustomerBean cust) {
		System.out.println(cust.getEmailId());
		cust.setEmailId(cust.getEmailId().toLowerCase());
		return customerDAOImpl.registerCustomer(cust);
	}

}
