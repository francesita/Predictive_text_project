package predictive;
/**
 * Command-Line class for MapDictionary. It takes in a String, in this case we want signatures. The program prints the set of words
 * corresponding to the signatures. In comparison to the List dictionary and Predictive Prototype, the Map dictionary took 
 * real	0m5.780s to give an output. This is virtually the same amount of time List Dictionary took to give and output.
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-14
 */
public class Sigs2WordsMap {

	public static void main(String[] args) {
		MapDictionary test = new MapDictionary("src/predictive/article.txt");
		
		for (String elem: args) {
		  System.out.print(test.signatureToWords(elem));	
		}
	}
}
