package com.shopping.orders.entities;

import java.math.BigDecimal;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import lombok.Data;

@Entity
@Table(name="product")
//@Data
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id", nullable = false)	
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;

	public Product() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}