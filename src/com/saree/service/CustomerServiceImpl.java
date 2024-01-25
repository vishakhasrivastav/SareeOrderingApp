package com.saree.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.saree.entity.Customer;
import com.saree.utility.DBConnection;


public class CustomerServiceImpl implements CustomerService{
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public boolean addCustomer(Customer c) {
			try {
						
						con=DBConnection.makeConnection();
						sql="insert into customer_6370 values(?, ?, ?, ?, ?, ?,  ? )";
						ps=con.prepareStatement(sql);
						ps.setString(1, c.getCustomerId());
						ps.setString(2, c.getCustomerName());
						ps.setString(3, c.getEmailId());
						ps.setString(4, c.getAddress());
						ps.setString(5, c.getDropingaddress());
						ps.setLong(6, c.getContactNumber());
						ps.setString(7, c.getPassword());
						int i=ps.executeUpdate();
						if(i>0)
							return true;
						
					}
					catch(Exception e) {
						
						e.printStackTrace();
					}
			         finally {
				         try {
				
					ps.close();
				   con.close();
				         }
				catch(SQLException e) {
					e.printStackTrace();
				}
			         }
					
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		con=DBConnection.makeConnection();
		sql="update customer_6370 set customerName=?, password=?, emailId=?, contactNumber=?, address=? where customerId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(6, c.getCustomerId());
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getEmailId());
			ps.setLong(4, c.getContactNumber());
			ps.setString(5, c.getAddress());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		

		return false;
	}

	@Override
	public     boolean deleteCustomerDetails(String customerId) {
		con=DBConnection.makeConnection();
		sql="delete from customer_6370 where customerId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;  
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		
		con=DBConnection.makeConnection();
		sql="Select * from customer_6370 where customerId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				Customer c=new Customer();
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setPassword(rs.getString("password"));
				c.setEmailId(rs.getString("emailId"));
				c.setContactNumber(rs.getLong("ContactNumber"));
				c.setAddress(rs.getString("address"));
				
				return c;  
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Customer getEmail(String emailId) {
		con=DBConnection.makeConnection();
		sql="select * from customer_6370 where emailId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Customer c=new Customer();
				
				c.setCustomerId(rs.getString("customerId"));
				c.setCustomerName(rs.getString("customerName"));
				c.setEmailId(rs.getString("emailId"));
				c.setContactNumber(rs.getLong("ContactNumber"));
				c.setAddress(rs.getString("address"));
				c.setPassword(rs.getString("Password"));
				c.setDropingaddress(rs.getString("dropingAddress"));
				c.setPassword(rs.getString("password"));
				
				return c;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	

	
		return null;
	}

}
