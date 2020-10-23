package com.ibm.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderservice.model.OrderDetail;
import com.ibm.orderservice.model.Product;
import com.ibm.orderservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/product")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		Product prod =  orderService.createProduct(product);
		return ResponseEntity.ok().body(prod);
	}
	
	@GetMapping("/order")
	public ResponseEntity<?> createOrder(@RequestHeader("Authorization") String authorization, @RequestParam(value = "id") Long id){
		OrderDetail createdOrder = orderService.generateOrder(authorization, id);
		
		return ResponseEntity.ok().body(createdOrder);
	}
}
