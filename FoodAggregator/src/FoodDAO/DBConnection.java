package FoodDAO;
import java.sql.*;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		Connection con=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root");
			//System.out.println("success");
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		return con;
	}
}
