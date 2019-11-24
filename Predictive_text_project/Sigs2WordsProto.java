package predictive;
/**
 * This class is a command-line program for testing predictivePrototype class.
 * It tests the signatureToWords method.
 * 
 * This class took real	5m3.001s to run. It was matching signatures of an article to words. 
 * This was considerably slower compared to the Sigs2WordsList which took 0m5.602s.
 * Sigs2WordsList seemed to finish running almost immediately, while this class took minutes to run.
 *
 * This clearly shows that the ListDictionary class is more efficient in termsn of time in 
 * finding the words matched to signatures than the PredictivePrototype class.
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-07
 */
public class Sigs2WordsProto {

	public static void main(String[] args) {

		for (String elem: args) {
			System.out.println(elem + ":" + " " + PredictivePrototype.signatureToWords(elem));  //  Check to see if you can print without brackets
		}
	}
}


