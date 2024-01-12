package edu.prodapt.demos;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class JdbcDemo {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter the id to add : ");
//		int sid =sc.nextInt() ;
//		System.out.print("Enter the name : ");
//		String sname=sc.next();
//		System.out.print("Enter the marks : ");
//		int mark =sc.nextInt();
		System.out.print("Enter the above mark range to print the details ;");
		int getmark=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("success");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
			
			//PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
			//PreparedStatement ps=con.prepareStatement("select * from student where marks>"+getmark);
			PreparedStatement ps=con.prepareStatement("select * from student where marks> ?");
			
//			ps.setInt(1,sid);
//			ps.setString(2,sname);
     		ps.setInt(1, getmark);
//			int temp1=ps.executeUpdate();
			
//			Statement stmt= con.createStatement();
//			int temp =stmt.executeUpdate("insert into student values ("+sid+",'"+sname+"',"+mark+");");
      		//ResultSet rs =stmt.executeQuery("select *from student where sname ='FAZ'");
			ResultSet rs= ps.executeQuery();
//			System.out.println("SID  Name  Marks");
//			System.out.println("--------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("marks"));
			}
			
//			System.out.println("Loaded Succes");
			
			
			
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
}
