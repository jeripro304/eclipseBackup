package ecommerce.repo;

import java.sql.*;

public class DAOclass {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ekart","root","hr");
			
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
