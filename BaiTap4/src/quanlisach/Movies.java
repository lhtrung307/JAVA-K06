package quanlisach;



public class Movies {
	private String name;
	private int yearOfProduction;
	private Maker filmMaker;
	private double ticketPrice;
	private Date releaseDay;
	
	public Movies(){
		filmMaker = new Maker();
		releaseDay = new Date();
	}
	
	public Movies(String name, int yearOfProduction, Maker filmMaker, double ticketPrice, Date releaseDay){
		this.setName(name);
		this.setYearOfProduction(yearOfProduction);
		this.setFilmMaker(filmMaker);
		this.setTicketPrice(ticketPrice);
		this.setReleaseDay(releaseDay);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public Maker getFilmMaker() {
		return filmMaker;
	}

	public void setFilmMaker(Maker filmMaker) {
		this.filmMaker = filmMaker;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Date getReleaseDay() {
		return releaseDay;
	}

	public void setReleaseDay(Date releaseDay) {
		this.releaseDay = releaseDay;
	}
	
	public boolean isTicketCheaper(Movies anotherMovie){
		return this.getTicketPrice() > anotherMovie.getTicketPrice();
	}
	
	public String getFilmMakerName(){
		return this.getFilmMaker().getName();
	}
	
	public double salePrice(double percent){
		return this.getTicketPrice() * (1 - percent/100);
	}
	
}
