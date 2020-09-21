import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	
	private BankAccount John;
	private BankAccount Joana;
	
	@Before
	public void setup() {
		
		John = new BankAccount(54, 100, 20);
		Joana = new BankAccount(56,700, 90);
		
	}
	
	// Testing all the getters for class BankAccount
 
	@Test
	public void test1() {
		int expected = 54;
		int actual = John.getAccountNumber();
		assertEquals(expected, actual);
	}

	
	@Test
	public void test2() {
		int expected = 80;
		int actual = John.getBalance();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test3() {
		int expected = 20;
		int actual = John.getSetupFee();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test4() {
		int expected = 56;
		int actual = Joana.getAccountNumber();
		assertEquals(expected, actual);
	}

    @Test
    public void test5() {
        int expected = 610;
        int actual = Joana.getBalance();
        assertEquals(expected, actual);
    }
	// testing all setters for class BankAccount

	@Test
	public void test6() {
		John.setBalance(2000);
		int expected = 2000;
		int actual = John.getBalance();
		assertEquals(expected, actual);
	}
	

	@Test
	public void test7() {
		Joana.setBalance(0);
		int expected = 0;
		int actual = Joana.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for negative balance according to Manfred's test since I did not think of it and I think it is important to test many cases.
	@Test
	public void test8() {
		John = new BankAccount(54, 30, 50);
		int expected = -20;
		int actual = John.getBalance();
		assertEquals(expected, actual);
	}
	

	@Test
	public void test9() {
	    John = new BankAccount(54, 100, 100);
		int expected = 0;
		int actual = John.getBalance();
		assertEquals(expected, actual);
	}

	@Test
	public void test10() {
	    Joana = new BankAccount(56, 10, 10);
		int expected = 0;
		int actual = Joana.getBalance();
		assertEquals(expected, actual);
	}

// I tried to test construction with negative fee as per Manfred's example, but I am not able to create an acceptable test
   
}
