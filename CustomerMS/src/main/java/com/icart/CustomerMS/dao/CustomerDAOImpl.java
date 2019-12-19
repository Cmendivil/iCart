package com.icart.CustomerMS.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icart.CustomerMS.bean.CustomerBean;
import com.icart.CustomerMS.entity.CustomerEntity;

@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	EntityManager em;
	
	public CustomerBean getCustomerByEmail(String email) {
		CustomerBean cust = new CustomerBean();
		email = email.toLowerCase();
		CustomerEntity custEntity = em.find(CustomerEntity.class, email);
		if(custEntity != null) {
			cust.setEmailId(custEntity.getEmailId());
			cust.setName(custEntity.getName());
			cust.setPhoneNumber(custEntity.getPhoneNumber());
		}
		return cust;
	}
	
	public String registerCustomer(CustomerBean cust) {
		CustomerEntity customerEntity = new CustomerEntity();
		
		customerEntity.setEmailId(cust.getEmailId());
		customerEntity.setName(cust.getName());
		customerEntity.setPhoneNumber(cust.getPhoneNumber());
		customerEntity.setPassword(cust.getPassword());
		
		em.persist(customerEntity);
		
		return customerEntity.getEmailId();
	}
}
