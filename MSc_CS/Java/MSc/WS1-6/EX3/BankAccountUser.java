package EX3;

/**
 *  BankAccountUser is an abstract class which implements BankAccountUserInterface
 *
 *  @author Frances Adriana Laureano De Leon
 *  @version 2018-11-19
 *
 */

public abstract class BankAccountUser implements BankAccountUserInterface{
    
    private String username;
    private String password;
    private boolean loggedIn;

    /**
     *  Constructor for BankAccountUser which creates object BankAccountUser
     *  
     *  @param username as string which is the usename for someone logging into bankAccount
     *  @param password is a string and is the password for the bankaccount login
     *  
     */

       public BankAccountUser(String username, String password){
        this.username = username;
        this.password = password;
        loggedIn = false;
    }
    
    public String getUsername() {
    		return username;
    }

    private String getPassword() {
    	return password;
    }

	public void setUsername(String newUsername){
        username = newUsername;
    }
	

    /**
     *  Setter for the password.
     *  @param password The new password.
     */
	
    @Override
    public void setPassword(String newPassword){
        password = newPassword;
    }

    /**
     *  Setter for the password.
     *  @param password The new password.
     */

    @Override
    public void setLoggedIn(boolean newLoggedIn){
    	loggedIn = newLoggedIn;
    }
    
    /**
     *  Getter to check whether a user is logged in.
     *  @return true if the user is looged in, false else.
     */

    @Override
    public boolean getLoggedIn(){
        return loggedIn;
    }
 
     /**
     *  @param password as string. This password will be compared to
     *  the password stored on the system.
     */

    @Override
    public void login(String password){             
        if(getPassword().equals(password)){
        	setLoggedIn(true);
        }
    }

    /**
     *  sets loggedIn to false if user is logged in and not longer wants to be
     */

	@Override
    public void logout(){
        if(getLoggedIn() == true) {
        	setLoggedIn(false);
        }
    }

    /**
     * The method checks whether a provided password is correct.
     * @param password A password string that is to be compared to the
     * stored password.
     * @return true if the provided password is equal to the stored
     * password, else false.
     */

    @Override
    public boolean passwordCorrect(String password){
    	boolean x;
    	if(this.password.equals(password)){
            x = true;
        }else {   
        	x = false;
        }
    	return x;
    }
}
