package EX2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


/**
 *  Junit tests taken from Manfred and changed accordingly 
 *  All classes passed public tests and my tests
 *
 */


public class MeasurableTests {

	public static final double TOLERANCE = 0.00001;

	private Measurable invoice1, invoice2, invoice3;
	private Measurable patient1, patient2, patient3;

	@Before
	public void setUp() {
		invoice1 = new Invoice("01234567", "90-23-14", 0);
		invoice2 = new Invoice("89101112", "227-6-89", 876.00);
		invoice3 = new Invoice("13141516", "66-5-62", 1580.43);

		patient1 = new Patient("Frances", 27, 56.5);
		patient2 = new Patient("Maureen", 24, 61.6);
		patient3 = new Patient("Estephania", 58, 40.3);
	}

	// testing max on a list of invoices
	@Test
	public void test1() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);


		double expectedMax = 1580.43;
		double actualMax = Statistics.maximum(invoiceList);

		assertEquals(expectedMax, actualMax, TOLERANCE);

	}

	// testing max on a list of patients
	@Test
	public void test2() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);


		double expectedMax = 61.6;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
	}

	// testing average on a list of invoices
	@Test
	public void test3() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);


		double expectedAvg = 818.810;
		double actualAvg = Statistics.average(invoiceList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}

	// testing average on a list of patients
	@Test
	public void test4() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);


		double expectedAvg = 52.79999;
		double actualAvg = Statistics.average(patientList);

		assertEquals(expectedAvg, actualAvg, TOLERANCE);
	}

	// testing standard deviation on a list of invoices
	@Test
	public void test5() {
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice1);
		invoiceList.add(invoice2);
		invoiceList.add(invoice3);


		double expectedStd = 791.7656;
		double actualStd = Statistics.standardDeviation(invoiceList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}

	// testing standard deviation on a list of patients
	@Test
	public void test6() {
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient1);
		patientList.add(patient2);
		patientList.add(patient3);


		double expectedStd = 11.1216;
		double actualStd = Statistics.standardDeviation(patientList);

		assertEquals(expectedStd, actualStd, TOLERANCE);
	}


	@Test
	public void test7() {
		Measurable invoice6 = new Invoice("8934232", "90-3-94", 3000);
		ArrayList<Measurable> invoiceList = new ArrayList<>();
		invoiceList.add(invoice6);
		double expectedMax = 3000.0;
		double actualMax = Statistics.maximum(invoiceList);
		
		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 3000.0;
		double actualAvg = Statistics.average(invoiceList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = Double.NaN;
		double actualStd = Statistics.standardDeviation(invoiceList);
		assertEquals(expectedStd, actualStd, TOLERANCE);
	}


	@Test
	public void test8() {
		Measurable patient4 = new Patient("Kevin", 24, 68);
		ArrayList<Measurable> patientList = new ArrayList<>();
		patientList.add(patient4);

		double expectedMax = 68;
		double actualMax = Statistics.maximum(patientList);

		assertEquals(expectedMax, actualMax, TOLERANCE);
		
		double expectedAvg = 68;
		double actualAvg = Statistics.average(patientList);
		assertEquals(expectedAvg, actualAvg, TOLERANCE);

		double expectedStd = Double.NaN;
		double actualStd = Statistics.standardDeviation(patientList);
		assertEquals(expectedStd, actualStd, TOLERANCE);	
	}
	
}
