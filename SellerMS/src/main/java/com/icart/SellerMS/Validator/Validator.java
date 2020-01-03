package com.icart.SellerMS.Validator;

public class Validator {

	
	public boolean validateName(String name) {
		if(name.isEmpty()) {
			return false;
		}
		
		
		return true;
	}
}
