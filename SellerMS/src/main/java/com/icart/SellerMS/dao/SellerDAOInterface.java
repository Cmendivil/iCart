package com.icart.SellerMS.dao;

import java.util.List;

import com.icart.SellerMS.bean.Seller;

public interface SellerDAOInterface {

	public String registerSeller(Seller seller) throws Exception;
	public List<Seller> getAllSellers() throws Exception;
}
