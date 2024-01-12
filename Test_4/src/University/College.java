package University;
import java.util.*;

public class College {
	private String name;
	private String website;
	private String mobile;
	private String founder;
	private int numberOfDept;
	private String location;
	private java.util.Date  startingDate;
	
	public College(String name, String website, String mobile, String founder, int numberOfDept, String location,Date startingDate){
		this.name = name;
		this.website = website;
		this.mobile = mobile;
		this.founder = founder;
		this.numberOfDept = numberOfDept;
		this.location = location;
		this.startingDate = startingDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public int getNumberOfDept() {
		return numberOfDept;
	}

	public void setNumberOfDept(int numberOfDept) {
		this.numberOfDept = numberOfDept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public java.util.Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(java.util.Date startingDate) {
		this.startingDate = startingDate;
	}

	@Override
	public String toString() {
		return "College name=" + name + ", website=" + website + ", mobile=" + mobile + ", founder=" + founder
				+ ", numberOfDept=" + numberOfDept + ", location=" + location + ", startingDate=" + startingDate;
	}
	
	
	

}
