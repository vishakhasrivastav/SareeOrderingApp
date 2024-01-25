package com.saree.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saree.entity.Saree;
import com.saree.utility.DBConnection;

public class SareeServiceImpl implements SareeService {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	@Override
	public Boolean addSaree(Saree s) {
		try {
			con=DBConnection.makeConnection();
			sql="insert into Saree_6370 values(?, ?, ?, ?, ?, ?, ?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, s.getSareeId());
			ps.setString(2, s.getSareeName());
			ps.setString(3, s.getType());
			ps.setString(4, s.getCategory());
			ps.setString(5, s.getColor());
			ps.setDouble(6, s.getPrice());
			ps.setInt(7, s.getQuantityInstock());
			
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Boolean updateDetails(Saree s) {
		try {
			con=DBConnection.makeConnection();
			sql="update Saree_6370 set color=?, price=?, quantityInStock=? where sareeId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, s.getColor());
			ps.setDouble(2, s.getPrice());
			ps.setInt(3, s.getQuantityInstock());
			ps.setString(4, s.getSareeId());
			
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Boolean deleteSaree(String sareeId) {
		try {
			con=DBConnection.makeConnection();
			sql="delete from Saree_6370 where sareeId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, sareeId);
			
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Saree getSareeById(String sareeId) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Saree_6370 where sareeId=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, sareeId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Saree s=new Saree();
				
				s.setSareeId(rs.getString("sareeId"));
				s.setSareeName(rs.getString("sareeName"));
				s.setType(rs.getString("type"));
				s.setCategory(rs.getString("category"));
				s.setColor(rs.getString("color"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantityInstock(rs.getInt("quantityInstock"));
				
				return s;
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
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Saree> showAllSaree() {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Saree_6370";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<Saree> slist=new ArrayList<Saree>();
			while(rs.next()) {
				Saree s=new Saree();
				
				
				s.setSareeId(rs.getString("sareeId"));
				s.setSareeName(rs.getString("sareeName"));
				s.setType(rs.getString("type"));
				s.setCategory(rs.getString("category"));
				s.setColor(rs.getString("color"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantityInstock(rs.getInt("quantityInstock"));
				
				slist.add(s);
			}
			return slist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Saree> getSareeByCategory(String category) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Saree_6370 where category=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, category);
			
			rs=ps.executeQuery();
			List<Saree> slist=new ArrayList<Saree>();
			
			while(rs.next()) {
				Saree s=new Saree();
				
				s.setSareeId(rs.getString("sareeId"));
				s.setSareeName(rs.getString("sareeName"));
				s.setType(rs.getString("type"));
				s.setCategory(rs.getString("category"));
				s.setColor(rs.getString("color"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantityInstock(rs.getInt("quantityInstock"));
				
				slist.add(s);
			}
			
			return slist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Saree> getSareeByColor(String color) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Saree_6370 where color=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, color);
			
			rs=ps.executeQuery();
			List<Saree> slist=new ArrayList<Saree>();
			
			while(rs.next()) {
				Saree s=new Saree();
				
				s.setSareeId(rs.getString("sareeId"));
				s.setSareeName(rs.getString("sareeName"));
				s.setType(rs.getString("type"));
				s.setCategory(rs.getString("category"));
				s.setColor(rs.getString("color"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantityInstock(rs.getInt("quantityInstock"));
				
				slist.add(s);
			}
			
			return slist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Saree> getSareetByType(String type) {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Saree_6370 where type=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, type);
			
			rs=ps.executeQuery();
			List<Saree> slist=new ArrayList<Saree>();
			
			while(rs.next()) {
				Saree s=new Saree();
				
				s.setSareeId(rs.getString("sareeId"));
				s.setSareeName(rs.getString("sareeName"));
				s.setType(rs.getString("type"));
				s.setCategory(rs.getString("category"));
				s.setColor(rs.getString("color"));
				s.setPrice(rs.getDouble("price"));
				s.setQuantityInstock(rs.getInt("quantityInstock"));
				
				slist.add(s);
			}
			
			return slist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
