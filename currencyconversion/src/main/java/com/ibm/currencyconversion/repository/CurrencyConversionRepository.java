package com.ibm.currencyconversion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.currencyconversion.entity.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long>{

	public Optional<CurrencyConversion> findByCountryCode(String countryCode);
}
