package predictive;
/**
 * This class is a command-line program for testing predictivePrototype class.
 * It tests the wordToSignature method
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-07
 */
public class Words2SigProto {

	public static void main(String[] args) {

		for (String elem: args) {
			System.out.println(PredictivePrototype.wordToSignature(elem));
		}
	}
}

