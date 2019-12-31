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
import org.springframework.web.client.RestTemplate;

import com.icart.SellerMS.bean.Deals;
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
			LOGGER.info("USER TRYING TO REGISTER AS A SELLER WITH EMAIL ID " + seller.getEmail_id());
			String emailId = sellerService.registerSeller(seller);
			responseEntity = new ResponseEntity<String>(emailId, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseEntity;
	}
	
	@GetMapping(value="allSellers")
	public ResponseEntity<List<String>> getAllSellers() throws Exception{
		ResponseEntity <List<String>> responseEntity = null;
		try {
			List<String> sellerList = sellerService.getAllSellers();
			responseEntity = new ResponseEntity(sellerList, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@PostMapping(value="updateSeller")
	public ResponseEntity<String> updateSeller(@RequestBody Seller seller){
		ResponseEntity<String> responseEntity = null;
		String msg = null;
		try {
			sellerService.updateSeller(seller);
			msg="SUCCESS";
			responseEntity = new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	
	@PostMapping(value="updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Seller seller){
		String msg = null;
		ResponseEntity<String> responseEntity = null;
		try {
			msg = sellerService.updatePassword(seller);
			responseEntity = new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@GetMapping(value="sellerDetails")
	public ResponseEntity<Seller> getSellerDetails(@RequestBody Seller seller){
		ResponseEntity<Seller> responseEntity = null;
		try {
			Seller sellerInfo = sellerService.getSellerDetails(seller);
			responseEntity = new ResponseEntity<Seller>(sellerInfo, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseEntity;
	}
	
	@GetMapping(value="sellerLogin")
	public ResponseEntity<Boolean> authenticateLogin(@RequestBody Seller seller){
		Boolean b = false;
		ResponseEntity<Boolean> responseEntity = null;
		try {
			b = sellerService.authenticateLogin(seller);
			responseEntity = new ResponseEntity<Boolean>(b, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@GetMapping(value="deals")
	public Deals[] getSellerDeals(@RequestBody Seller seller){
		ResponseEntity<Deals []> responseEntity = new RestTemplate().getForEntity("http://localhost:8081/DealsAPI/deals/"+seller.getEmail_id(), Deals[].class);
		Deals[] deals = responseEntity.getBody(); 
		System.out.println(deals);
		return deals;
	}
	
	
}
