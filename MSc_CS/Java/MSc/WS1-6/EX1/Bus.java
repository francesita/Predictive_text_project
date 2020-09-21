/*
 *  Bus is a subclass of Vehicle
 *
 *  @param fuelConsumption as double
 *
 *  @author Frances Adriana Laureano De Leon
 *  @version 2018/11/15
 */


public class Bus extends Vehicle{

private double fuelConsumption;

    /*
     *  Constructor for subclass Bus which takes 3 parameters
     *  @param passengerNumber takes in passenger number as an integer
     *  @param maxSpeed takes in maximum speed as an integer
     *  @param fuelConsumption takes in fuel consumption as a double
     */

    public Bus(int passengerNumber, int maxSpeed, double fuelConsumption){
        super(passengerNumber, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    }

    /*
     *  Getter for fuelConsumption
     *  Returns fuelConsumption as double
     */    

    public double getFuelConsumption(){
        return fuelConsumption;
    }

    /*
     *  Sets the value for fuelConsumption
     *  @param fuelConsumption is changed fuelConsumption value
     */    

    public void setFuelConsumption(double newFuelConsumption){
        fuelConsumption = newFuelConsumption;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + " Fuel Consumption: " + fuelConsumption;
    }
}

