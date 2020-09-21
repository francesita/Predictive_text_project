package EX2;

/**
 *   Concrete class Invoice implements interface Measurable. 
 *   Method from interface getValue() is implemented
 *   
 *   @author Frances Adriana Laureano De Leon
 *   @version 2018-11-18
 */
public class Invoice implements Measurable{

    private String accountNumber;
    private String sortCode;
    private double amount;

    /**
     *   Constructor of class Invoice which creates Invoice object 
     *   
     *   @param accountNumber is the account number attached to the invoice
     *   @param sortCode is the sort code attached to each patient
     *   @param amount is the amount that needs to be paid outlined in the invoice
     */
    public Invoice(String accountNumber, String sortCode, double amount){
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.amount = amount;
    }

    /** 
     *  getter for the account number
     *  @return accountNumber for each invoice 
     */
    public String getAccountNumber(){
        return accountNumber;
    }

    /** 
     *  getter for the sort code
     *  @return sortCode for each invoice 
     */
    public String getSortCode(){
        return sortCode;
    }

    /** 
     *  getter for the amount
     *  @return amount due for each invoice 
     */
    public double amount(){
        return amount;
    }

    /** 
     *  setter for the account number
     *  @param newAccountNumber is the account number for the invoice
     */
    public void setAccountNumber(String newAccountNumber){
        accountNumber = newAccountNumber;
    }

    /** 
     *  setter for the sort code
     *  @param newSortCode is the new sort code for the invoice
     */
    public void setSortCode(String newSortCode){
        sortCode = newSortCode;
    }

    /** 
     *  setter for the amount
     *  @param newAmount is the new amount for the invoice
     */
    public void setAmount(double newAmount){
        amount = newAmount;
    }

    /** 
     *  Method from interface Measurable
     *  @return amount due for invoice
     */
    @Override
    public double getValue(){
        return amount;
    }

    /** 
     *  toString method for Patient class
     *  @return a printable string for Invoice
     */
    public String toString(){
        return "Account Number"+ "\n" + accountNumber + "Sort Code: " + "\n" + sortCode + "Amount due: " + "\n" + amount;
    }
}
