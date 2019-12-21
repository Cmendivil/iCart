package com.icart.DealsMS.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icart.DealsMS.bean.Deals;
import com.icart.DealsMS.dao.DealsDAO;

@Service
@Transactional
public class DealsService implements DealsServiceInterface {

	@Autowired
	DealsDAO dealsDAO;
	
	@Override
	public int addNewDeal(Deals deal) throws Exception {
		return dealsDAO.addNewDeal(deal);
	}

	@Override
	public List<Deals> getAllDeals(String emailId) throws Exception {
		return dealsDAO.getAllDeals(emailId);
	}

}
