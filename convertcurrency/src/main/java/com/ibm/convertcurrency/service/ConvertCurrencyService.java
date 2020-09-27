package com.ibm.convertcurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.convertcurrency.restClient.CurrencyConversionClient;

@Service
public class ConvertCurrencyService {

	final CurrencyConversionClient currencyConversionClient;
	
	@Autowired
	public ConvertCurrencyService(CurrencyConversionClient currencyConversionClient) {
		this.currencyConversionClient = currencyConversionClient;
	}
	
	public Double getConvertAmount(String code, Double amount) {
		Double convertedAmount = 0.0;
		Double factor = currencyConversionClient.getConversionFactor(code);
		convertedAmount = factor * amount;
		return convertedAmount;
	}
}
