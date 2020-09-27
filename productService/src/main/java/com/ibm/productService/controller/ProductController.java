package com.ibm.productService.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.productService.dto.ProductDTO;
import com.ibm.productService.entity.Product;
import com.ibm.productService.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Value("${msg}")
	private String message;
	
	@GetMapping("/product/msg")
	public String message() {
		return "Welcome to Spring Boot";
	}

	@ApiOperation("Product is created")
	@PostMapping("/")
	public ResponseEntity<Product> products(@RequestBody ProductDTO productDTO) {
		
		return ResponseEntity.ok().body(productService.createProduct(productDTO));
	}
	
	@GetMapping("/")//localhost:8080/product?id=1
	public ResponseEntity<ProductDTO> products(@RequestParam(value = "id") Long id) {
		
		Optional<ProductDTO> product = Optional.ofNullable(productService.getProduct(id));
		
		if(product.isPresent()) {
			return ResponseEntity.ok().body(product.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
			
	}
	
	@ApiOperation("Product is searched")
	@GetMapping("/{id}")//localhost:8080/product/1
	public ResponseEntity<ProductDTO> product(@PathVariable(value = "id") Long id) {
		
		Optional<ProductDTO> productDto = Optional.ofNullable(productService.getProduct(id));
		
		if(productDto.isPresent()) {
			return ResponseEntity.ok().body(productDto.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ApiOperation(" This will search product for given product name in request param")
	@GetMapping("/name/{name}") //localhost:8080/product?id=1
	public ResponseEntity<ProductDTO> product(@PathVariable(value="name") String name){
		
		Optional<ProductDTO> product=Optional.ofNullable(productService.byName(name));
		 
		if(product.isPresent()) {
			
			return ResponseEntity.ok().body(product.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> pproduct(@PathVariable(value = "id") Long productid){
		
		int response = productService.deleteProduct(productid);
		if(1 == response) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@GetMapping("/message")
	public String message2() {
		
		return this.message;
	}
	
	
}
