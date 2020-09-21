import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSortTest{
	
	// testing unsorted array with repeated numbers
	@Test
	public void test1() {
		int[] numbers = {1, 2, 8, 3, 2, 2};
		int[] expected = {1, 2, 2, 2, 3, 8};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing larger array with two digit numbers
	@Test
	public void test2() {
		int[] numbers = {2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 2, 2, 1, 3, 10 , 70};
		int[] expected = {1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 10 , 70};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	// testing on already sorted array
	@Test
	public void test3() {
		int[] numbers = {1, 2, 3, 4, 5}; 
		int[] expected = {1, 2, 3, 4, 5};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	
	// testing on empty array
	@Test
	public void test5() {
		int[] numbers = {};
		int[] expected = {};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	
	// testing on array with negative numbers
	@Test
	public void test6() {
		int[] numbers = {1, -2, -3, 4, 5, -6};
		int[] expected = {-6, -3, -2, 1, 4, 5};
		int[] actual = InsertionSort.insertionSort(numbers);
		assertTrue(Arrays.equals(expected, actual));
	}
	
//  My tests have all passed

}
