package com.ibm.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.orderservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductName(String name);
}
