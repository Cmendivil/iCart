package com.icart.CustomerMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icart.CustomerMS.bean.CustomerBean;
import com.icart.CustomerMS.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("CustomerAPI")
public class CustomerAPI {
	@Autowired
	CustomerService customerServiceImpl;
	
	@GetMapping(value="customer/{emailId:.+}")
	public ResponseEntity<CustomerBean> getCustomerByEmail(@PathVariable("emailId") String emailID){
		CustomerBean cust = customerServiceImpl.getCustomerByEmail(emailID);
		return new ResponseEntity<CustomerBean>(cust, HttpStatus.OK);
	}
	
	@PostMapping(value="customer/register")
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerBean cust) {
		String email = customerServiceImpl.registerCustomer(cust);
		return new ResponseEntity<String>(email, HttpStatus.OK);
	}
	
}
