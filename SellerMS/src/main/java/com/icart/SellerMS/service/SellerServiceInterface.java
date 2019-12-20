package com.icart.SellerMS.service;

import java.util.ArrayList;
import java.util.List;

import com.icart.SellerMS.bean.Seller;

public interface SellerServiceInterface {

	public String registerSeller(Seller seller) throws Exception;
	public List<String> getAllSellers() throws Exception;
	public void updateSeller(Seller seller) throws Exception;
	public String updatePassword(Seller seller) throws Exception;
	public Seller getSellerDetails(Seller seller) throws Exception;
	public Boolean authenticateLogin(Seller seller) throws Exception;
}
