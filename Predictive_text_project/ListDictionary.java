package predictive;

import java.io.IOException;
import java.io.File;
import java.util.*;
/**
 * ListDictionary class creates a dictionary from a string path to a dictionary.
 * it reads and stores it in an arrayList of class WordSig. It also creates a list of 
 * Strings of signatures. 
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-10
 *
 */
public class ListDictionary implements Dictionary{
	
	private ArrayList<WordSig> dictionary;  
	private List<String> sigList;

	/**
	 * The constructor for the class. It will create an array of sorted words
	 * by signature. It takes the filename as parameter, it scans the words in the dictionary and creates 
	 * instances of WordSig. These instances are added when created to dictionary arrayList and the signatures are
	 * added to sigList list. Both lists are sorted after all words have been scanned in the dictionary.
	 * 
	 * @param filename
	 */
	public ListDictionary(String filename) {
		try {
			
			Scanner scan = new Scanner(new File(filename));
			
			this.dictionary = new ArrayList<WordSig>();
			this.sigList = new ArrayList<String>();
			
			while(scan.hasNextLine()) {
				String word = scan.nextLine().toLowerCase();
				WordSig elem = new WordSig(word);
				if (PredictivePrototype.isValid(elem.getSignature()) == true) {
					dictionary.add(elem);
					sigList.add(elem.getSignature());
				}
			}
			Collections.sort(getDictionary());
			Collections.sort(getSigList());
			scan.close();
			
		}
		catch(IOException e) {
			 System.out.print("File not found");
			
		}
		
	}	
	/**
	 * getter for dictionary arrayList
	 * @return dictionary
	 */
	public ArrayList<WordSig> getDictionary(){
		return dictionary;
	}
	
	/**
	 * Setter for dictionary
	 * @param newDictionary 
	 */
	public void setDictionary(ArrayList<WordSig> newDictionary) {
		dictionary = newDictionary;
	}
	
	/**
	 * getter for sigList
	 * @return sigList
	 */
	public List<String> getSigList(){
		return sigList;
	}
	
	/**
	 * Setter for sigList
	 * @param newSigList
	 */
	public void setSigList(List<String> newSigList){
		sigList = newSigList;
	}

	
	 /**
	  * This method takes in a signature and returns words that match that signature
	  * 
	  * @param signature
	  * @return 
	  */

	public List<Integer> binarySearch(List<String> sigList, String signature){
		List<Integer> indexes = new ArrayList<Integer>();
		int mid = Collections.binarySearch(sigList, signature); //	will give the index of first found match
		
		//	This if condition takes into account possibility of missing word/signatures in dictionary
		if (mid < 0) {
				System.out.println("Signature does not exist");
		}else {
		
			String firstSig = sigList.get(mid);
			
			for (int i = 0; i < mid; i ++) {
				if (sigList.get(i).compareTo(firstSig) == 0) {
					indexes.add(i);
				}
			}
			for (int i = mid; i < sigList.size(); i ++) {
				if (sigList.get(i).compareTo(firstSig) == 0) {
					indexes.add(i);
				}
			}
		}
		return indexes;
	}
	/**
	  * This method takes in a signature and returns words that match that signature
	  * It uses the binarySearch method to find the indexes of the words that match
	  * a given signature.
	  * 
	  * @param signature
	  * @return TreeSet of strings, composed of words that match a given signature 
	  */
	@Override
	public Set<String> signatureToWords(String signature) {
		Set<String> matchingSign = new TreeSet<String>();
		List<Integer> indexes = binarySearch(getSigList(), signature);
		
		for(int elem: indexes) {
			matchingSign.add(getDictionary().get(elem).getWord());	//	here we match the indeces of signatures to their respective indeces in dictionary arrayList.
		}
		return matchingSign;
	}
	
	public static void main(String[] args) {
		ListDictionary test = new ListDictionary("src/predictive/dictionary.txt");
		
		System.out.println(test.getDictionary().get(7).getSignature());
		System.out.println(test.getSigList().get(7));
		System.out.println(test.getDictionary().size());
		
	}
}

