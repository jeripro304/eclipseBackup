package ecommerce.model;

public class UserCart {

	private int pid;
	private String pname;
	private String pdesc;
	private String price;
	private int pqty;
	
	
	public UserCart() {
	}


	public UserCart(int pid, String pname, String pdesc, String price,int pqty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.price = price;
		this.pqty=pqty;
	}


	public int getPqty() {
		return pqty;
	}


	public void setPqty(int pqty) {
		this.pqty = pqty;
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


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "UserCart [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", price=" + price + "]";
	}

	

	
	
	
}
