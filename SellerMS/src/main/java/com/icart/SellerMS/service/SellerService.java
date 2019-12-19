package com.icart.SellerMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icart.SellerMS.bean.Seller;
import com.icart.SellerMS.dao.SellerDAO;

@Service
public class SellerService implements SellerServiceInterface {

	@Autowired
	SellerDAO sellerDAO;
	
	
	@Override
	public String registerSeller(Seller seller) {
		return sellerDAO.registerSeller(seller);
	}


	@Override
	public List<Seller> getAllSellers() throws Exception {
		List<Seller> list = new ArrayList<Seller>();
		list = sellerDAO.getAllSellers();
		return list;
	}

	
}
