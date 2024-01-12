package ecommerce.model;

public class Product {
	int pid;
	String pname;
	String pdesc;
	int pqty;
	double pprice;
	
	public Product() {
		
	}
	
	public Product(int pid, String pname, String pdesc, int pqty, double pprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pqty = pqty;
		this.pprice = pprice;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", pqty=" + pqty + ", pprice=" + pprice
				+ "]";
	}
	
	
	

}
