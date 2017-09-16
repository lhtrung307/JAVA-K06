package quanlithuvien;

import java.util.Date;

public class Customers extends Account{
	private int cID;
	private boolean isVip;
	private Date registerDate;
	private Rent[] rentBook;
	
	public Customers(int cID, boolean isVip, Date registerDate, Rent[] rentBook) {
		super();
		this.cID = cID;
		this.isVip = isVip;
		this.registerDate = registerDate;
		this.rentBook = rentBook;
	}
	
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Rent[] getRentBook() {
		return rentBook;
	}
	public void setRentBook(Rent[] rentBook) {
		this.rentBook = rentBook;
	}
	
	public void addRentBook(Rent rentCurrBook){
		
	}
	
	public  boolean giveRentBook(Rent rentCurrBook){
		
	}
	
	public void giveAllBook(){
		
	}
}
