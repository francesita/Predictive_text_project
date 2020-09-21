
/**
 *   This class contains a method that sorts numbers in an array order from
 *   least to greatest.
 *
 *   @version 2018-11-03
 *   @author Frances Adriana Laureano De Leon
 *   
 */

public class InsertionSort{


    /**
     *   This method sorts numbers in an array of integers from least to greatest
     *   @param numbers- an array of integers
     *   
     */


    public static int[] insertionSort(int[] numbers){

        //  loop to go through the values starting from the second one in the 
        //  array, so that is why i is initialized to 1.

        for (int i = 1; i < numbers.length; i++){
                
                // variables have been initialized, one called tempValue which stores
                // a temporary value after the second loop begins to interate.
                // I save this value in order to be able to reassign what was in numbers[j]
                // to the index just before in the loop.
                //The second loop stops iterating before going out to the i loop
                // until j becomes zero in each iteration

               int tempValue = 0;
               int j = i - 1;

           for (j = i; j > 0 && numbers[j-1] > numbers[j]; j--){
                tempValue = numbers[j];
                numbers[j] = numbers[j-1];
                numbers[j-1] = tempValue;
            }       
        }
        return numbers;  //  array is returned after loop conditions satisfied
    }

    public static void main(String[] args){
        int[] arr = {0,5,7,3};
        for(int i =0 ; i < insertionSort(arr).length; i++){
            System.out.println(insertionSort(arr)[i]);
        }
    }
}

//  My JUnit tests passed and passed public tests
