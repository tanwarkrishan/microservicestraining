package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.service.ConvertCurrencyService;

@RestController
@RequestMapping("convert")
public class ConvertCurrencyController {

	@Autowired
	ConvertCurrencyService convertCurrencyService;
	
	@GetMapping("/{code}/{amount}")
	public Double getConvertAmount(@PathVariable(name = "code") String code, @PathVariable(name = "amount") Double amount) {

		return convertCurrencyService.getConvertAmount(code, amount);
		
	}
}
