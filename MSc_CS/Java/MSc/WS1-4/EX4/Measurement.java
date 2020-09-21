import java.io.File;
    /**
    *  The problem with the code was that there was an exception thrown in the first 
    *  method but nothing in the second method to "catch" the exception
    *  thrown, in case the instrument malfunctions. 
    *  I have placed the try and catch in the second method within the loop,
    *  because that is where the exception should occur since we are wanting to
    *  assign any values that measurement() returns except for the IllegalArgExcept.
    *  In that case I have asked that the result[i] = -1, so anytime -1 occurs, we know the
    *  instrument malfunctioned.
    *
    *  @revisedBy Frances Adriana Laureano De Leon
    *  @date 7/11/18
    */
public class Measurement {
    /**
    *  The method is used to simulate an instrument that randomly
    *  return either 1 or 2, or malfunctions.
    *  @return The method returns randomly either 1 or 2.
    *  @exception IllegalArgumentException if the instrument
    *  malfunctions. This is simulated only and done when a random
    *  number of 0 is created (out of numbers 0, 1, or 2).
    */
    public static int measurement() {
    //Create a random integer of either 0, 1, or 2.
    int res = (int) (Math.random() * 3);
        if (res == 0) {
            throw new IllegalArgumentException();
        } else {
            return res;
        }
    }
    /**
    *  The method stores the result of n measurements in an array and
    *  return this.
    *  @param n The number of measurements.
    *  @return An array with the result of n measurements being
    *  either 1 or 2. If the measurement failed, a -1 is stored in
    *  the array.
    *  @exception IllegalArgumentException if the result of the
    *  measurement is -1. */
    public static int[] measurementSeries(int n) {
        int[] result = new int[n];
            //Loop to do exactly n measurments
            for (int i = 0; i < n; i++) {
             try{
                result[i] = measurement();
            }  
            catch(IllegalArgumentException e){
                result[i] = -1;
            }
        }
         System.out.println("Instrument malfunctioned, printed -1 instead");
         return result;
    }
    /**
    *  Print out the elements of a one-dimensional integer array,
    *  separated by empty spaces.
    *  @param a A one-dimensional int array.
    */
    public static void printArray(int[] a) {
        for (int el : a) {
        System.out.print(el + " ");
        }
    System.out.println();
    }
    /*
    *  Main method to test the program with 10 measurements.
    */
    public static void main(String[] args) {
        printArray(measurementSeries(10));
        }
    }
