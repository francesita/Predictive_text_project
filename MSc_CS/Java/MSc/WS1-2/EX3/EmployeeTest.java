
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    //  I am using Prof. Manfred's Junit test as a template for making my own. I understand that double values do not behave the same way in the assertEquals as with ints and strings.

	private Employee john;
	private Employee joana;
    private final static double TOLERANCE  = 0.0001; //tolerance helps the comparison of double values because they may not be exact, due to round-off errors and representation errors 
    //  Stack Overflow helped me understand the use of TOLERANCE as well as the use of DELTA https://stackoverflow.com/questions/5686755/meaning-of-epsilon-argument-of-assertequals-for-double-values 

	@Before
	public void setup() {
		john = new Employee("John Doe",2400, 20);
		joana = new Employee("Joana Doe", 7000, 45);
	}

	//testing getters for john
	@Test
	public void test1() {
		String expectedName = "John Doe";
		double expectedTaxRate = 20;
		double expectedGrossSalary = 2400;
		double expectedNetSalary = 1920;

		String actualName = john.getName();
		double actualTaxRate = john.getTaxRate();
		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	// testing getters forJoana
	@Test
	public void test2() {
		String expectedName = "Joana Doe";
		double expectedTaxRate = 45;
		double expectedGrossSalary =7000;
		double expectedNetSalary = 3850;

		String actualName = joana.getName();
		double actualTaxRate = joana.getTaxRate(); 
		double actualGrossSalary = joana.getMonthlyGrossSalary();
		double actualNetSalary = joana.getMonthlyNetSalary();

		assertEquals(expectedName, actualName);
		assertEquals(expectedTaxRate, actualTaxRate, TOLERANCE);
		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);
		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing john's salaries after
	//changing tax rate
	@Test
	public void test3() {

		john.setTaxRate(0);

		double expectedGrossSalary = 2400;
		double expectedNetSalary = 2400;

		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);

		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing mary's salaries after
	//changing tax rate
	@Test
	public void test4() {

		joana.setTaxRate(20);

		double expectedGrossSalary = 7000;
		double expectedNetSalary = 5600;

		double actualGrossSalary = joana.getMonthlyGrossSalary();
		double actualNetSalary = joana.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, TOLERANCE);

		assertEquals(expectedNetSalary, actualNetSalary, TOLERANCE);
	}

	//testing john's salary after increase in salary
	@Test
	public void test5() {
		
	    john.increaseSalary(1);
		
		double expectedGrossSalary = 2424;
		double expectedNetSalary = 1939.2;

		double actualGrossSalary = john.getMonthlyGrossSalary();
		double actualNetSalary = john.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
	
	//testing joana's salary increase by rate of 3
	@Test
	public void test6() {

		joana.increaseSalary(3);
		
		double expectedGrossSalary = 7210;
		double expectedNetSalary = 3965.5;

		double actualGrossSalary = joana.getMonthlyGrossSalary();
		double actualNetSalary = joana.getMonthlyNetSalary();

		assertEquals(expectedGrossSalary, actualGrossSalary, 0.001);

		assertEquals(expectedNetSalary, actualNetSalary, 0.001);
	}
}

