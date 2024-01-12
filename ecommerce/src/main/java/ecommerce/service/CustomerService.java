package ecommerce.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Customer;
import ecommerce.model.Product;
import ecommerce.model.UserCart;
import ecommerce.repo.DAOclass;

public class CustomerService {
	public String addcustomer(Customer c) {
		
		Connection con=DAOclass.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement("insert into customer values (?,?,?,?,?,?);");
			
			ps.setString(1,c.getName());
			java.sql.Date d1=new java.sql.Date(c.getDob().getTime());
            ps.setDate(2,d1);
            ps.setString(3, c.getPhno());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPass());
            ps.setString(6, c.getScope());
            ps.executeUpdate();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Customer added";
	}
	public List<Customer> viewcustomerlist() throws SQLException{
		Connection con=DAOclass.getConnection();
		List<Customer> clist=new ArrayList<>();
		
		PreparedStatement ps= con.prepareStatement("select name,date,phno,email,pass,scope from customer;");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			clist.add(new Customer(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
		}
		
		return clist;
		
	}
	
	public String status(String stat) throws SQLException {
		Connection con =DAOclass.getConnection();
		PreparedStatement ps =con.prepareStatement("select * from customer where name=?;");
		ps.setString(1,stat);
		ResultSet rs=ps.executeQuery();
		rs.next();
		
		if ("invalid".equals(rs.getString(6))) {
			PreparedStatement ps1=con.prepareStatement("update customer set scope=? where name=?;");
			ps1.setString(1, "valid");
			ps1.setString(2, stat);
			ps1.executeUpdate();
		}
		else  {
			PreparedStatement ps2=con.prepareStatement("update customer set scope=? where name=?;");
			ps2.setString(1, "invalid");
			ps2.setString(2, stat);
			ps2.executeUpdate();
		}
		
		
		return "status updated";
		
		
	}
	
	public String deletecustomer(String name) throws SQLException {
		Connection con =DAOclass.getConnection();
		PreparedStatement ps =con.prepareStatement("delete from customer where name=?");
		ps.setString(1, name);;
		ps.executeUpdate();
		
		return name;
		
	}
	
	public List<Product> custsearch(String name) throws SQLException {
		Connection con =DAOclass.getConnection();
		PreparedStatement ps =con.prepareStatement("select * from product where pname like ?");
		ps.setString(1, "%" + name + "%");
		ResultSet rs=ps.executeQuery();
		List<Product> prolist=new ArrayList<>();
		while(rs.next()) {
			prolist.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5)));
		}
		System.out.println(prolist);
		
		return prolist;
	}
	
	
	
	
	
	public String cartadd(int id,String uname) throws SQLException {
		Connection con =DAOclass.getConnection();
		System.out.println(id);
		System.out.println(uname);
		try {
			PreparedStatement ps = con.prepareStatement("select * from cart where pid=? and pname=?");
			ps.setInt(1, id);
			ps.setString(2, uname);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			int qty=rs.getInt(3);
			
			PreparedStatement ps1=con.prepareStatement("update cart set qtycart=? where pid=? and pname=?");
			qty++;
			ps1.setInt(1, qty);
			ps1.setInt(2, id);
			ps1.setString(3, uname);
			ps1.executeUpdate();
		}
		catch(Exception e){
			System.out.println("into catch  block");
			PreparedStatement ps3 = con.prepareStatement("insert into cart values (?,?,?);");
			ps3.setString(1, uname);
			ps3.setInt(2, id);
			ps3.setInt(3, 1);
			ps3.executeUpdate();
		}
		
		
		return uname;
	}
	
	public List<Product> cartviewproduct(String usname) throws SQLException{
		Connection con=DAOclass.getConnection();
		List<Product> plist =new ArrayList<>();	
		List<Integer> cartlist =new ArrayList<>();
				
		PreparedStatement ps =con.prepareStatement("select pid from cart where pname=?;");
		ps.setString(1, usname);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			cartlist.add(rs.getInt(1));
		}
		System.out.println("cartlist");
		System.out.println(cartlist);
		for(Integer i:cartlist) {
			int iter=i;
			System.out.println(iter);
			PreparedStatement ps1 =con.prepareStatement("select * from product where pid=?");
			ps1.setInt(1,iter);
			ResultSet rs1=ps1.executeQuery();
			if (rs1.next()) {
				System.out.println(rs1.getInt(1));
				plist.add(new Product(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getInt(4),rs1.getDouble(5)));
			}
			
		}
		System.out.println("cart view product list");
		System.out.println(plist);
		return plist;
	}
	
	public static List<UserCart> wishlist=new ArrayList<>();
	
	public List<UserCart> userwishlist(UserCart p,int id){
		wishlist.add(p);
		System.out.println(wishlist);
		return wishlist;
		
	}
	
//	public List<UserCart> userwishlist(UserCart p,int id){
//		for(UserCart i:wishlist) {
//			if (i.getPid()==id) {
//				System.out.println("same");
//			}
//			else {
//				wishlist.add(p);
//			}
//		}
//		
//		System.out.println(wishlist);
//		return wishlist;
//	}
	public void removewishlist(int id) {
		for (UserCart i:wishlist) {
			if (i.getPid()==id){
				wishlist.remove(i);
				break;
			}
		}
	}
	
	public String purchase(int id,int qty,int cartqty) throws SQLException {
		Connection con=DAOclass.getConnection();
		int qtyset= qty-cartqty;
		PreparedStatement ps =con.prepareStatement("update product set pqty=? where pid=? ");
		ps.setInt(1, qtyset);
		ps.setInt(2, id);
		ps.executeUpdate();
		return null;
		
	}
	
	public String removefromcart(int id) throws SQLException {
		Connection con=DAOclass.getConnection();
		PreparedStatement ps =con.prepareStatement("delete from cart where pid=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		return "removed";
		
	}
	
//	public boolean Customername(String usname) throws SQLException {
//		Connection con=DAOclass.getConnection();
//		PreparedStatement ps=con.prepareStatement("select email from customer where email=?");
//		ps.setString(1, usname);
//		ResultSet rs=ps.executeQuery();
//		if(rs.next()) {
//			System.out.println("username is there");
//		}
//		return true;
//		
//		
//	}
//	
//	
	
//	public boolean Customerpass(String usname,String pass) throws SQLException {
//		Connection con=DAOclass.getConnection();
//		PreparedStatement ps=con.prepareStatement("select pass,scope from customer where email=?");
//		ps.setString(1, usname);
//		ResultSet rs=ps.executeQuery();
//		System.out.println(rs.getString(1));
//		System.out.println(rs.getString(2));
//		while (rs.next()) {
//			while (pass.equals(rs.getString(1))) {
//				while (rs.getString(2).equals("valid"));
//				continue;
//			}
//			continue;
//		}
//		
//		return true;
//	}
//	
//	public boolean CustomerValid(String usname,String password) throws SQLException {
//		Connection con=DAOclass.getConnection();
//	    PreparedStatement ps=con.prepareStatement("select scope from customer where email=?");
//	    ps.setString(1, usname);
//	    ResultSet rs=ps.executeQuery();
//	    if(rs.next()) {
//	    	if (rs.getString(1).equals("valid"));
//	    }
//		
//		return true;
//		
//	}

}
