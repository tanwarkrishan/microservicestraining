package com.ibm.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.orderservice.model.OrderDetail;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Long>{
	
}
