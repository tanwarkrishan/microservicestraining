package com.ibm.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconversion.entity.CurrencyConversion;
import com.ibm.currencyconversion.service.CurrencyConversionService;

@RestController
@RequestMapping("currency")
@EnableDiscoveryClient
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionService currencyService;
	
	@PostMapping("/")
	public ResponseEntity<?> addConversionFactor(@RequestBody CurrencyConversion currency) {
		return ResponseEntity.ok().body(currencyService.addConversionFactor(currency));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateConversionFactor(@RequestBody CurrencyConversion currency) {
		CurrencyConversion curr = currencyService.updateConversionFactor(currency);
		if(null != curr) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/factor/{countryCode}")
	public Double getConversionFactor(@PathVariable(name = "countryCode") String countryCode) {
		return currencyService.getConversionFactorByCountryCode(countryCode);
	}
}
