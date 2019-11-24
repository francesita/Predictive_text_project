package predictive;
import java.util.*;
import java.io.*;
import java.io.File;
import java.util.HashMap;
/**
 * Class is a prototype for a predictive text problem.
 * It contains three methods, one of which creates a map of 
 * characters to numbers. It contains methods that take a word and return a signature or that take signatures and
 * return words.
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-10
 */
public class PredictivePrototype {
	
	static HashMap<Character, Integer> numToLetter = new HashMap<Character, Integer>();
	 
	/**
	 * This method returns a map of characters as keys and numbers as values
	 * 
	 * @return HashMap of character keys and integer values
	 */
    public static HashMap<Character,Integer> makeMap(){
		 
			 numToLetter.put("a".charAt(0), 2);
			 numToLetter.put("b".charAt(0), 2);
			 numToLetter.put("c".charAt(0), 2);
			 
			 numToLetter.put("d".charAt(0), 3);
			 numToLetter.put("e".charAt(0), 3);
			 numToLetter.put("f".charAt(0), 3);
			 
			 numToLetter.put("g".charAt(0), 4);
			 numToLetter.put("h".charAt(0), 4);
			 numToLetter.put("i".charAt(0), 4);
			 
			 numToLetter.put("j".charAt(0), 5);
			 numToLetter.put("k".charAt(0), 5);
			 numToLetter.put("l".charAt(0), 5);
			 
			 numToLetter.put("m".charAt(0), 6);
			 numToLetter.put("n".charAt(0), 6);
			 numToLetter.put("o".charAt(0), 6);
			 
			 numToLetter.put("p".charAt(0), 7);
			 numToLetter.put("q".charAt(0), 7);
			 numToLetter.put("r".charAt(0), 7);
			 numToLetter.put("s".charAt(0), 7);
			 
			 numToLetter.put("t".charAt(0), 8);
			 numToLetter.put("u".charAt(0), 8);
			 numToLetter.put("v".charAt(0), 8);
			 
			 numToLetter.put("w".charAt(0), 9);
			 numToLetter.put("x".charAt(0), 9);
			 numToLetter.put("y".charAt(0), 9);
			 numToLetter.put("z".charAt(0), 9);
    
        return numToLetter;
    }
    
	/**
	 * Returns the signature of a word. As Strings in Java are immutable. Using Substring
	 * we are able to maintain the integrity of the string. Using methods of String Buffer we can implement changes. 
	 * String Buffer also allows for concatenating string using the append method which is faster than in String.
	 * uses method Makemap to use HashMap to compare values
	 * @param word
	 * @return String of signature
	 */

	public static String wordToSignature(String word) {
		StringBuffer signature1 = new StringBuffer("");	//	Allows me to alter string
		String signature = "";
		String singleLetter = "";
		word = word.toLowerCase();

		for (int i = 0; i < word.length(); i++) {
			singleLetter = word.substring(i, i + 1);	
			
			if (makeMap().containsKey(word.charAt(i))) {
				signature1.append(makeMap().get(word.charAt(i)));	
			}else if(!singleLetter.matches("[a-zA-Z]*")){
				signature1.append(' '); //	any time a string has a non-alpha character it gives a signature with whitespace
			}
			signature = signature1.substring(0);
		}
		return signature;		
	}

	/**
	 * Method takes a string(signature) and returns boolean indicating if String is a valid word
	 * This method is the helper method in signatureToWords method. It is given a string signature as an argument, and
	 * if that string contains spaces, then it is not a valid word.
	 * @param word
	 * @return boolean
	 */
	 static boolean isValid(String signature) {
		 for (int i = 0; i < signature.length(); i++) {
			 if (Character.isWhitespace(signature.charAt(i)) == true) 
				 return false;
		 }
		return true;
	 }
	 
	 /**
	  * Method takes a signature and returns a set of words that correspond to a signature string
	  * given as parameter. Uses helper methods wordToSignature to get signature of all words in dictionary
      * 
      * Not storing the dictionary in program is inefficient because the dictionary has to be read each time, and signatures must be made and compared for each word.
      * It is very inefficient compared to having the dictionary with the signatures stored in the Java program. If the dictionary is stored, with the signatures, the the program needs to compare 
      * the signatures to those stored already instead of scanning the dictionary, calling another method for each word, and comparing signatures for each word everytime a signature needs to be found.  
      *
	  * @param signature
	  * @return TreeSet of String
	  */
	 public static Set<String> signatureToWords(String signature) {
		 Set<String> matchingSign = new TreeSet<String>();
		 
		 try {
			 File file = new File("predictive/dictionary.txt");
			 Scanner scan = new Scanner(file);
			 
			 while (scan.hasNextLine()) {
				 String line = (scan.nextLine()).toLowerCase(); //	This makes any words with upper case appear as lower case
				 String compare = wordToSignature(line);	//	compare stores signature of line
				 //	Compares signature of line to param signature and checks if there are any spaces in signature to determine whether valid or not
				 if (compare.equals(signature) && isValid(compare) == true) { 	
					 matchingSign.add(line);
				 }
			 }
			 scan.close();
		}
		 catch(IOException e) {
			 System.out.print("File not found");
		 }
		return matchingSign;
		
	 }
}
