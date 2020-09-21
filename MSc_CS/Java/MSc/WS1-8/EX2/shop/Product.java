package shop;
/**
 * 	This class is a product. It shows the price and quantity of a product
 * 	it also calculated the total price of a product in method total price. 
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2018/12/03
 */

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	
	/**
	 * Constructor of products 
	 * 
	 * @param name is the name of product as string
	 * @param price is the price of product as double
	 * @param quantity is the quantity of the product as integer
	 */
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
	 * getter for product name
	 * @return name as String
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * getter for price of product
	 * @return price as double
	 */
	
	public double getPrice() {
		return price;
	}
	
	/**
	 * getter for quantity of product
	 * @return quantity as integer
	 */
	
	public int getQuantity() {
		return quantity; 
	}
	
	/**
	 * setter for name. takes in newName that name will be set to
	 * @param newName is the value that name will be changed to
	 */
	
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * setter for price. takes in value that price will be set to
	 * @param newPrice is value that price will be changed to
	 */
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	/**
	 * setter for quantity. takes in quantity value that quantity will be set to
	 * @param newQuantity is value quantity will be changed to
	 */
	
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
	}
	
	/**
	 * gives total price of product by multiplying price and quantity
	 * @return total price of product
	 */
	public double getTotalPrice() {
		return getPrice() * getQuantity();

	}
}

