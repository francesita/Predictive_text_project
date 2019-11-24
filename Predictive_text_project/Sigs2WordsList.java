package predictive;
/**
 * This class is a command-line program for testing DictionaryList class. This class took 0m5.602s to run.
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-10
 */
public class Sigs2WordsList {

	public static void main(String[] args) {
		ListDictionary test = new ListDictionary("predictive/dictionary.txt");
		
		for (String elem: args) {
		  System.out.println(elem + ":" + " " + test.signatureToWords(elem));	
		}
	}
}

