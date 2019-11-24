package predictive;
import java.util.*;
/**
 * Trie class is a public class and TreeNode class is a public static class.
 * Trie consist of a TreeNode. TreeNode class consists of a value and an array of 
 * size of 8, which represents 8 nodes, for numbers 2-9.
 * Resources used for this class: 
 * https://medium.com/basecs/trying-to-understand-tries-3ec6bede0014
 * https://brilliant.org/wiki/tries/
 * https://www.youtube.com/watch?v=TRg9DQFu0kU
 * https://algs4.cs.princeton.edu/lectures/52Tries.pdf
 * 
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019/02/17
 *
 * @param <E>
 */
public class Trie<E> {
  		
  		private TreeNode root = new TreeNode(); //	initializing root to empty String
  		
  		/**
  		 * constructor for Trie. Trie consists of root, which is a TreeNode, assigned an empty string as value
  		 */
  		public Trie() {
  			this.root = root;
  			root.setValue("");
  		}

  		
	  	public TreeNode getRoot() {
			return root;
		}


		public void setRoot(TreeNode root) {
			this.root = root;
		}

		/**
		 * insertWord calls insertWord method in TreeNode. It takes in a signature and word. THe signature size is decreased recursevely, 
		 * until the word has been placed in every node that corresponds to a part of the signature. The keyToNode map is used to turn the string digit of signature 
		 * into an integer index corresponding to the Array of child nodes.
		 * 
		 * Method checks if word is already in the Trie, if it is word is not added, else it continues to add the word to all corresponding nodes. 
		 * @param signature
		 * @param word
		 */
		public void insertWord(String signature, String word) {
			root.insertWord(signature, word);
  		}
		
		/**
		 * Search method takes in a string and prints out the node corresponding to signature string. If length of
		 * signature string is one, it prints the node corresponding to that signature. If "46" given as signature it print 
		 * all the elements of node 6 attacked to node 4 (parent node).
		 * @param signature
		 */
		public void search(String signature) {
			try {
 			 TreeNode node = null;
 			 TreeNode[] tempChild = root.getChildren();
 			 
 			 
 			 for(int i = 0; i < signature.length(); i++) {
 				 String index = signature.substring(i, i + 1);
 				 int ind = keyToNode().get(index);
 				 
 				 node = tempChild[ind];
 				 tempChild = node.getChildren();
 			 	}
 			 System.out.println(node);
			}
			catch(NullPointerException e) {
				System.out.println("Signature does not exist");
			}
		}
		
			/**
			 * HashMap with keys as the digits as String 2-9 and values indexes for the array of TreeNodes
			 * @return nodeArray
			 */
 			public static HashMap<String,Integer> keyToNode(){
		  			 HashMap<String, Integer> nodeArray = new HashMap<String, Integer>(); 
					 nodeArray.put("2", 0);
					 nodeArray.put("3", 1);
					 nodeArray.put("4", 2);
					 nodeArray.put("5", 3);
					 nodeArray.put("6", 4);
					 nodeArray.put("7", 5);
					 nodeArray.put("8", 6);
					 nodeArray.put("9", 7);
		   
					 return nodeArray;
		  		}
 			
 			public String toString() {
 	  			return root.getValue() + "\n" + Arrays.toString(root.getChildren());
 	  		}
 			
 			/**
 			 * TreeNode class is a public static class.
 			 * TreeNode class consists of a value and an array of 
 			 * size of 8, which represents 8 nodes, for numbers 2-9.
 			 * Resources used for this class: 
 			 * https://medium.com/basecs/trying-to-understand-tries-3ec6bede0014
 			 * https://brilliant.org/wiki/tries/
 			 * https://www.youtube.com/watch?v=TRg9DQFu0kU
 			 * https://algs4.cs.princeton.edu/lectures/52Tries.pdf
 			 * 
 			 * 
 			 * @author Frances Adriana Laureano De Leon
 			 * @version 2019/02/17
 			 *
 			 * @param <E>
 			 */
  		public static class TreeNode<E> {

  			ArrayList<String> value;	//	information stored inside the node	
  			private TreeNode[] children = new TreeNode[8];//	array of pointers
  			  	/**
  			  	 * Constructor for TreeNode. Consists of a value as ArrayList<String> and 
  			  	 * children, an array of TreeNode of size 8, representing digits 2-9
  			  	 */
  			  	public TreeNode() {
  			  		this.value = new ArrayList<String>();
  			  		this.children = children;
  			  	}
  	  		
  			  	/**
  			  	 * getter for value
  			  	 * @return arrayList of string
  			  	 */
  			  	public ArrayList<String> getValue() {
  			  		return value;
  			  	}
  			  	/**
  			  	 * Setter of Value. Takes in a String value and add to the array of values Strings that 
  			  	 * are not already in the values array. Allows for a value to be set in the insertion method
  			  	 * without overwriting what already exists in value array
  			  	 * 
  			  	 * @param newValue
  			  	 */
  			  	public void setValue(String newValue) {
  			  		if(!getValue().contains(newValue))
  			  			this.value.add(newValue);
  			  	}
  			  	/**
  			  	 * gets children array
  			  	 * @return children
  			  	 */
  			  	public TreeNode[] getChildren() {
  			  		return children;
  			  	}
  			  	/**
  			  	 * setter for children array
  			  	 * @param children
  			  	 */
  			  	public void setChildren(TreeNode[] children) {
  			  		this.children = children;
  			  	}
  			  	
  			  	/**
  				 * HashMap with keys as the digits as String 2-9 and values indexes for the array of TreeNodes
  				 * @return nodeArray
  				 */
  		  		public static HashMap<String,Integer> keyToNode(){
  		  			 HashMap<String, Integer> nodeArray = new HashMap<String, Integer>(); 
  					 nodeArray.put("2", 0);
  					 nodeArray.put("3", 1);
  					 nodeArray.put("4", 2);
  					 nodeArray.put("5", 3);
  					 nodeArray.put("6", 4);
  					 nodeArray.put("7", 5);
  					 nodeArray.put("8", 6);
  					 nodeArray.put("9", 7);
  		   
  					 return nodeArray;
  		  		}
  		  	  /**
  		  	   * Method takes in a child node and puts the child node
  		  	   * inside the proper index. This allows for for children[i] to
  		  	   * become child (new node) 
  		  	   * @param child
  		  	   * @param i
  		  	   */
  			  public void addChildren(TreeNode child, int i) { //	takes in "new child node" and index and puts that node in that index.
  				  if (children[i] == null) {
  					  this.children[i]=child;
  				  }
  			  }
  			  /**
  			   * Recursive method that shortens a string signature, uses the first 
  			   * String character to find the node where a word attached to that signature needs to be placed.
  			   * if a node is null, a new node called child is created, addChildren method is called to assign
  			   * null node the newly created child node. That node is then assigned a word as value, if that value does not yet
  			   * exist. if the signature (endsig) is not empty, the node calls the method to work within that particular node
  			   * in order to have the "Russian doll" effect and make sure the whole word is added to every node that forms
  			   * part of the signature.
  			   *  
  			   * @param signature
  			   * @param word
  			   */
  			 public void insertWord(String signature, String word) {
				 String endSig = signature.substring(1);
	 			 String startSig = signature.substring(0,1);

				 int i = keyToNode().get(startSig); // keyNode finds the node to add children to if null
					if (children[i] == null) {	//	here we are checking if this node has been visited, if not, create node
						TreeNode child = new TreeNode(); 	
	  			  		addChildren(child, i);	//	children[i] becomes child
					}
						children[i].setValue(word);	// 	we are adding value to array of words 
	  			  		if(endSig.length() != 0)
	  			  		children[i].insertWord(endSig, word);
		  		}
  			   
  			 	/**
  			 	 * Return the value(arrayList) of a node. 
  			 	 */
	  			public String toString() {
	  	  			return getValue().toString();
	  	  		}
	  			  
  			  
  		}
}

