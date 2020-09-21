package shop;
import java.util.ArrayList;
/**
 * This class holds an arraylist of class product. It is a shppping cart
 * it adds products to shopping cart using method add
 * if certain conditions are met.
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2018/12/05
 *
 */

public class ShoppingCart {
	
	private ArrayList<Product> cart;
	
	/**
	 * Constructor of shopping cart with empty shopping cart
	 */
	public ShoppingCart() {
		this.cart = new ArrayList<Product>(); 
	}
		
	public ArrayList<Product> getCart(){
		return cart;
	}
	

	
	public String toString() {
		String gbp1 =  "* GBP";
		String gbp2 = "= GBP";
		String format = "";
		String price = "";
		String total = "";
		String discount = "";
		String line =String.format("%47s","--------------");
		
		for (Product p: cart) {
			price = String.format("%,.2f",p.getPrice());
			total = String.format("%,.2f",p.getTotalPrice());
			if (p instanceof MultiBuyProduct) {
				discount = String.format("%,.2f", ((MultiBuyProduct)p).discountAmount()); 
				format = String.format("%-3d%-10s%-6s%-15s%-10s%-6s\n%27s%5s)", p.getQuantity(),gbp1, price, p.getName(), gbp2, total,"(Multibuy Discount: GBP" , discount);
				System.out.print(format + "\n");
			}else {
			format = String.format("%-3d%-10s%-6s%-15s%-10s%-6s", p.getQuantity(),gbp1, price, p.getName(), gbp2, total);
			System.out.print(format + "\n");
			}
		}
		System.out.println(line);
		System.out.printf("%39s%9s", "Total GBP", checkOutTotal());
		return "";
	}

	/**
	 * void method that adds products of type product to shopping cart
	 * if certain conditions are met 
	 * @param p which is a product of Product(class)
	 */

	public void add(Product p) {
		boolean verdict = false;	//	boolean initialised to false
		if (cart.size() == 0) {		
			cart.add(p);
		}else if(p instanceof MultiBuyProduct) {	//	if the product added is from multiclass, add it to cart (useful esp. product with same price)
			cart.add(p);
		}else{ 							//	checks if elements of the list have same name and price and adds. Changes boolean so not added
			for (Product elem: cart) {
				if(elem.getName().equals(p.getName()) && Double.compare(elem.getPrice(), p.getPrice()) == 0){
						elem.setQuantity(elem.getQuantity() + p.getQuantity());
						verdict = true;
				}
			}
			if (verdict == false) {	
				cart.add(p);
			}
				
		}
			
	}

	/**
	 * method return total rounded with Math.round for formatting purposes
	 * and to not clog up my tostring method more than it was getting
	 * 
	 * @return total amount in cart
	 */
	
	public double checkOutTotal() {
		double total = 0.;
		for (Product p: cart) {
			total += p.getTotalPrice();
		}
		return Math.round(total * 100.)/100.;
	}
	
}

