/** BankAccount is a class for a program that will create a bank account with   
 *  an account number, will display a balance and will subtract a set-up fee
 *
 *  @author Frances Adriana Laureano De Leon
 *  @version 23/10/18
 */

public class BankAccount{

    private int accountNumber;
    private int balance;
    private int setupFee;

    /** 
     *  This is my BankAccount constructor which takes in three arguments 
     *
     *  @param accountNumber takes in an account number as an integer
     *  @param balance takes in the balance as an integer subtacted by initial
     *  set-up fee as an integer
     *  @param set-up fee takes in the set-up fee as an integer
     */

    public BankAccount(int accountNumber, int balance, int setupFee){
        this.accountNumber = accountNumber;
        this.balance = balance - setupFee;
        this.setupFee = setupFee;
    }

    /** 
     *  returns accountNumber as integer
     */

    public int getAccountNumber(){
        return accountNumber;
    }

    /** 
     *  returns balance as integer
     */

    public int getBalance(){
        return balance;
    }

    /** 
     *  returns setupFee as integer
     */

    public int getSetupFee(){
        return setupFee;
    }

    /** 
     *  Sets the value for balance
     *  balance is for changed balance value
     */

    public void setBalance(int newBalance){
        balance = newBalance;
    }

    //  only wrote one set method because the set-up fee should not change or be
    //  charged after the initial setting up of the account.


    /** 
     *  toString method will print BankAccount in the specified style
     */

    public String toString(){
        return "Account Number: " + accountNumber +
                " Set up fee: " + setupFee +
                " Balance: " + balance;
    }

    public static void main(String[] args){
        BankAccount maryBankAccount = new BankAccount(54, 100, 20);
        System.out.println(maryBankAccount);
    }
}

//  All of my Junit passed for Manfred's tests as well as mine
