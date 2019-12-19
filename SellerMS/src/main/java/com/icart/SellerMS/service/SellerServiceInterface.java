package com.icart.SellerMS.service;

import java.util.ArrayList;
import java.util.List;

import com.icart.SellerMS.bean.Seller;

public interface SellerServiceInterface {

	public String registerSeller(Seller seller) throws Exception;
	public List<Seller> getAllSellers() throws Exception;
}
