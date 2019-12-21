package com.icart.DealsMS.service;

import java.util.List;

import com.icart.DealsMS.bean.Deals;

public interface DealsServiceInterface {

	public int addNewDeal(Deals deal) throws Exception;
	public List<Deals> getAllDeals(String emailId) throws Exception;
}
