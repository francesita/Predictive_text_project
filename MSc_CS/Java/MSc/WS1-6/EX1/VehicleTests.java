import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *  Junit tests taken from Manfred and changed accordingly 
 *  All classes passed public tests and my tests
 *
 */

public class VehicleTests {
	public static final double TOLERANCE = 0.00001;
	private Vehicle vehicle1, vehicle2;
	private Bus bus;
	
	@Before
	public void setUp() {
		
		vehicle1 = new Vehicle(30,12);
		bus = new Bus(250,150,34.5);
		vehicle2 = new Bus(330,200,20);
	}

	//testing getters of vehicle1
	@Test
	public void test1() {
		
		int expectedNumOfPassengers = 30;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 12;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing getters of bus
	@Test
	public void test2() {
		
		int expectedNumOfPassengers = 250;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 150;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		double expectedFuelCons = 34.5;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	//testing setters of vehicle1
	@Test
	public void test3() {
		
		vehicle1.setPassengerNumber(43);
		int expectedNumOfPassengers = 43;
		int actualNumOfPassengers = vehicle1.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle1.setMaxSpeed(140);
		int expectedMaxSpeed = 140;
		int actualMaxSpeed = vehicle1.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing setters of bus
	@Test
	public void test4() {
		
		bus.setPassengerNumber(200);
		int expectedNumOfPassengers = 200;
		int actualNumOfPassengers = bus.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		bus.setMaxSpeed(110);
		int expectedMaxSpeed = 110;
		int actualMaxSpeed = bus.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
		
		
		bus.setFuelConsumption(47.2);
		double expectedFuelCons = 47.2;
		double actualFuelCons = bus.getFuelConsumption();
		assertEquals(expectedFuelCons,actualFuelCons,TOLERANCE);
	}
	
	
	//testing getters of vehicle2
	@Test
	public void test5() {
		
		int expectedNumOfPassengers = 330;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		int expectedMaxSpeed = 200;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
	
	//testing setters of vehicle2
	@Test
	public void test6() {
		
		vehicle2.setPassengerNumber(180);
		int expectedNumOfPassengers = 180;
		int actualNumOfPassengers = vehicle2.getPassengerNumber();
		assertEquals(expectedNumOfPassengers,actualNumOfPassengers);
	
		vehicle2.setMaxSpeed(190);
		int expectedMaxSpeed = 190;
		int actualMaxSpeed = vehicle2.getMaxSpeed();
		assertEquals(expectedMaxSpeed,actualMaxSpeed);
	}
}
