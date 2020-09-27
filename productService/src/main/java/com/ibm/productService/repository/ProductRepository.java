package com.ibm.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.productService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductName(String name);
}
