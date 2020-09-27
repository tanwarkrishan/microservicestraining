package com.ibm.currencyconversion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.currencyconversion.entity.CurrencyConversion;
import com.ibm.currencyconversion.repository.CurrencyConversionRepository;

@Service
public class CurrencyConversionService {

	@Autowired
	CurrencyConversionRepository currencyConversionRepository;
	
	public CurrencyConversion addConversionFactor(CurrencyConversion currency) {
	
		return currencyConversionRepository.save(currency);
	}
	
	public CurrencyConversion updateConversionFactor(CurrencyConversion currency) {
		
		Optional<CurrencyConversion> conversion = currencyConversionRepository.findByCountryCode(currency.getCountryCode());
		
		CurrencyConversion updatedFactor = null;
		if(conversion.isPresent()) {
			conversion.get().setConversionFactor(currency.getConversionFactor());
			updatedFactor = currencyConversionRepository.save(conversion.get());
		}
		return updatedFactor;
		
	}
	
	public Double getConversionFactorByCountryCode(String code) {
		Optional<CurrencyConversion> conversion = currencyConversionRepository.findByCountryCode(code);
		
		Double factor = 0.0;
		if(conversion.isPresent()) {
			factor = conversion.get().getConversionFactor();
		}
		
		return factor;
	}
}
