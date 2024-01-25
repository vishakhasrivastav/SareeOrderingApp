package com.saree.entity;



public class Cart {

	private String cartId;
	private String sareeId;
	private String   emailId;
	private Integer quantity;
	private String customerId;
	private Double subTotal;//price * quantity
	private Double price;//saree price
	private Saree s;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String cartId, String sareeId,  Integer quantity, String customerId, Double subTotal,
			Double price) {
		super();
		this.cartId = cartId;
		this.sareeId = sareeId;
		
		this.quantity = quantity;
		this.customerId = customerId;
		this.subTotal = subTotal;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getEmailI() {
		return emailId;
	}
	public void setEmailI(String emailI) {
		this.emailId = emailI;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public String getSareeId() {
		return sareeId;
	}
	public void setSareeId(String foodId) {
		this.sareeId = foodId;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", sareeId=" + sareeId + ", CustomerId=" + customerId + ", quantity=" + quantity
				+ ", subTotal=" + subTotal + ", price=" + price + ", s=" + s + "]";
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Saree getS() {
		return s;
	}

	public void setS(Saree s) {
		this.s = s;
	}
	
}
