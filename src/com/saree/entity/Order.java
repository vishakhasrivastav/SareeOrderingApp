package com.saree.entity;

import java.time.LocalDate;

import java.time.LocalDateTime;
/*
 * We can have cartlist in this class so as to know what has to be delivered to each customer.
 * Mapping of List type collection with MySql is easy with Hibernate. Since we have not completed
 * Hibernate this part needs to be done later; after the said Hibernate portion is done.
 */
public class Order {
	private String orderId;
	private LocalDate orderDate;
	private String dropAddress;
	private LocalDateTime expectedDelivery;
	private String customerId;
	private Double billingAmount;
	private String status;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(String orderId, LocalDate orderDate, String dropAddress, LocalDateTime expectedDelivery,
			String customerId, Double billingAmount, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dropAddress = dropAddress;
		this.expectedDelivery = expectedDelivery;
		this.customerId = customerId;
		this.billingAmount = billingAmount;
		this.status = status;
	}


	@Override
	public String toString() {
		return "\nOrder [orderId=" + orderId + "\n orderDate=" + orderDate + "\ndropAddress=" + dropAddress
				+ "\n expectedDelivery=" + expectedDelivery + "\ncustomerId=" + customerId + "\nbillingAmount="
				+ billingAmount + "\nstatus=" + status + "]";
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public String getdropAddress() {
		return dropAddress;
	}


	public void setdropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}


	public LocalDateTime getExpectedDelivery() {
		return expectedDelivery;
	}


	public void setExpectedDelivery(LocalDateTime expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Double getBillingAmount() {
		return billingAmount;
	}


	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
