package com.ibm.productService.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="my-service")
public interface TaxClient {

	@GetMapping("/tax/{name}")
	public Double tax(@PathVariable(value ="name") String name);
	
}
