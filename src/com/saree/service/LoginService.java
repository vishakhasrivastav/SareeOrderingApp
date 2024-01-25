package com.saree.service;

public interface LoginService {

	public boolean customerLogin(String username,String password) ;
	
	public boolean adminLogin(String username,String password); 
	
	public boolean changeCustomerPassword(String username,String oldPassword ,String newPassword) ;
	public boolean chnageAdminPassword(String username,String oldPassword ,String newPassword) ;
	
}
