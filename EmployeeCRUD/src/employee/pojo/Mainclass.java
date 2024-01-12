package employee.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) throws Exception {
		try {
			Eservice ser=new Eservice();
			boolean flag=true;
			while(flag) {
				Scanner sc=new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				//System.out.println("success");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
						
				System.out.println("1. Create");
				System.out.println("2. Update");
				System.out.println("3. Display");
				System.out.println("4. Search");
				System.out.println("5. Delete");
				System.out.print("Enter the choice : ");
				int ch=sc.nextInt();		
			
				
				switch(ch) {
				case 1:
					System.out.println("******************CREATE***********************");
					ser.createdet(con);
					System.out.println("***********************************************");
					break;
					
				case 2:
					System.out.println("******************UPDATE***********************");
					ser.update(con);
					System.out.println("***********************************************");
					break;
					
				case 3:
					System.out.println("******************DISPLAY***********************");
					ser.display(con);
					System.out.println("************************************************");
					break;
					
				case 4:
					System.out.println("******************SEARCH***********************");
					System.out.print("Enter the Employee id to search :");
					Employee e =new Employee();
					e.setEid(sc.nextInt());
					Employee emp=ser.searchid(con,e.getEid());
					if (emp==null) {
						System.out.println("No employee detail found");
					}
					else {
						System.out.println("Employee detail is present ");
						
						System.out.println(emp);
					}
					System.out.println("************************************************");
					break;
					
				case 5:
					System.out.println("******************DELETE***********************");
					ser.delete(con);
					System.out.println("************************************************");
					break;
				case 6:
					flag=false;
					System.exit(0);
					break;
					}
			}
			
		}
		

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}

}
