package com.ibm.discountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.discountservice.entity.Discount;
import com.ibm.discountservice.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	DiscountRepository discountRepository;
	
	public Double getDiscount(String name) {
		Double discount = 0.0;
		
		Discount discountProd = discountRepository.findByName(name);
		
		if(null != discountProd) {
			discount = discountProd.getDiscount();
		}
		return discount;
		
	}



}
