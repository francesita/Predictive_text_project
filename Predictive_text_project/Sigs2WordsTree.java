package predictive;
/**
 * Command-Line class for TreeDictionary. It takes in a String, in this case we want signatures. The program prints the set of words
 * corresponding to the signatures. In comparison to the List dictionary, MapDictionary and Predictive Prototype, the Tree dictionary took 
 * real	real 1m59.158s to give an output. This is still about 4 times faster than the PredictivePrototype class but much slower than MapDictionary
 * or ListDictionary classes.
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-14
 */
public class Sigs2WordsTree {

	public static void main(String[] args) {
		TreeDictionary test = new TreeDictionary("predictive/dictionary.txt");
		
		for (String elem: args) {
		  System.out.print(test.signatureToWords(elem));	
		}
	}
}
