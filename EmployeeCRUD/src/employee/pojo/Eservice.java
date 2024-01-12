package employee.pojo;

import java.util.*;
import java.sql.*;

class Eservice {
	Scanner sc=new Scanner(System.in);
	PreparedStatement ps;
	ResultSet rs;
	Employee e=new Employee();
	
	public Employee searchid(Connection con,int  sid) throws Exception{
		
		Employee emp=null;
		ps=con.prepareStatement("select * from new_table where eid=?");
		ps.setInt(1, sid);
		rs=ps.executeQuery();
		while(rs.next()) {
			emp=new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		return emp;	
	}
	
	public void createdet(Connection con)throws Exception {
		System.out.println("Enter the id : ");
		e.setEid(sc.nextInt());

		if (searchid(con,e.getEid())==null) {
			System.out.print("Enter the name :");
			e.setEname(sc.next());
			System.out.print("Enter the salary :");
			e.setSalary(sc.nextInt()) ;
			ps=con.prepareStatement("insert into new_table values(?,?,?)");
			ps.setInt(1,e.getEid());
			ps.setString(2,e.getEname());
			ps.setInt(3,e.getSalary());
			int result=ps.executeUpdate();
			System.out.println("New employee created");	
		}
		else {
			System.out.println("Employee details already present ");
		}
	}
	public void update(Connection con) throws Exception {
		System.out.print("Enter the id : ");
		e.setEid(sc.nextInt());
		System.out.println("Id found what you want to update choose an option below");
		if (searchid(con,e.getEid())==null) {
			System.out.println("Employee details not present");
		}
		else {
			System.out.println("1.To update the name ");
			System.out.println("2.To update the salary");
			System.out.print("Enter the choice what to update :");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the updated name : ");
				e.setEname(sc.next());
				ps=con.prepareStatement("update new_table set ename=? where eid=?");
				ps.setString(1, e.getEname());
				ps.setInt(2, e.getEid());
				ps.executeUpdate();
				break;
			case 2:
				System.out.print("Enter the updated salary : ");
				e.setSalary(sc.nextInt());
				ps=con.prepareStatement("update new_table set salary=? where eid=?");
				ps.setInt(1, e.getSalary());
				ps.setInt(2, e.getEid());
				ps.executeUpdate();
				break;
			}
			System.out.println("Employee updated successfully");
		}
	}
	public void display(Connection con) throws SQLException {
		ps=con.prepareStatement("select * from new_table");
		rs =ps.executeQuery();
		while(rs.next()) {
			e.setEid(rs.getInt(1));
			e.setEname(rs.getString(2));
			e.setSalary(rs.getInt(3));
			System.out.println(e);
		}
		
	}
	public void delete(Connection con ) throws Exception {
		System.out.print("Enter the employee id to delete : ");
		e.setEid(sc.nextInt());
		
		if (searchid(con,e.getEid())==null) {
			System.out.println("Employee detail not found");
		}
		else {
			ps=con.prepareStatement("delete from new_table where eid=?");
			ps.setInt(1,e.getEid());
			ps.executeUpdate();
			System.out.println("Deleted Successfully");
		}
	}

	
}
