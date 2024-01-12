package FoodDAO;

import java.sql.*;
import java.util.*;

public class ItemDAO {
	
	
	DBConnection DB=new DBConnection();
	public void addItem(Item item) throws Exception {
		Connection con=DB.getConnection();
		PreparedStatement ps =con.prepareStatement("insert into food values (?,?,?)");
		ps.setString(1, item.getName());
		ps.setDouble(2, item.getPrice());
		ps.setString(3, item.getType());
		ps.executeUpdate();
	}
	public void bulkCopy(List<Item> itemList) throws Exception
	{
		ItemDAO dao = new ItemDAO();
		for(Item i:itemList)
		{
			dao.addItem(i);
		}
	}

	public List<Item> findItem(String find) throws Exception {
		Connection con=DB.getConnection();
		List<Item> TypeList=new  ArrayList<>();
		PreparedStatement ps =con.prepareStatement("select * from food where type=?");
		ps.setString(1,find);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TypeList.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
		}
		return TypeList;
	}
	public List<Item> findItem_price(Double price) throws Exception{
		Connection con=DB.getConnection();
		List <Item> search_price=new ArrayList<>();
		PreparedStatement ps=con.prepareStatement("select * from food where price=?");
		ps.setDouble(1, price);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			search_price.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
		}
		return search_price;
		
	}

}
