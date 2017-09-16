package quanlisach;

public class Author {

	private String name;
	private Date dOB;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getdOB() {
		return dOB;
	}

	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	public Author() {
		
	}

	public Author(String name, Date dOB) {
		this.name = name;
		this.dOB = dOB;
	}

	public String toString() {
		return String.format("Author's name: %s, day of birth: " + this.getdOB().toString(), this.getName());
	}

}