package quanlisach;

public class Book {
	private String name;
	private double price;
	private int pages;
	private int publishYear;
	private Author author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book() {
	}

	public Book(String name, int price, int pages, int publishYear, Author author) {
		this.setName(name);
		this.setPrice(price);
		this.setPages(pages);
		this.setPublishYear(publishYear);
		this.setAuthor(author);
	}

	public void printName() {
		System.out.println("Book's name: " + this.getName());
	}

	public boolean isSamePublishYear(Book anotherBook) {
		return this.getPublishYear() == anotherBook.getPublishYear();
	}

	public double salePrice(double percent) {
		return (this.getPrice() - this.getPrice() * percent / 100);
	}

	public String toString() {
		return String.format("Book's name: %s, price: %f, pages: %d, publish year: %d " + this.getAuthor().toString(), this.getName(), this.getPrice(), this.getPages(), this.getPublishYear());
	}
	
	public static void main(String[] args) {
		
	}
}