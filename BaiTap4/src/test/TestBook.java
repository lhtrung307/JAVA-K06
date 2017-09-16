package test;

import static org.junit.Assert.*;

import org.junit.Test;

import quanlisach.Author;
import quanlisach.Book;
import quanlisach.Date;

public class TestBook {

	@Test
	public void test() {
		Date date = new Date(10, 10, 1997);
		Author author = new Author("Trung Dep Trai", date);
		Book book = new Book("Lam sao de dep trai nhu Trung", 100000, 300, 2017, author);
		book.printName();
		
		Book book1 = new Book("Lam sao de thanh cong nhu Trung", 200000, 290, 2016, author);
		Book book2 = new Book("Lam sao de tu tin nhu Trung", 150000, 250, 2016, author);
		
		assertFalse(book1.isSamePublishYear(book2));
		assertTrue(book1.isSamePublishYear(book2));
		
		assertEquals(100000, book.salePrice(30), 0,001);
	}

}
