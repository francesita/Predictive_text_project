package EX2;

/**
 *   Concrete class Patient implements interface Measurable. 
 *   Method from interface getValue() is implemented
 *   
 *   @author Frances Adriana Laureano De Leon
 *   @version 2018-11-18
 */
public class Patient implements Measurable{
    
    private String name;
    private int age;
    private double weight;


    /**
     *   Constructor of class Patient which creates patient object 
     *   
     *   @param name is the name of each patient
     *   @param age is the age of each patient
     *   @param weight the weight of each patient
     */
    public Patient(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /** 
     *  getter for the name
     *  @return The name of the patient 
     */
    public String getName(){
        return name;
    }

    /** 
     *  getter for the age 
     *  @return The age of the patient 
     */
    public int getAge(){
        return age;
    }

    /** 
     *  getter for the weight
     *  @return The weight of the patient 
     */
    public double getWeight(){
        return weight;
    }

    /** 
     *  setter for the name
     *  @param newName The name of the patient 
     */
    public void setName(String newName){
        name = newName;
    }


    /** 
     *  setter for the age
     *  @param newAge sets the age of the patient 
     */
    public void setAge(int newAge){
        age = newAge;
    }


    /** 
     *  setter for the weight
     *  @param newWeight is the new weight of the patient 
     */
    public void setWeight(double newWeight){
        weight = newWeight;
    }

    /** 
     *  Method from interface Measurable
     *  @return weight of the patient
     */
    @Override
    public double getValue(){
        return weight;
    }
    

    /** 
     *  toString method for Patient class
     *  @return a printable string for the class patient
     */
    public String toString(){
        return "Name: " + name + "\n" + "Age: " + age + "\n" + "Weight: " + weight;
    }
}
