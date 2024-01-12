package ecommerce.model;

import java.util.*;

public class Customer {

	String name;
	Date dob;
	String email;
	String pass;
	String phno;
	String scope;
	
	public Customer() {}
	
	public Customer(String name, Date dob, String email, String pass, String phno,String scope) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.pass = pass;
		this.phno = phno;
		this.scope=scope;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", dob=" + dob + ", email=" + email + ", pass=" + pass + ", phno=" + phno
				+ ", scope=" + scope + "]";
	}
	
	
	
	
}
