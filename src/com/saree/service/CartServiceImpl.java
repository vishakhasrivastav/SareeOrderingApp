package com.saree.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.saree.entity.Cart;
import com.saree.entity.Saree;
import com.saree.utility.DBConnection;

public class CartServiceImpl implements CartService {
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public boolean addToCart(Cart c) {
try {
			
			con=DBConnection.makeConnection();
			sql="insert into cart_6370 values(?, ?, ?, ?, ?, ? )";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCartId());
			ps.setString(2, c.getSareeId());
			ps.setString(3, c.getCustomerId());
			ps.setInt(4, c.getQuantity());
			ps.setDouble(6, c.getSubTotal());
			ps.setDouble(5, c.getPrice());
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
	public boolean updateQuantity(String carId, Integer quantity) {
try {
			
			con=DBConnection.makeConnection();
			sql="update cart_6370 set quantity=? where cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setString(2, carId);
			
			int i=ps.executeUpdate();
			if(i>0) {
				
				sql="update cart_6370 set subTotal=price*quantity where cartId=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, carId);
				
				i=ps.executeUpdate();
				if(i>0)
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
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteFoodItemCart(String cartId) {
		try {
			con=DBConnection.makeConnection();
			sql="delete from cart_6370 where cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, cartId);
			
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
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean clearMyCart(String customerId) {
		try {
			con=DBConnection.makeConnection();
			sql="delete from cart_6370 where customerId=?";
			
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
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Cart> showMyCart(String customerId) {
		
try {
			
			con=DBConnection.makeConnection();
			sql="select * from cart_6370 where customerId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			
			rs=ps.executeQuery();
			List<Cart> clist=new ArrayList<Cart>();
			
			while(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setSareeId(rs.getString("sareeId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Saree s=new SareeServiceImpl().getSareeById(rs.getString("sareeId"));
				c.setS(s);;
				
				clist.add(c);
				
			}
			System.out.println(clist);
			return clist;
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
			
		return null;
	
	}

	@Override
	public List<Cart> showAllCart() {
		try {
			con=DBConnection.makeConnection();
			sql="select * from cart_6370  ";
			
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			List<Cart> clist=new ArrayList<Cart>();
			
			while(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setSareeId(rs.getString("sareeId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Saree s=new SareeServiceImpl().getSareeById(rs.getString("sareeId"));
				c.setS(s);
				
				clist.add(c);
			}
			
			return clist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Cart getCartById(String cartId) {
		try {
			
			con=DBConnection.makeConnection();
			sql="select * from cart_6370 where cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, cartId);
			
			rs=ps.executeQuery();
			
			
			if(rs.next()) {
				
				Cart c=new Cart();
				c.setCartId(rs.getString("cartId"));
				c.setCustomerId(rs.getString("customerId"));
				c.setSareeId(rs.getString("sareeId"));
				c.setPrice(rs.getDouble("price"));
				c.setQuantity(rs.getInt("quantity"));
				c.setSubTotal(rs.getDouble("subTotal"));
				
				Saree s=new SareeServiceImpl().getSareeById(rs.getString("sareeId"));
				c.setS(s);
				
			
				
			
			
			return c;
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
		return null;
	}
	

	@Override
	public boolean checkFoodItem(String customerId, String sareeId) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from cart_6370 where customerId=? && cartId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerId);
			ps.setString(2, sareeId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				
				Integer quantity=rs.getInt("quantity");
				quantity++;
				
				String cartId=rs.getString("cartId");
				
				boolean flag=updateQuantity(cartId, quantity);
				
				return flag;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return false;
	}

}
