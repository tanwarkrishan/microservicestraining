package com.ibm.productService.mapper;

import com.ibm.productService.dto.ProductDTO;
import com.ibm.productService.entity.Product;

public class ProductMapper {

	public Product convertToEntity(ProductDTO dto) {
		
		Product entity = new Product();
		entity.setProductName(dto.getProductName());
		entity.setQuantity(dto.getQuantity());
		
		return entity;
	}
	
	public ProductDTO convertToDto(Product product) {
		ProductDTO productDto = new ProductDTO();
		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		productDto.setQuantity(product.getQuantity());
		
		return productDto;
	}
}
