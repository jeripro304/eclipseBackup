package ecommerce.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.PacketReceivedTimeHolder;

import ecommerce.model.Customer;

import ecommerce.model.Product;
import ecommerce.repo.DAOclass;

public class PorductService {
	
	
	public String addProduct(Product p) throws SQLException {
		
		Connection con=DAOclass.getConnection();
		System.out.println("Sucess");
		
		
			PreparedStatement ps=con.prepareStatement("insert into product values (?,?,?,?,?);");
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setString(3, p.getPdesc());
			ps.setInt(4,p.getPqty());
			ps.setDouble(5,p.getPprice());
			ps.executeUpdate();
			
				
		return "Products Added";
		
		
	}
	
	public List<Product> viewproduct(){
		Connection con=DAOclass.getConnection();
		List<Product> plist =new ArrayList<>();		
		
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		return plist;
	}
	
	public String edit(int eid,double price,int qty)
	{
		Connection con=DAOclass.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = con.prepareStatement("update product set price=?,pqty=? where pid=?");
			ps.setDouble(1,price );  
			ps.setInt(2, qty);
			ps.setInt(3, eid);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "Edited successfully";
		
	}
	
	public String delete(int id) {
		Connection con=DAOclass.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("delete from product where pid=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Deleted successfully";
		
	}
	
//	List<Product> mylist=new ArrayList<>(); 
	
//	public List<Product> mylistview(int id) throws SQLException{
//		
//		
//		Connection con=DAOclass.getConnection();
//		PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
//		Product p=new Product();
//		
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		System.out.println(mylist);
//		while(rs.next()) {
//			mylist.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
//		}
//		
//		
//		return mylist;
//		
//	}
	
	
	
	
	
	
}
