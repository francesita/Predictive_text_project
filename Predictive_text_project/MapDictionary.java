package predictive;

import java.io.IOException;
import java.io.File;
import java.util.*;

/**
 * MapDictionary class takes in String path to dictionary and stores dictionary in a multi-valued map.
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-17
 *
 */
public class MapDictionary implements Dictionary {

	private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();
	/**
	 * Constructor for MapDictionary. Takes String Path to the dictionary. Scans, turns each word to lowercase.
	 * If a word is valid, add to the set of words. If the current signature of word being scanned exists, then 
	 * word is added to set of values that already exist in the signature of the map, else the signature and word
	 * are added to the dictionary as key and value respectively. A set is used to store the words to avoid repeats 
     * of the same word
	 * 
	 * @param filename
	 */
	public MapDictionary(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			
				while(scan.hasNextLine()) {
					String word = scan.nextLine().toLowerCase();
					String signature = PredictivePrototype.wordToSignature(word);
					Set <String> wordsSet = new HashSet<String>();
					if(PredictivePrototype.isValid(signature)==true && word.length() == signature.length()) {
						wordsSet.add(word);
						if(dictionary.containsKey(signature)) {
							dictionary.get(signature).add(word);
						}else {
							dictionary.put(signature, wordsSet);
						}
					}
				}
				scan.close();
				
		} catch(IOException e){
			System.out.println("File not found");
		}
	}

	/**
	 * getter for dictionary
	 * @return dictionary
	 */
	public Map<String, Set<String>> getDictionary() {
		return dictionary;
	}

	/**
	 * setter for dictionary
	 * @param dictionary
	 */
	public void setDictionary(Map<String, Set<String>> dictionary) {
		this.dictionary = dictionary;
	}
	
	/**
	 * Method looks to see if the signature exists as a key in the map, if it does the values contained at the key 
	 * are returned
	 */
	@Override
	public Set<String> signatureToWords(String signature) {
		if(dictionary.containsKey(signature));
			return dictionary.get(signature);
	}

}

