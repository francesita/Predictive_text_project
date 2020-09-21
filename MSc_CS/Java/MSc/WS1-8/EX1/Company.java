import java.util.ArrayList;

/**
 *  Company class increases the salary of all employees in the class employee
 *  This class will be able to do this for all employees by using the 
 *  arrayList created of all employees. 
 *
 *  @author Frances Adriana Laureano De Leon
 *  @version 1/12/18
 *
 */

public class Company{
	
	/**
	 * Field variable contains an arrayList of type Employee
	 */
	
	private ArrayList<Employee> employees;

    public Company() {
		this.employees = new ArrayList<Employee>();
	}

    public ArrayList<Employee> getEmployees(){
    	return employees;
    }
    
    public void setEmployees(ArrayList<Employee> newEmployees){
    	employees = newEmployees;
    }
    
    /**
     *  Void method that increases salary of employees regardless of type of 
     *  employee. Method calls increase salary methods in employee subclasses
     *
     *  @param  rate salary will be increased by
     */
    
    public void increaseSalaries(double rate){
        for(Employee el: employees){
        	el.increaseSalary(rate);
        }
    }
    /**
     * This methods checks that an employee that already exists is not added
     * it is also the method that adds employees to the list. 
     * @param e as the employee of type Employee
     */

    public void add(Employee e) {
    	boolean verdict = false;
    	if (employees.size() == 0) {    //  checks if array is empty
    		verdict = false;
    	}else if (employees.size() > 0){    //  checks if array larger than 0, though this may not really be necessary  
    		for(int i = 0; i < employees.size(); i++) { 
    			if(employees.get(i).getnI().equals(e.getnI())) {    //  checks if employee is already in the list by comparing NI numbers, if yes verdict true, nothing added
    				verdict = true;
    			}
    		}
    	} 
    	if (verdict == false) { //  if false, adds employee to the list
    		employees.add(e);
    	}
    }
    		
    /**
     * Formats the array list so that it prints	
     */

    public String toString() {
		for (Employee elem: employees) {
			return elem + "\n" + "\n";
		}
		return "";
    }
}
