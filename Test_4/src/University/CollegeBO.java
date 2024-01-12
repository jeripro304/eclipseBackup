package University;

import java.util.ArrayList;
import java.text.*;
import java.util.*;

import java.sql.*;
import java.sql.Date;

public class CollegeBO {
	Scanner sc=new Scanner(System.in);
	DBConnection DB=new DBConnection();
	
	public void addCollege(College col) throws Exception {
		Connection con=DB.getConnection();
		PreparedStatement ps =con.prepareStatement("insert into university values (?,?,?,?,?,?)");
		ps.setString(1, col.getName());
		ps.setString(2, col.getWebsite());
		ps.setString(3,col.getMobile());
		ps.setString(4,col.getFounder());
		ps.setInt(5, col.getNumberOfDept());
		ps.setString(6,col.getLocation() );
		ps.setDate(7,new java.sql.Date (col.getStartingDate().getTime()));
		ps.executeUpdate();
		
	}
	
	public List<College> findCollege(List<String> namelist) throws Exception{
		Connection con=DB.getConnection();
		List<College> flist=new ArrayList<>();
		for(int i=0;i<namelist.size();i++) {
			PreparedStatement ps =con.prepareStatement("select * from univeristy where name=?");
			ps.setString(1,namelist.get(i));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flist.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
			}
		}
	
		return flist;
	}
	public  List<College> findCollege(Date startingDate) throws Exception{
		List<College> find=new ArrayList<>();
		Connection con=DB.getConnection();
		PreparedStatement ps =con.prepareStatement("select * from univeristy where date=?");
		ps.setDate(1, startingDate);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			find.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
		}
		return find;
		
	}
	public List<College> findCollege(String location) throws Exception{
		List<College> lList = new ArrayList<>();
		Connection con=DB.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from college where location = ?");
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				lList.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
			} 
		return lList;
		
	}
	public void sortDept(List<College> list) {
		Collections.sort(list,(o1,o2)->o1.getNumberOfDept().compareTo(o2.getNumberOfDept()));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","Name","Website","Mobile","Founder","Number od dept","Location","Starting Date");
		for(College i:list) {
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",i.getName(),i.getWebsite(),
					i.getMobile(),i.getFounder(),i.getNumberOfDept(),i.getLocation(),i.getStartingDate());
		}
		
	}
	public void sortName(List<College> list) {
		Collections.sort(list,(o1,o2)->o1.getName().compareTo(o2.getName()));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","Name","Website","Mobile","Founder","Number od dept","Location","Starting Date");
		for(College i:list) {
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",i.getName(),i.getWebsite(),
					i.getMobile(),i.getFounder(),i.getNumberOfDept(),i.getLocation(),i.getStartingDate());
		}
		
	}
	public void sortDate(List<College> list) {
		Collections.sort(list,(o1,o2)->o1.getStartingDate().compareTo(o2.getStartingDate()));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","Name","Website","Mobile","Founder","Number od dept","Location","Starting Date");
		for(College i:list) {
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",i.getName(),i.getWebsite(),
					i.getMobile(),i.getFounder(),i.getNumberOfDept(),i.getLocation(),i.getStartingDate());
		}
		
	}
	public void sorting(List<College> result) {
		System.out.println("1.Sort by college name");
		System.out.println("2.sort by date ");
		System.out.println("3.sort by department");
		int opt = sc.nextInt();
		
		switch(opt) {
		case 1:
			sortName(result);
			break;
			
		case 2:
			sortDate(result);
			break;
			
		case 3:
			sortDept(result);
			break;
	
}
