package com.ibm.discountservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.discountservice.service.DiscountService;

@RestController
@RequestMapping("discount")
public class DiscountController {
	
	@Value("${msg}")
	private String message;
	
	private static final Logger logger= LoggerFactory.getLogger(DiscountController.class);
	@Autowired
	DiscountService discountService;
	
	@GetMapping("/{name}")
	public Double tax(@PathVariable(value="name") String name) {
		logger.info("tax service called for product name:"+name);
		System.out.println("tax service called for product name:"+name);
		return discountService.getDiscount(name);
	}
	
	@GetMapping("/message")
	public String message() {
		
		return this.message;
	}


}
