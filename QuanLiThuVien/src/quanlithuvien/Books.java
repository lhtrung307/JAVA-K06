package quanlithuvien;

public class Books {
	private int iD;
	private String name;
	private long price;
	
	public Books(){}
	
	
	public Books(int iD, String name, long price) {
		this.iD = iD;
		this.name = name;
		this.price = price;
	}
	
	public int getID() {
		return iD;
	}
	public void setID(int iD) {
		iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
}
