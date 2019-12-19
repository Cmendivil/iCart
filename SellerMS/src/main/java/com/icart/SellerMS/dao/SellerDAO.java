package com.icart.SellerMS.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.icart.SellerMS.bean.Seller;
import com.icart.SellerMS.entity.SellerEntity;

@Repository
@Transactional
public class SellerDAO implements SellerDAOInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public String registerSeller(Seller seller) {

		SellerEntity sellerEntity = new SellerEntity();
		
		sellerEntity.setAddress(seller.getAddress());
		sellerEntity.setEmail_id(seller.getEmail_id());
		sellerEntity.setName(seller.getName());
		sellerEntity.setPassword(seller.getPassword());
		sellerEntity.setPhone(seller.getPhone());
		
		entityManager.persist(sellerEntity);
		
		return sellerEntity.getEmail_id();
	}

	@Override
	public List<Seller> getAllSellers() throws Exception {
		
		List<SellerEntity> sellerEntityList;
		List<Seller> sellersList = new ArrayList<Seller>();
		
		Query query = entityManager.createQuery("select s from SellerEntity s");
		
		sellerEntityList = query.getResultList();
		
		sellerEntityList.forEach(sellerEntity -> {
			Seller seller = new Seller();
			seller.setEmail_id(sellerEntity.getEmail_id());
			seller.setName(sellerEntity.getName());
			seller.setPassword(sellerEntity.getPassword());
			seller.setPhone(sellerEntity.getPhone());
			seller.setAddress(sellerEntity.getAddress());
			sellersList.add(seller);
		});
	
		return sellersList;
	}

}
