package EX3;

/**
 *  BankAccountStandardUser is a subclass of bankAccountUser which implements 
 *  BankAccountStandardUserInterface
 *  
 *  @author Frances Adriana Laureano De Leon
 *  @version 2018-11-22
 *
 */

public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface{

    private BankAccount bankAccount;
    private int loginAttempts;

    /**
     *  Constructor for BankAccountUser which creates object BankAccountUser
     *  
     *  @param username as string which is the usename for someone logging into bankAccount
     *  @param password is a string and is the password for the online banking login
     *  @param bankAccount is of type BankAccount
     */

    public BankAccountStandardUser(String username, String password,  BankAccount bankAccount){
        super(username, password);
        this.bankAccount = bankAccount;
        loginAttempts = 0;
    }

    /**
     *  Getter method for bankAccount implemented from interface 
     *  @return bankAccount for a standard user
     */
 
    @Override
    public BankAccount getBankAccount(){
        return bankAccount;
    }

    /**
     *  Method for login for bankAccount implemented from interface 
     *  This method checks that account still
     *  eligible for password tries. If password correct loginAttempt reset
     *  if not, then we increment attempts by one and do not allow user to login
     *
     *   @param password as a string. 
     */

    @Override
    public void login(String password){
    	if(getLoginAttempts() >= 3) { //	too many attempts do rest later
    		setLoggedIn(false);
    	}else if(passwordCorrect(password) == true) {
    		resetLoginAttempts();
    		setLoggedIn(true);
    	}else {
    		setLoginAttempts(getLoginAttempts() + 1);
    		setLoggedIn(false);
    	}
    }

    /**
     *   Getter method for login attempts implemented from interface
     *   @returns loginAttemts
     */

    @Override
    public int getLoginAttempts(){
        return loginAttempts;
    }

    /**
     *   Setter method for login attempts implemented from interface
     *   @param newLoginAttempts, it changed the value for loginAttempts with new value
     */
    
    @Override
    public void setLoginAttempts(int newLoginAttempts){
    	loginAttempts = newLoginAttempts;
    }

    /**
     *   resetter method for login attempts implemented from interface
     */

    @Override
    public void resetLoginAttempts(){
        setLoginAttempts(0);
    }

    /**
     *  transferMoney method implemented from interface
     *  if user is logged in it calls a method from the bankAccount class
     *  that transfers the money, adjusts the balances of the accounts
     *  and checks that enough money is in the account before the transfer
     *
     *  @param toAccount is bankAccount money will be transferred to
     *  @param amount as long is the amount of money that will be trandferred from one
     *  account to the other
     *  @param password as a string, for the bankAccount user
     *
     */

    
    @Override
    public void transferMoney(BankAccount toAccount, long amount, String password){
    	if(getLoggedIn() == true) {
        bankAccount.transferMoney(toAccount, amount, password);
    	}
    }			
        
    
    /** 
     * The method prints the balance assumed that the user is logged in,
     * else a corresponding message.
     */

	@Override
	public void printBalance() {
		 if(getLoggedIn() == true){
	          bankAccount.printBalance();
		 }else {
			 System.out.println(" Please login if you wish to know your balance.");
		 }
	}

    /** 
     * The method prints a statement if the user is logged in,
     * else a request to first log in is printed.
     */

	public void printStatement() {
		if (getLoggedIn() == true) {
			bankAccount.printStatement();
		}else {
			System.out.println("You need to login to print statement");
		}	
	}  	
}
