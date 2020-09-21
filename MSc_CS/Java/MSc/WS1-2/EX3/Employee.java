
/** 
 *  Employee is a class for an Employee accounting file where you get some 
 *  financial data from the employee (name, monthly gross salary and tax rate
 *  and in which the salary may be updated with a new figure once an increase
 *  rate has been given.
 * 
 *  @author: Frances Adriana Laureano De Leon
 *  @version: 23/10/18
 */


public class Employee{

    private String name;
    private double monthlyGrossSalary;
    public double taxRate;

/** 
 *  This is my constructor for making an employee file with 3 pieces of info.
 *  @param name is employee name as string
 *  @param monthlyGrossSalary is employee's gross salary as double
 *  @param taxRate is employee's tax rate as double
 */

    public Employee(String name, double monthlyGrossSalary, double taxRate){
        this.name = name;
        this.monthlyGrossSalary = monthlyGrossSalary;
        this.taxRate = taxRate;
    }

    /**
     *  Returns name as String
     */
    public String getName(){
        return name;
    }

    /** 
     *  Returns monthly gross salary as double
     */
    public double getMonthlyGrossSalary(){
        return monthlyGrossSalary;
    }
    
    /** 
     *  Returns tax rate as double
     */

    public double getTaxRate(){
        return taxRate;
    }

    /** 
     *  Allows me to set the value of name
     *  @param name for the changed name, if it happens
     */

    //  Originally I did not make a setter for name because I thought a name
    // would not change, but then what if someone gets married and the name
    //  actually changed. Thought I should be safe, if that is the case.
   
    public void setName(String newName){
        name = newName;
    }   

    /** 
     *  Allows me to set the value of monthly gross salary
     *  @param monthlyGrossSalary for the changed monthly gross salary
     */

    public void setMonthlyGrossSalary(double newMonthlyGrossSalary){
        monthlyGrossSalary = newMonthlyGrossSalary;
    }

    /** 
     *  Allows me to set the value of tax rate
     *  @param taxRate for the changed tax rate, if it happens
     */

    public void setTaxRate(double newTaxRate){
        taxRate = newTaxRate;
    }

    /*
     *  Allows me to show what is the salary after taxes
     *  returns net salary by deducting taxes money from gross salary as a double
     */ 

    public double getMonthlyNetSalary(){
        return monthlyGrossSalary - (monthlyGrossSalary * taxRate/100);
    }

    /*
     *  Changes the value of monthlyGrossSalary for an employee when they have 
     *  a raise.
     *  @param monthlyGrossSalary for updated monthly gross salary.
     */

    public void increaseSalary(double rate){
        monthlyGrossSalary =  monthlyGrossSalary * (rate/100) + monthlyGrossSalary;
    }

    /*
     * return defines how the print statement for Employee will look like
     */

    public String toString(){
        return name + "" + " has a monthly gross salary of  \u00A3 " + monthlyGrossSalary + "" + ", a taxrate of " + taxRate + "" + "%, and a monthly net salary of \u00A3 " + getMonthlyNetSalary() + ".";
    }

    /*
     *  I made a main method to run my program though I know that it is not 
     *  necessary for the assignment just to personally see how the program runs
     */
 
    public static void main(String[] args){
        Employee John = new Employee("John", 2400, 20);
        System.out.println(John);
        John.increaseSalary(1); 
        System.out.println(John);
    }
}

//  passed Junit tests by Manfred and also passed my Junit
//  tests. I used P. Manfred's tests as a template for mine.
