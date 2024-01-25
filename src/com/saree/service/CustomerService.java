package com.saree.service;

import com.saree.entity.Customer;

public interface CustomerService {

	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomerDetails(String customerId);
	
	
	
	  public Customer getCustomerById(String customerId);
	
	  public Customer getEmail(String emailId);
	
}
