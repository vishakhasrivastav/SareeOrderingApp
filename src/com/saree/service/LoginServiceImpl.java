package com.saree.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.saree.utility.DBConnection;


public class LoginServiceImpl  implements LoginService {
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public boolean customerLogin(String username, String password) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from customer_6370 where customerId=? && password=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
				
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
	public boolean adminLogin(String username, String password) {
try {
			
			con=DBConnection.makeConnection();
			sql="select * from admin_6370 where adminId=? && adPassword=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		ps.close();
		rs.close();
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}

		return false;
	}

	@Override
	public boolean changeCustomerPassword(String username, String oldPassword, String newPassword) {
try {
			
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
	public boolean chnageAdminPassword(String username, String oldPassword, String newPassword) {
try {
			
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


	
		
	}


