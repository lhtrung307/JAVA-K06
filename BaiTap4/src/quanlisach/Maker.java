package quanlisach;

public class Maker {
	private String name;
	private String country;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Maker(){}
	
	public Maker(String name, String country){
		this.setName(name);
		this.setCountry(country);
	}
}
