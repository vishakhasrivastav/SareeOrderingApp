package com.saree.entity;

public class Customer {
	private String customerId;
	private String customerName;
	private String  emailId; //
	private String address; //
	private  String dropingAddress;
	private  long contactNumber;
	private String password;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerId, String customerName, String emailId, String address,
			 String dropingAddress, long contactNumber, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.address = address;
		this.dropingAddress = dropingAddress;
		this.contactNumber = contactNumber;
		this.password = password;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDropingaddress() {
		return dropingAddress;
	}
	public void setDropingaddress(String dropingAddress) {
		this.dropingAddress = dropingAddress;
	}
	@Override
	public String toString() {
		return "\nCustomer [customerId=" + customerId + "\n customerName=" + customerName + "\n emailId=" + emailId
				+ "\naddress=" + address  
				+ "\n dropingAddress=" + dropingAddress + "\n contactNumber=" + contactNumber + "]";
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
