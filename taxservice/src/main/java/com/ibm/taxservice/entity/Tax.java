package com.ibm.taxservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tax")
public class Tax {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private Double tax;

}
