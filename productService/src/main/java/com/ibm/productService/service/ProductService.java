package com.ibm.productService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.productService.dto.ProductDTO;
import com.ibm.productService.entity.Product;
import com.ibm.productService.mapper.ProductMapper;
import com.ibm.productService.repository.ProductRepository;
import com.ibm.productService.restClient.DiscountClient;
import com.ibm.productService.restClient.TaxClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	final TaxClient taxClient;
	final DiscountClient discountClient;
	
	@Autowired
	public ProductService(TaxClient taxClient, DiscountClient discountClient) {
		this.taxClient = taxClient;
		this.discountClient = discountClient;
	}
	
	public Product createProduct(ProductDTO dto) {
		
		ProductMapper mapper=new ProductMapper();
		Product produt=mapper.convertToEntity(dto);
		return productRepository.save(produt);
		
	}
	
	@HystrixCommand(fallbackMethod = "taxServiceFallback")
	public ProductDTO getProduct(Long id) {
	  Optional<Product> product = productRepository.findById(id);
	  ProductMapper mapper = new ProductMapper();
	  ProductDTO dto =  mapper.convertToDto(product.get());
	  Double tax = taxClient.tax(dto.getProductName());
	  dto.setTax(tax);
	  return dto;
	}
	
	public ProductDTO taxServiceFallback(Long id) {
		
		Optional<Product> product = productRepository.findById(id);
		ProductDTO productDto = null;
		if(product.isPresent()) {
			ProductMapper mapper = new ProductMapper();
			  productDto =  mapper.convertToDto(product.get());
			  productDto.setTax(8.0);
		}
		return productDto;
	}
	
	@HystrixCommand(fallbackMethod = "discountServiceFallback")
	public ProductDTO byName(String name) {
		
		 Product product =	productRepository.findByProductName(name);
		 ProductMapper mapper = new ProductMapper();
			ProductDTO dto = mapper.convertToDto(product);
			Double discount = discountClient.discount(dto.getProductName());
			dto.setDiscount(discount);
			
			return dto;
	}

	public ProductDTO discountServiceFallback(String name) {
		
		Product product = productRepository.findByProductName(name);
		ProductDTO productDto = null;
		//if(product.isPresent()) {
			ProductMapper mapper = new ProductMapper();
			  productDto =  mapper.convertToDto(product);
			  productDto.setDiscount(3.0);
		//}
		return productDto;
	}
	
	public int deleteProduct(Long id) {
		int response = 0;
		Optional<Product> entity = productRepository.findById(id);
		if(entity.isPresent()) {
			productRepository.deleteById(id);
			response = 1;
		} else {
			response = 0;
		}
		return response;
		
	}

}