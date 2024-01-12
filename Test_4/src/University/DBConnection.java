package University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws Exception {
		Connection con=null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
			System.out.println("success");
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
