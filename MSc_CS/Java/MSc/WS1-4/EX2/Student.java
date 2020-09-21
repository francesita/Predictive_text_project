import java.util.Arrays;

/**
 *   This class creates a student object that stored the marks and registration
 *   number for a student object.
 *
 *   @version 2018-11-03
 *   @author Frances Adriana Laureano De Leon
 *   
 */

public class Student{

    private String registrationNumber;
    private int[] marks = new int[14];

    private final int[] weightPerMark = {2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 2, 2, 1, 3, 10 , 70};
  
    /** 
     *  This is my Student constructor which takes in two arguments 
     *
     *  @param registrationNumber takes in registration number as integer
     *  @param marks is an array of 14 marks for a student as integers
     *
     */

    public Student(String registrationNumber, int[] marks){
        this.registrationNumber = registrationNumber;
        this.marks = marks;
        
    }   

    /** 
     *  returns registrationNumber as String
     */

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    /** 
     *  Sets the value for registration Number
     *  registration number is changed registration number value
     */

    public void setRegistrationNumber(String newRegistrationNumber){
        registrationNumber= newRegistrationNumber;
    }

    /** 
     *  returns marks as integer array of marks
     */

    public int[] getMarks(){
        return marks;
    }

    /** 
     *  Sets the values for marks
     *  marks is equal to changed values for marks
     */

    public void setMarks(int[] newMarks){
       marks = newMarks;
    }

    /** 
     *  toString method will print Student in the specified style iwth specified
     *  information.
     */

    public String toString(){
        return "The marks for student "  + registrationNumber + "" +  " are " + Arrays.toString(getMarks()) + "" + "their grade is " + totalMark() + "." + " This student passed: " + passed() + ".";
    }
    
     
    /** 
     *  This method will set the mark for a certain assignment
     *  @param assigmentNumber for the assignment we are trying to assign a mark to
     *  @param mark for the percentage earned in the assignment
     *
     */


    public void setAssignmentMark(int assignmentNumber, int mark){
        //  we subtract 1 from the assignment number so it will match to the 
        //  indices of the assignment in the array 
        marks[assignmentNumber - 1] =  mark; 
    }

    /** 
     *  This method will return the total mark earned for a student based on marks.
     *  The method will iterate through the marks array and multiply those marks
     *  by the weighted marks in order to obtain the total marks earned by a student
     */

    public double totalMark(){
        // Initializing variables for the loop
        double sumMarks = 0;
        double weightedGrade = 0;
        int totalRemovedWeight = 0;

        for (int i = 0; i < marks.length; i++){
            if (marks[i] != -1){
            weightedGrade = (marks[i] * weightPerMark[i]) / 100.;
            sumMarks += weightedGrade;
            }else if(marks[i] == -1){

             marks[i] = 0;
             totalRemovedWeight += weightPerMark[i];
             weightPerMark[i] = 0; 
             weightedGrade = (marks[i] * weightPerMark[i]) / 100.;
             sumMarks += weightedGrade;
           }
        }

        //  After loop finishes I need to make sure that the weight removed was 
        //  not larger than 50, if it was I need to return -1, otherwise I return 
        //  weighted grade of the student after normalizing for any removed marks
        //  Math.round used to give me rounded percentage to 1 decimal point

         if (totalRemovedWeight > 50){
            return -1;
        }else if (totalRemovedWeight < 50 && totalRemovedWeight > 0){
            return Math.round(sumMarks/(100 - totalRemovedWeight) * 100 * 10) / 10.;
        }else{
            return Math.round(sumMarks * 10) / 10.;
        }
    }

    /** 
     *  This method will return true if totalmarks() greater or equal 50, 
     *  false if less than and, or "not enough marks" message
     *  if exeption was thrown due to not having sufficient marks for a student
     */

    public boolean passed(){
        if (totalMark() == -1) {
        throw new IllegalArgumentException("Not enough marks to evaluate student"); 
            } else if (totalMark() >= 50){
            return true;
            }else{
            return false;
        }
    } 

    //  main method coded for running in my terminal

    public static void main(String[] args){
        int [] francesMarks = {90 , 57 , 50 , 90 , 50 , 90 , -1 , 50 , 12 , 90 , 50 , 40 , 100 , 100};
        Student frances = new Student("1234", francesMarks);
        frances.setAssignmentMark(5, 90);
        System.out.println(frances);
        
    }
       

}

//Public Junit passed and my Junit passed
