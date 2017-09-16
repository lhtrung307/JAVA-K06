package test;

import org.junit.Test;

import quanlisach.Author;
import quanlisach.Date;

public class TestAuthor {

	@Test
	public void test() {
		Date date = new Date(10, 10, 1997);
		Author author = new Author("Trung Dep Trai", date);
		
	}

}
