
/*
 *  Vehicle is a concrete superclass 
 *
 *  @param passengerNumber as int
 *  @param maxSpeed as int
 *  @author Frances Adriana Laureano De Leon
 *  @version 2018/11/15
 */

public class Vehicle{

    private int passengerNumber;
    private int maxSpeed;

  /*
     *  Constructor for class Vehicle which takes 2 parameters
     *  @param passengerNumber takes in passenger number as an integer
     *  @param maxSpeed takes in maximum speed as an integer
     */

    public Vehicle(int passengerNumber, int maxSpeed){
        this.passengerNumber = passengerNumber;
        this.maxSpeed = maxSpeed;
    }

    /*
     *  Getter for passengerNumber.
     *  Returns passengerNumber as int
     */    

    public int getPassengerNumber(){
        return passengerNumber;
    }

    /*
     *  Getter for maxSpeed
     *  Returns maxSpeed as int
     */    
    
    public int getMaxSpeed(){
        return maxSpeed;
    }

    /*
     *  Sets the value for passengerNumber
     *  @param passengerNumber is changed passengerNumber value
     */    
    
    public void setPassengerNumber(int newPassengerNumber){
        passengerNumber = newPassengerNumber;
    }

    /*
     *  Sets the value for maxSpeed
     *  @param maxSpeed is changed maxSpeed value
     */    

    public void setMaxSpeed(int newMaxSpeed){
        maxSpeed = newMaxSpeed;
    }

    /**
     *  toString Method returns specified items as String when printed
     */

    public String toString(){
        return "Passenger Number: " + passengerNumber + "\n" + "Maximum Speed: " + maxSpeed;
    }
}
