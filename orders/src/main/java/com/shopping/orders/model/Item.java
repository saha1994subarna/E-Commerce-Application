package com.shopping.orders.model;

import java.math.BigDecimal;

public class Item {
	private long itemId;
	private String itemName;
	private BigDecimal unitPrice;
	private long numberOfUnits;
	private BigDecimal totalAmount;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(long numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
