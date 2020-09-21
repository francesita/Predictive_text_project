import static org.junit.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
	
	public static final double TOLERANCE = 0.00001;
	
	private MonthlyEmployee mp1, mp2, mp3;
	private Company hourlyCentral, monthlyCentral;
	private HourlyEmployee h1, h2, h3;
	
	@Before
	public void setup() {
	 mp1 = new MonthlyEmployee("Jean", "Rabet", "01234", 1800);
	 mp2 = new MonthlyEmployee("Frances", "Leon", "05678" , 1000);
	 mp3 = new MonthlyEmployee("Jeff", "Lawrence", "34525", 50000);

	
	 hourlyCentral = new Company();
	 monthlyCentral = new Company();
	
	 h1 = new HourlyEmployee("Maria", "Olivieri", "09123", 10.50);
	 h2 = new HourlyEmployee("Yesenia", "Lopez", "08673", 15.50);
	 h3 = new HourlyEmployee("Yelina", "Romero", "07453", 20.50);
	}
	/**
	 * test1 will test if hourly employees are added to the list properly
	 * and to see if it prevents from adding the same employee twice
	 */
	@Test
	public void test1() {
		 hourlyCentral.add(h1);
	 	 hourlyCentral.add(h2);
	 	 hourlyCentral.add(h3);
	 	 hourlyCentral.add(h3);
	 	 
	 	 hourlyCentral.add(mp1);
	 	 hourlyCentral.add(mp2);
	 	 hourlyCentral.add(mp3);
	 	 hourlyCentral.add(mp2);
	 
	 	 int expectedListSize = 6;
		 int actualListSize = hourlyCentral.getEmployees().size();
		
		 assertEquals(expectedListSize, actualListSize);	        
	}

	/**
	 * test2 will test whether salaries of hourly employees
	 * are increased according to the rates. It tests the increaseSalaries method
	 * in Company, and by extension the increase salary methods in MonthlyEmployee and
	 * HourlyEmployee. Test 2 tests for h1
	 *  
	 */
	@Test
	public void test2() {
	 	
	 	 hourlyCentral.add(h1);
	 	 hourlyCentral.add(h2);
	 	 
	 	 hourlyCentral.increaseSalaries(.02);
	 	 
		double expectedSalaryH1_1 = 10.71;
		double actualSalaryH1_1 =(((HourlyEmployee)hourlyCentral.getEmployees().get(0)).getHourlySalary());
		
		assertEquals(expectedSalaryH1_1, actualSalaryH1_1, TOLERANCE);
	}
	
	/**
	 * test3 will test whether salaries of hourly employees
	 * are increased according to the rates. It tests the increaseSalaries method
	 * in Company, and by extension the increase salary methods in MonthlyEmployee and
	 * HourlyEmployee. Test 3 tests for h1
	 *  
	 */
	@Test
	public void test3() {
	 	
	 	 hourlyCentral.add(h1);
	 	 hourlyCentral.add(h2);
	 	 
	 	hourlyCentral.increaseSalaries(.10);
	 	
		double expectedSalaryH1_2 = 11.55;
		double actualSalaryH1_2 = (((HourlyEmployee)hourlyCentral.getEmployees().get(0)).getHourlySalary());
		
		assertEquals(expectedSalaryH1_2, actualSalaryH1_2, TOLERANCE);
	}
	
	/**
	 * test4 will test whether salaries of hourly employees increase when done back to back
	 * It tests the increaseSalaries method in Company, 
	 * and by extension the increase salary methods in MonthlyEmployee and
	 * HourlyEmployee. Test 3 tests for h1
	 *  
	 */
	
	@Test
	public void test5() {
		 hourlyCentral.add(h1);
	 	 hourlyCentral.add(h2);
	 	 hourlyCentral.add(h3);	 	 
	 	 
		 hourlyCentral.increaseSalaries(.02);
	 
	 	 
		double expectedSalaryH2_1 = 15.81;
		double actualSalaryH2_1 = ((HourlyEmployee)hourlyCentral.getEmployees().get(1)).getHourlySalary();
		
		 hourlyCentral.increaseSalaries(.10);

		double expectedSalaryH2_2 = 17.391;
		double actualSalaryH2_2 = ((HourlyEmployee)hourlyCentral.getEmployees().get(1)).getHourlySalary();
		
	 	 hourlyCentral.increaseSalaries(.05);
	 	 
		double expectedSalaryH2_3 = 18.26055;
		double actualSalaryH2_3 = ((HourlyEmployee)hourlyCentral.getEmployees().get(1)).getHourlySalary();
		
		assertEquals(expectedSalaryH2_1, actualSalaryH2_1, TOLERANCE);
		assertEquals(expectedSalaryH2_2, actualSalaryH2_2, TOLERANCE);
		assertEquals(expectedSalaryH2_3, actualSalaryH2_3, TOLERANCE);
	}
	
	@Test
	public void test6() {
	 	 
	 	 monthlyCentral.add(mp1);
	 	 monthlyCentral.add(mp2);
	 	 monthlyCentral.add(mp3);
	 	 
	 	 
		 monthlyCentral.increaseSalaries(.02);	 
	 	 
		double expectedSalaryM2_1 = 1836.;
		double actualSalaryM2_1 = (((MonthlyEmployee)monthlyCentral.getEmployees().get(0)).getMonthlySalary());
		
		 monthlyCentral.increaseSalaries(.10);

		double expectedSalaryM2_2 = 2019.6;
		double actualSalaryM2_2 = (((MonthlyEmployee)monthlyCentral.getEmployees().get(0)).getMonthlySalary());

	 	 monthlyCentral.increaseSalaries(.05);
	 	 
		double expectedSalaryM2_3 = 2120.58;
		double actualSalaryM2_3 = (((MonthlyEmployee)monthlyCentral.getEmployees().get(0)).getMonthlySalary());
		
		assertEquals(expectedSalaryM2_1, actualSalaryM2_1, TOLERANCE);
		assertEquals(expectedSalaryM2_2, actualSalaryM2_2, TOLERANCE);
		assertEquals(expectedSalaryM2_3, actualSalaryM2_3, TOLERANCE);
	}
	
}

