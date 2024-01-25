package com.saree.service;

import java.util.List;

import com.saree.entity.Order;

public interface OrderService {

	public Order placeOrder(Order o);
	public boolean cancelOrder(String orderId);
	
	public List<Order> showMyOrderHistory(String customerId);
	public Order showOrderById(String orderId);
}
