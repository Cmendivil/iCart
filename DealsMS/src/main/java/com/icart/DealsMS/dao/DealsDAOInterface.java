package com.icart.DealsMS.dao;

import java.util.List;

import com.icart.DealsMS.bean.Deals;

public interface DealsDAOInterface {

	public int addNewDeal(Deals deal) throws Exception;
	public List<Deals> getAllDeals(String emailId) throws Exception;
}
