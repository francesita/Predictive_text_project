package predictive;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import predictive.Trie.TreeNode;
/**
 * These are Junit tests for PredictivePrototype class, and ListDictionary Class
 * MapDictionary class, Trie class and TreeDictionary class
 * 
 * @author Frances Adriana Laureano De Leon
 * @version 2019-02-17
 *
 */
class PredictiveTest {
	/**
	 * Tests for all lower case, for non-alphabetic character handling,
	 * for all capital letters in Predictive Prototype method wordToSignature.
	 * Also tests method isValid.
	 */
	@Test
	void test1() {
		String word1 = "HELLO";
		String word2 = "!!!";
		String word3 = "No matter how hard I try!";
		String word4 = "home";
		
		String expectedSignature1 = "43556";
		String actualSignature1 = PredictivePrototype.wordToSignature(word1);
		
		assertEquals(expectedSignature1, actualSignature1);
		
		String expectedSignature2 = "   ";
		String actualSignature2 = PredictivePrototype.wordToSignature(word2);
		
		assertEquals(expectedSignature2, actualSignature2);
		
		
		String expectedSignature3 = "66 628837 469 4273 4 879 ";
		String actualSignature3 = PredictivePrototype.wordToSignature(word3);
		
		assertEquals(expectedSignature3, actualSignature3);
		
		String expectedSignature4 = "4663";
		String actualSignature4 = PredictivePrototype.wordToSignature(word4);
		
		assertEquals(expectedSignature4, actualSignature4);
		
		//this test should give true even though string should be not valid, because method should work only with signatues
		boolean expectedValue1 = true;
		boolean actualValue1 = PredictivePrototype.isValid(word2);
		assertEquals(expectedValue1, actualValue1);
		
		
	}
	/**
	 * Tests for existing signature and not existing signature for method
	 * SignatureToWords in Predictive Prototype class. It also tests is valid method with signatures
	 */
	@Test
	void test2() {
		String signature1 = "4663";
		String signature2 = "3299483234123232345";
		String signature3 = "3825 968";
		
		Set<String> expectedwords1 = new TreeSet<String>();
		expectedwords1.add("good");
		expectedwords1.add("inne");
		expectedwords1.add("hood");
		expectedwords1.add("hoof");
		expectedwords1.add("hone");
		expectedwords1.add("home");
		expectedwords1.add("gone");
		
		Set<String> actualwords1 = PredictivePrototype.signatureToWords(signature1);
		assertEquals(expectedwords1, actualwords1);
		
		Set<String> expectedwords2 = new TreeSet<String>();
		Set<String> actualwords2 = PredictivePrototype.signatureToWords(signature2);
		assertEquals(expectedwords2, actualwords2);
		
		boolean expectedValue1 = false;
		boolean actualValue1 = PredictivePrototype.isValid(signature3);
		assertEquals(expectedValue1, actualValue1);
		
		boolean expectedValue2 = false;
		boolean actualValue2 = PredictivePrototype.isValid(signature3);
		assertEquals(expectedValue2, actualValue2);
		
	}
	/**
	 * This tests if ListDictionary arrayList dictionary is sorted upon creation.
	 * This will also test if signatures list matches order of dictionary signatures
	 * 
	 */
	@Test
	void test3() {
		ListDictionary test = new ListDictionary("src/predictive/dictionary.txt");
		
		int expectedSize1 = 49;
		int actualSize1 = test.getDictionary().size();
		assertEquals(expectedSize1, actualSize1);
		
		int expectedSize2 = 49;
		int actualSize2 = test.getSigList().size();
		assertEquals(expectedSize2, actualSize2);
		
		assertEquals(actualSize1, actualSize2);
		
		String expectedSig1 = "276863";
		String actualSig1 = test.getDictionary().get(9).getSignature();
		assertEquals(expectedSig1, actualSig1);
		
		String expectedSig2 = "276863";
		String actualSig2 = test.getSigList().get(9);
		assertEquals(expectedSig2, actualSig2);
		
		assertEquals(actualSig1, actualSig2);
	}
	/**
	 * Here we will test MapDictionary.
	 * SignatureToWords will be tested by giving in String that is not signature,
	 * by giving a string that is a signature, and by giving an empty dictionary
	 * we also tested whether duplicates of words would appear by putting more than
	 * one of the same word in the dictionary
	 * 
	 */
	@Test
	void test4() {
		MapDictionary test1 = new MapDictionary("src/predictive/dictionary.txt");
		MapDictionary test2 = new MapDictionary("src/predictive/empty.txt");
		//	testing an empty string
		Set<String> expectedWords1 = null;
		Set<String> actualWords1 = test1.signatureToWords("");
		assertEquals(expectedWords1, actualWords1);
		
		//	testing a signature that does not exist
		Set<String> expectedWords2 = null;
		Set<String> actualWords2 = test1.signatureToWords("45362764829747364834");
		assertEquals(expectedWords2, actualWords2);
		
		//	testing signature that exists, making sure no word length
		//	greater than signature length
		Set<String> expectedWords3 = new TreeSet<String>();
		expectedWords3.add("good");
		expectedWords3.add("inne");
		expectedWords3.add("hood");
		expectedWords3.add("hoof");
		expectedWords3.add("hone");
		expectedWords3.add("home");
		expectedWords3.add("gone");
		Set<String> actualWords3 = test1.signatureToWords("4663");
		assertEquals(expectedWords3, actualWords3);
	}

	/**
	 * Tests TreeDictionary for insertion, for signatureTOWords, including giving back
	 * only part of word corresponding to signature, testing signature that does not exist
	 * and testing string given as signature that is not a signature 
	 */
	@Test
	void test5() {
		TreeDictionary test1 = new TreeDictionary("src/predictive/dictionary.txt");
		TreeDictionary test2 = new TreeDictionary("src/predictive/empty.txt");
		//testing complete signature/partial
		Set<String> expectedWords1 = new HashSet<String>();
		
		expectedWords1.add("good");
		expectedWords1.add("inne");
		expectedWords1.add("hood");
		expectedWords1.add("hoof");
		expectedWords1.add("hone");
		expectedWords1.add("home");
		expectedWords1.add("gone");
		expectedWords1.add("imme");	//partial word
		
		Set<String> actualWords1 = test1.signatureToWords("4663");
		assertEquals(expectedWords1, actualWords1);
		
		//	testing search
		ArrayList<String> expectedWords2 = new ArrayList<String>();
		
		expectedWords2.add("alone");
		expectedWords2.add("computer");
		expectedWords2.add("binary");
		expectedWords2.add("are");
		expectedWords2.add("a");
		expectedWords2.add("ant");
		expectedWords2.add("any");
		expectedWords2.add("around");
		expectedWords2.add("always");
		
		ArrayList<String> actualWords2 = test1.search("2");
		assertEquals(expectedWords2, actualWords2);
		
		//	testing empty dictionary and none existent signature
		Set<String> expectedWords3 = new TreeSet<String>();
		Set<String> actualWords3 = test2.signatureToWords("55354654");
		assertEquals(expectedWords3, actualWords3);
		
		Set<String> expectedWords4 = new HashSet<String>();
		
		expectedWords4.add("ant");

		
		//	testing complete signature 268
		Set<String> actualWords4 = test1.signatureToWords("268");
		assertEquals(expectedWords4, actualWords4);

	}
}

