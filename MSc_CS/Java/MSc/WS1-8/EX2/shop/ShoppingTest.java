package shop;

import static org.junit.Assert.assertEquals;



import org.junit.Before;
import org.junit.Test;

public class ShoppingTest {
	
	public static final double TOLERANCE = 0.00001;
	
	private Product p1, p2, p3, p4;
	private ShoppingCart cart1;
	private MultiBuyProduct mp1, mp2, mp3;
	
	@Before
	public void setup() {
	 p1 = new Product("Milk", 1.06, 1);
	 p2 = new Product("Apples", 0.49, 1);
	 p3 = new Product("Milk", 1.06, 4);
	 p4 = new Product("Oranges", 1.06, 3);
	
	 cart1 = new ShoppingCart();
	
	 mp1 = new MultiBuyProduct("Milk" , 1.06, 4, 2, 10);
	 mp2 = new MultiBuyProduct("Tomato" , 0.5, 20, 10, 3);
	 mp3 = new MultiBuyProduct("Oranges", 1.00, 2, 5, 10);
	
	}
	/**
	 * test1 will test if products that have the same name and price
	 * have their quantities increased
	 */
	@Test
	public void test1() {
		 cart1.add(p1);
	 	 cart1.add(p2);
	 	 cart1.add(p3);
	     cart1.add(p4);
	     
	    int expectedCartSize = 3;
		int actualCartSize = cart1.getCart().size();
		int expectedQuantity = 5;
		int actualQuantity = cart1.getCart().get(0).getQuantity();
		
		assertEquals(expectedCartSize, actualCartSize);	     
		assertEquals(expectedQuantity, actualQuantity);	     
	}

	/**
	 * test2 will test whether multibuy products are added onto the shopping cart
	 * it will also test if it still adds items if they have same name and same price
	 * lastly, it will test that it does not apply discount if min quantity requirement not met
	 */
	@Test
	public void test2() {
		cart1.add(p1);
	 	cart1.add(p2);
	 	cart1.add(p3);
	    cart1.add(p4);
	    
		cart1.add(mp1);
	 	cart1.add(mp2);
	 	cart1.add(mp3);
	  
	 	int expectedCartSize = 6;
		int actualCartSize = cart1.getCart().size();
		
		double expectedDiscount1 = 0.424;
		double actualDiscount1 = (((MultiBuyProduct)cart1.getCart().get(3)).discountAmount());
		
		double expectedDiscount2 = 0.;
		double actualDiscount2 = (((MultiBuyProduct)cart1.getCart().get(5)).discountAmount());
		
		assertEquals(expectedCartSize, actualCartSize);
		assertEquals(expectedDiscount1, actualDiscount1, TOLERANCE);
		assertEquals(expectedDiscount2, actualDiscount2, TOLERANCE);
	}
	/**
	 * 	This test checks if totals are as expected for items individually and for the products
	 * 	checks the total for the whole shopping cart
	 * 	It also checks the total for multibuy class for items with discount and without
	 */
	@Test
	public void test3() {
		cart1.add(p1);
	 	cart1.add(p2);
	 	cart1.add(p3);
	    cart1.add(p4);
	    
		cart1.add(mp1);
	 	cart1.add(mp2);
	 	cart1.add(mp3);
	 	
	 	double expectedTotalPrice = 24.49;
		double actualTotalPrice = cart1.checkOutTotal() ;
		
		double expectedProductTotal = 5.3;
		double actualProductTotal= cart1.getCart().get(0).getTotalPrice();
		
		double expectedMultiProducTotal1 = 3.816;
		double actualMultiProductTotal1 = cart1.getCart().get(3).getTotalPrice();
		
		double expectedMultiProductTotal2 = 2.0;
		double actualMultiProductTotal2 = cart1.getCart().get(5).getTotalPrice();
		
		assertEquals(expectedTotalPrice, actualTotalPrice, TOLERANCE);
		assertEquals(expectedProductTotal, actualProductTotal, TOLERANCE);
		assertEquals(expectedMultiProducTotal1, actualMultiProductTotal1, TOLERANCE);
		assertEquals(expectedMultiProductTotal2, actualMultiProductTotal2, TOLERANCE);
	}
}

