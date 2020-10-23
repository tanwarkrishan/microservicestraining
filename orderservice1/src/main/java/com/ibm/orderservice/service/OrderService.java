package com.ibm.orderservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ibm.orderservice.model.OrderDetail;
import com.ibm.orderservice.model.Product;
import com.ibm.orderservice.repository.OrderRepository;
import com.ibm.orderservice.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
		
	}
	
	public OrderDetail generateOrder(String authorization, Long id) {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", authorization);
	    
	    Product product = null;
	    OrderDetail created = new OrderDetail();
	    Optional<Product> generatedOrder = productRepo.findById(id);
	    if(generatedOrder.isPresent()) {
	    	product = generatedOrder.get();
			created.setToken(authorization);
			created.setProductName(product.getProductName());
	    	orderRepo.save(created);
	    }
	    return created;
	}
	
}
