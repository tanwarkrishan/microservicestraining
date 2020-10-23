package com.ibm.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orderdetail")
public class OrderDetail {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String productName;
	
	@Column(name = "token")
	private String token;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String authorization) {
		this.token = authorization;
	}
	
	
}
