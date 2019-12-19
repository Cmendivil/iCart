package com.icart.SellerMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icart.SellerMS.bean.Seller;
import com.icart.SellerMS.service.SellerService;

@RestController
@CrossOrigin
@RequestMapping(name="SellerAPI")
public class SellerAPI {

	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private Environment env;
	
	static Logger LOGGER = LogManager.getLogger(SellerAPI.class.getName());
	
	
	@PostMapping(value="registerSeller")
	public ResponseEntity<String> registerSeller(@RequestBody Seller seller) throws Exception{
		ResponseEntity<String> responseEntity = null;
		try {
			String emailId = sellerService.registerSeller(seller);
			responseEntity = new ResponseEntity<String>(emailId, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseEntity;
	}
	
	@GetMapping(value="allSellers")
	public ResponseEntity<List<Seller>> getAllSellers() throws Exception{
		ResponseEntity <List<Seller>> responseEntity = null;
		try {
			List<Seller> sellerList = sellerService.getAllSellers();
			responseEntity = new ResponseEntity(sellerList, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
}
