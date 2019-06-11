package com.shopping.orders.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="order_table")
public class Order {

	@Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
	private Long orderId;
	
	@ManyToOne
    @JoinColumn(name = "account_id")	
	private Account account;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private String status;

	public Order() {
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
