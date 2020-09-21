package EX3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 *  Junit tests taken from Manfred and changed accordingly 
 *  All classes passed public tests and my tests
 *
 *
 */

public class BankAccountUserTests {

	private BankAccountAdministrator flo;
	private Customer customerFrances, customerMaria;
	private BankAccount bankAccountFrances, bankAccountMaria;
	private BankAccountStandardUser Frances, Maria;

	@Before
	public void setUp() {
		flo = new BankAccountAdministrator("Flo", "ilikestuff");
		customerFrances = new Customer("Frances", "f", "PuertoRico", "787");
		customerMaria = new Customer("Maria", "m", "FL", "954");
		bankAccountFrances = new BankAccount(customerFrances, "luff");
		bankAccountMaria = new BankAccount(customerMaria, "flan");
		Frances = new BankAccountStandardUser("Frances", "luffstuff", bankAccountFrances);
		Maria = new BankAccountStandardUser("Maria", "azucar", bankAccountMaria);
	}

	// Frances logs in successfully and transfers
	// some money to Maria's bank account.
	@Test
	public void test1() {
		Frances.login("luffstuff");

		// expected number of failed login attempts is 0
		int expectedLoginAttempts = 0;
		int actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Frances.getLoggedIn());

                // transfer fails because of insufficient funds
		Frances.transferMoney(bankAccountMaria, 150, "luff");

		double expectedBalance = 100;
		double actualBalance = Maria.getBankAccount().getBalance();

		assertEquals(expectedBalance, actualBalance, 0.00001);

                // transfer succeeds
		Frances.transferMoney(bankAccountMaria, 10, "luff");
		double expectedBalanceFrances = 90;
		double actualBalanceFrances = Frances.getBankAccount().getBalance();
		assertEquals(expectedBalanceFrances, actualBalanceFrances, 0.00001);
		double expectedBalanceMaria = 110;
		double actualBalanceMaria = Maria.getBankAccount().getBalance();
		assertEquals(expectedBalanceMaria, actualBalanceMaria, 0.00001);
	}

	

	// Maria makes 1 failed login attempts and
	// then logs in using the correct password
    // attempts set to zero
	@Test
	public void test2() {

		// First failed login attempt
		Maria.login("azukar");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = Maria.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(Maria.getLoggedIn());


		// Second attempt is successful
		Maria.login("azucar");
		expectedLoginAttempts = 0;
		actualLoginAttempts = Maria.getLoginAttempts();
		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Maria.getLoggedIn());

	}

	// Frances makes 3 failed login attempts and
	// admin resets Frances's password and Frances's login attempts to 0.
	@Test
	public void test3() {

		// First failed login attempt
		Frances.login("wRONG!");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(Frances.getLoggedIn());

		// Second failed login attempt
		Frances.login("wrong");
		expectedLoginAttempts = 2;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());

		// Third failed login attempt
		Frances.login("wrong");
		expectedLoginAttempts = 3;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());

		// Administrator resets Frances's password
		flo.login("ilikestuff");
		flo.addUser(Frances);
		flo.resetAccount(Frances, "luffandstuff");

		// Frances logs in successfully using the
		// new password
		Frances.login("luffandstuff");

		expectedLoginAttempts = 0;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(Frances.getLoggedIn());

	}

	// Frances makes 4 failed login attempts and
	// calls admin. Admin forgets to log in and tries
	// to reset Frances's password.
	@Test
	public void test4() {

		// First failed login attempt
		Frances.login("looff");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(Frances.getLoggedIn());

		// Second failed login attempt
		Frances.login("luffStuff");
		expectedLoginAttempts = 2;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());

		// Third failed login attempt
		Frances.login("looffstoof");
		expectedLoginAttempts = 3;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());

		// Fourth failed login attempt
		Frances.login("lofoadf");
		// Failed login attempts remain 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());

		// Administrator tries to reset Frances's password
		// without logging in
		flo.addUser(Frances);
		flo.resetAccount(Frances, "luffandstuff300");

		// Frances tries to log in again
		Frances.login("luffandstuff300");

		// login attempts still 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = Frances.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(Frances.getLoggedIn());
	}

}
