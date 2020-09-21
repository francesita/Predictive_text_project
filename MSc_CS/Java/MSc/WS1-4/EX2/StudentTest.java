import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class StudentTest{
	
	public static final double TOLERANCE = 0.0001;
	
	// testing getters 
	@Test
	public void test1() {
        int[]   francesMarks = {90,57,50,90,50,90,-1,50,12,90,50,40,100,-1};
        Student frances = new Student("123455", francesMarks);
        
        String expectedRegistrationNumber = "123455";
        int[] expectedMarks = {90,57,50,90,50,90,-1,50,12,90,50,40,100,-1};;
        
        String actualRegistrationNumber = frances.getRegistrationNumber();
        int[] actualMarks = frances.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}
	
	// testing setters
	@Test
	public void test2() {
        int[]   francesMarks = {90,57,50,90,50,90,-1,50,12,90,50,40,100,-1};
        Student frances = new Student("123455", francesMarks);
        
        frances.setRegistrationNumber("554321");
        frances.setAssignmentMark(14, 90);
        
        String expectedRegistrationNumber = "554321";
        int[] expectedMarks = {90,57,50,90,50,90,-1,50,12,90,50,40,100,90};
        
        String actualRegistrationNumber = frances.getRegistrationNumber();
        int[] actualMarks = frances.getMarks();
        
        assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
        assertTrue(Arrays.equals(expectedMarks, actualMarks));     
	}
		
	// testing totalMark and passed for different students (Student objects)
	@Test
	public void test3() {
		int[] francesMarks = {90,57,50,90,50,90,-1,50,12,90,50,40,100,100};
        Student frances = new Student("1111110", francesMarks);

        int[] marysMarks = {-1,60,65,60,-1,90,55,66,60,15,65,45,100,-1};
        Student mary = new Student("1111111", marysMarks);
        
        int[] melissasMarks = {50,60,-1,60,65,70,55,66,60,73,65,45,68,54};
        Student melissa = new Student("1111112", melissasMarks );

        
        double expectedTotalMarkFrances = 92.3;
        double expectedTotalMarkMary = -1;
        double expectedTotalMarkMelissa = 56.3;
        
        double actualTotalMarkFrances = frances.totalMark();
        double actualTotalMarkMary = mary.totalMark();
        double actualTotalMarkMelissa = melissa.totalMark();
        
        
        assertEquals(expectedTotalMarkFrances, actualTotalMarkFrances, TOLERANCE);
        assertEquals(expectedTotalMarkMary, actualTotalMarkMary, TOLERANCE);
        assertEquals(expectedTotalMarkMelissa, actualTotalMarkMelissa, TOLERANCE);
       
        
        assertTrue(frances.passed());
        assertFalse(mary.passed());
        assertTrue(melissa.passed());
       
	}
	
	
	
	// testing insufficient marks
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		
        int[] eddysMarks = {50,60,-1,60,65,70,55,66,60,73,65,45,68,-1};
        Student eddy = new Student("1111114", eddysMarks);
        
        // exception should be thrown
        eddy.passed();
		
	}
	
}
