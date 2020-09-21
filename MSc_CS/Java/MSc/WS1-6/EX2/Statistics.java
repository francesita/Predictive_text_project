package EX2;
import java.util.ArrayList;
/**
 *   Abstract class Statistics implements interface Measurable. Class
 *   was declared abstract in order to be able to implement Measurable
 *   and not have to use the getValue method of the interface.
 *   
 *   @author Frances Adriana Laureano De Leon
 *   @version 2018-11-18
 */

public abstract class Statistics implements Measurable{

    /**
     *   This method takes in an ArrayList of a classe that implements  
     *   Measurable and returns the value of the element with the Maximum value.
     *
     */

    public static double maximum(ArrayList<Measurable> elements){
        double max = elements.get(0).getValue();
        for (int i =0; i < elements.size(); i++){          
            if (max < elements.get(i).getValue()){           
            max = elements.get(i).getValue();
            }
        }
        return max;
    }

    /**
     *   This method takes in an ArrayList of a class that implements Measurable
     *   and returns the average value of the elements in ArrayList.
     */

    public static double average(ArrayList<Measurable> elements){
        double sum = 0;
        for (int i =0; i < elements.size(); i++){
            sum += elements.get(i).getValue();      
        }
        return sum/elements.size();
    }

     /**
      *   This method takes in an ArrayList of a class that implements Measurable
      *   and returns the standard deviation of the elements in ArrayList.
      */

    public static double standardDeviation(ArrayList<Measurable> elements){
        double diffSqr = 0;
        double sum = 0;

        for (int i =0; i < elements.size(); i++){
            diffSqr =(elements.get(i).getValue() - average(elements)) * (elements.get(i).getValue() - average(elements));
            sum += diffSqr;
        }
        return Math.sqrt(sum/(elements.size()-1));          
    }

  
    public static void main(String[] args){
       ArrayList<Measurable> i = new ArrayList<Measurable>();
       ArrayList<Measurable> p = new ArrayList<Measurable>();
        System.out.print(maximum(i));
        System.out.print(maximum(i));   
        System.out.print(maximum(i));
        System.out.print(maximum(p));
        System.out.print(average(p));   
        System.out.print(standardDeviation(p));
    }
}
