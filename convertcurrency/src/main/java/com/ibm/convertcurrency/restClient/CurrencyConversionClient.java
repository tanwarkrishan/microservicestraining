package com.ibm.convertcurrency.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currencyconversion-service")
public interface CurrencyConversionClient {

	@GetMapping("/currency/factor/{countryCode}")
	public Double getConversionFactor(@PathVariable(name = "countryCode") String countryCode);
}
