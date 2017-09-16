package quanlisach;

public class Computer {
	private Maker computerMaker;
	private Date productionDay;
	private double price;
	private Date warrantyPeriod;
	
	public Maker getComputerMaker() {
		return computerMaker;
	}
	public void setComputerMaker(Maker computerMaker) {
		this.computerMaker = computerMaker;
	}
	public Date getProductionDay() {
		return productionDay;
	}
	public void setProductionDay(Date productionDay) {
		this.productionDay = productionDay;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(Date warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	
	public Computer(){
		this.computerMaker = new Maker();
		this.productionDay = new Date();
		this.warrantyPeriod = new Date();
	}
	
	public Computer(Maker computerMaker, Date productionDay, double price, Date warrantyPeriod){
		this.setComputerMaker(computerMaker);
		this.setProductionDay(productionDay);
		this.setPrice(price);
		this.setWarrantyPeriod(warrantyPeriod);
	}
	
	public boolean isCheaper(Computer anotherComputer){
		return this.getPrice() > anotherComputer.getPrice();
	}
	
	public String getCountryName(){
		return this.getComputerMaker().getCountry();
	}
}
