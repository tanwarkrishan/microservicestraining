package com.ibm.productService.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="discount-service")
public interface DiscountClient {
	
	@GetMapping("/discount/{name}")
	public Double discount(@PathVariable(value = "name") String name);

}
