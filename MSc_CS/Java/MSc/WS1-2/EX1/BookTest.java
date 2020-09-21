import static org.junit.Assert.assertEquals;

import org.junit.Before;    //  for before - set up values
import org.junit.Test;  //  for the test - once the new objects are "created"

public class BookTest {
	
	private Book b1;
	private Book b2;
	
	@Before
	public void setup() {
		b1 = new Book("Crime and Punishment", 1866, "978-0141192802");
		b2 = new Book("One Hundred Years of Solitude", 1967, "978-0141184999");
	}
	
    //  Testing all the getters to see if their values returned

	@Test
	public void test1() {
		String expected = "Crime and Punishment"; //    this is where expected value is placed
		String actual = b1.getTitle();  //  this is where actural value b1 will return
		assertEquals(expected, actual); //  this is where the two objects are measured for equality
	}
	
	@Test   //  Will test each part as above for the new Book object b1

	public void test2() {
		int expected = 1866;
		int actual = b1.getYear();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		String expected = "978-0141192802";
		String actual = b1.getIsbn();
		assertEquals(expected, actual);
	}
	
	// testing all the setters for title, year and isbn

	@Test
	public void test4() {
		b1.setTitle("Crime and Punishment");
		String expected = "Crime and Punishment";
		String actual = b1.getTitle(); // we need to be sure to put getter here so we see if value set correctly
		assertEquals(expected, actual);
	}

    //  Now we do the same tests as above for b2  
	
	@Test
	public void test5() {
		String expected = "One Hundred Years of Solitude";
		String actual = b2.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test6() {
		int expected = 1967;
		int actual = b2.getYear();
		assertEquals(expected, actual);
	}
	
	// testing getter for ISBN
	@Test
	public void test7() {
		String expected = "978-0141184999";
		String actual = b2.getIsbn();
		assertEquals(expected, actual);
	}
}
