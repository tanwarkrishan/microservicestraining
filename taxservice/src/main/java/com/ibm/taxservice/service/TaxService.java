package com.ibm.taxservice.service;

import org.springframework.stereotype.Service;

@Service
public class TaxService {
	
	public Double getTax(String productName) {
		
		Double tax=0.0;
		if(productName.equals("Apple")) {
			
			return tax=10.0;
		}else if (productName.equals("Orange")) {
			return tax=12.0;
		}else {
			return tax=5.0;
		}
	}

}
