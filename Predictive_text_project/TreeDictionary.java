package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.Set;

import predictive.Trie.TreeNode;
/**
 * TreeDictionary class makes a tree dictionary using Trie class. The dictionary text file is scanned 
 * and read, and words are put into the corresponding nodes of the Tree, based on their signature
 * 
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019/02/17
 *
 */
public class TreeDictionary implements Dictionary{
	
	private Trie dictionary = new Trie();
	/**
	 * Constructor for TreeDictionary. It makes a tree dictionary of words of String path provided. 
	 * It makes every word lowercase, checks that the word is valid (no non-alpha characters) and inserts
	 * the word into the dictionary using insertWord method from Trie class. 
	 * 
	 * @param filename
	 */
	public TreeDictionary(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			
			while(scan.hasNextLine()) {
				String word = scan.nextLine().toLowerCase();
				String signature = PredictivePrototype.wordToSignature(word);
				if(PredictivePrototype.isValid(signature))
					dictionary.insertWord(signature, word);
			}
				
		}catch (IOException e) {
			System.out.println("File not found");
		
		}
	}
	
	/**
	 * Getter for dictionary, which returns the Trie
	 * @return trie of dictionary
	 */

	public Trie getDictionary() {
		return dictionary;
	}


	public void setDictionary(Trie dictionary) {
		this.dictionary = dictionary;
	}
	
	/**
	 * Signature to words takes in a signature. The signature or part of signature of a word is taken in by the method
	 * and a set of words corresponding to the signature/part of signature given is returned to the user. The method uses 
	 * a helper method sigToWordsHelper that gives a Set of words/prefixes of words corresponding to the length of the signature given.
	 * 
	 * Exception thrown if a signature that leads to null nodes is given
	 */

	@Override
	public Set<String> signatureToWords(String signature) {
		 Set<String> words = new HashSet<String>();
		 try {
			 TreeNode tempNode = null;	//	individual node
			 TreeNode[] tempChild = dictionary.getRoot().getChildren();	//	children of a node. starts at root so that I can reassign in loop the value to the children of a child so on and so forth
			 
			 //	Takes the signature, looks at the first character, as a string
			 for(int i = 0; i < signature.length(); i++) {
				 String index = signature.substring(i, i + 1);
				 int ind = dictionary.keyToNode().get(index);
				 
				 tempNode = tempChild[ind];	// a particular node
				 tempChild = tempNode.getChildren();	// children of the node
			 }
			 //	loop looks at the node's getValue, which is an arrayList of Strings, I append each element of value to the words set cast as string
			 for(Object elem: tempNode.getValue()) {
				 words.add((String) elem); 
			 }
		 
		 }
	 	catch(NullPointerException e) {
			System.out.println("no such signature");
		}
		return sigToWordsHelper(words, signature);
	}
	/**
	 * helper method sigToWordsHelper that gives a Set of words/prefixes of words corresponding to the length of the signature given.
	 * 
	 * @param words
	 * @param signature
	 * @return Set<String> 
	 */
	public Set<String> sigToWordsHelper(Set<String> words, String signature){
		Set<String> finalWords = new HashSet<String>();
		for (String elem: words) {
			if(elem.length() >= signature.length()) {
				finalWords.add(elem.substring(0, signature.length()));
			}
		}
		return finalWords;
	}
	
	/**
	 * Search method takes in a string and prints out the node corresponding to signature string. If length of
	 * signature string is one, it returns array of node corresponding to that signature. If "46" given as signature it print 
	 * all the elements of node 6 attached to node 4 (parent node).
	 *
	 * @param signature
	 * @return ArrayList<String>
	 */
	public ArrayList<String> search(String signature) {
		ArrayList<String> nodeValues = new ArrayList<String>();
		try {
		 TreeNode node = null;
		 TreeNode[] tempChild = dictionary.getRoot().getChildren();	//	Starts at the root's to later be reassigned with Children of the children
	
		 for(int i = 0; i < signature.length(); i++) {
			 String index = signature.substring(i, i + 1);
			 int ind = dictionary.keyToNode().get(index);

			 node = tempChild[ind]; //	looks at particular node at index according to signature
			 tempChild = node.getChildren();
		 	}
		  nodeValues = node.getValue();
		}
 		catch(NullPointerException e) {
		System.out.println("no such signature");
 		}
		 return nodeValues;
	}
	
	public static void main(String[] args) {
		TreeDictionary dict = new TreeDictionary("src/predictive/article.txt");
		
		System.out.println(dict.search("pooop"));
		System.out.println(dict.signatureToWords("4663"));
		System.out.println(dict.signatureToWords("43556"));
		System.out.println(dict.search("435"));
	}


}

