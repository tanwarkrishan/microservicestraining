package com.ibm.discountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.discountservice.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{
	
	Discount findByName(String name);

}
