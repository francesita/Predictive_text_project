package predictive;
import java.util.*;
/**
 * This class implements comparable and dictionary interfaces.
 * It makes a pair of a word and matching signature
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-10
 *
 */
public class WordSig implements Comparable<WordSig>, Dictionary {
	
	private String word;
	private String signature;
	private Set<String> pairs;
	/**
	 * Constructor for class. It takes in a word, finds matching signature
	 * and adds it to set pairs. 
	 * 
	 * @param word
	 */
	public WordSig(String word) {
		this.word = word;
		this.signature = PredictivePrototype.wordToSignature(getWord());
		this.pairs = new TreeSet<String>();
		
		pairs.add(getWord());
		pairs.add(getSignature());
	}
	/**
	 * Getter for word
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Setter for word
	 * @param words
	 */
	public void setWords(String words) {
		this.word = words;
	}

	/**
	 * Getter for signature
	 * @return signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * setter for signature
	 * @param signature
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	/**
	 * getter for pairs set
	 * @return pairs
	 */
	public Set<String> getPairs(){
		return pairs;
	}
	
	/**
	 * setter for pairs set
	 * @param newPairs
	 */
	public void setPairs(Set<String> newPairs) {
		pairs = newPairs;
	}

	/**
	 * returns pairs set as string
	 */
	public String toString() {
		return pairs.toString();
	}
	
	/**
	 * Compares by signature, an instance of WordSig to another
	 */
	@Override
	public int compareTo(WordSig other) {
		return this.getSignature().compareTo(other.getSignature()); 
	}
	
	/**
	 * @return words associated to signature
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		return PredictivePrototype.signatureToWords(signature);
	}
}

