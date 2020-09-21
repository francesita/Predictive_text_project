package shop;
/**
 * This class extends Product class. 
 * Class is to make instances of products that have a discount if min quantity of product bought
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2018/12/05
 *
 */

public class MultiBuyProduct extends Product {

		private int minDiscountedQuantity;
		private int discountPercent;
		
		/**
		 * Constructor for products that have discounts for mult. bought
		 * @param name is the name of product as String
		 * @param price	is the regular price of the product as double
		 * @param quantity is the quantity of the product chosen as integer
		 * @param minDiscountedQuantity the minimum quantity product must have to apply discount
		 * @param discountPercent is the discount product will have as int
		 */
		
		public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountPercent) {
		super(name, price, quantity);
		this.minDiscountedQuantity = minDiscountedQuantity;
		this.discountPercent = discountPercent;		
		}
		
		/**
		 * Getter for discount percent
		 * @return discount percent as integer
		 */
	
		public int getDiscountPercent() {
			return discountPercent;
		}
		
		/**
		 * Setter for discount percent. it gives value of discount percent
		 * @param newDiscountPercent is the new discount percent value that is changed as int
		 */
		
		public void setDiscountPercent(int newDiscountPercent) {
			discountPercent = newDiscountPercent;
		}
		
		/**
		 * getter for minimum discounted quantity
		 * @return minDiscountedQuantity as int
		 */
		
		public int getMinDiscountedQuantity() {
			return minDiscountedQuantity;
		}
		
		/** 
		 * setter for minimum discounted quantity. it sets the value of minDiscountedVariable
		 * @param newMinDiscountedQuantity is new value of minDiscountedQuantity 
		 */
		
		public void setMinDiscountedQuantity(int newMinDiscountedQuantity) {
			minDiscountedQuantity = newMinDiscountedQuantity;
		}
		
		/**
		 * getter for the price. Overrides getPrice method from Product class
		 * return the price for item in superclass
		 */
		
		@Override
		public double getPrice() {
			return super.getPrice();
		}
		
		/**
		 * This method calculates the amount that is discounted
		 * @return discount amount as double
		 */
		
		public double discountAmount() {
			if (getQuantity() >= getMinDiscountedQuantity() ){
				return  getPrice() * getDiscountPercent() * .01 * getQuantity(); 
			}else {
				return 0.;
			}
		}
			
		/**
		 * overrides superclass method. IF quantity conditions met then  discount applied
		 * otherwise not. 
		 */

		@Override
		public double getTotalPrice() {
			if (getQuantity() >= getMinDiscountedQuantity() ){
				return super.getTotalPrice() - discountAmount();
			}else {
				return super.getTotalPrice();
		}
	}
}

