package EX3;
import java.util.ArrayList;

/**
 *  BankAccountAdministratoris a subclass of bankAccountUser which implements 
 *  BankAccountAdministratorInterface
 *  
 *  @author Frances Adriana Laureano De Leon
 *  @version 2018-11-22
 *
 */

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface {

	private ArrayList<BankAccountUser> bankAccountUsers;
	
    /**
     *  Constructor for BankAccountUser which creates object BankAccountUser
     *  
     *  @param username as string which is the usename for someone logging into bankAccount
     *  @param password is a string and is the password for the online banking login
     *  @param bankAccountUsers as arrayList of all the bankAccountUser accounts
     */

	public BankAccountAdministrator(String username, String password) {
		super(username, password);
		this.bankAccountUsers = new ArrayList<BankAccountUser>();
	}
		
    /**
     *  Method for an adminstrator to log by providing a password. 
     *  it checks to make sure correct password is entered
     *
     *  @param password The password provided for the login
     */

    @Override
    public void login(String password){
        if( passwordCorrect(password) == true){
        	setLoggedIn(true);
        }else {
        	setLoggedIn(false);
        }
    }    


    /**
     *  Add a user to the list of all users who are in the
     *  responsibility of the administrator.
     *  @param user The user to be added to the responsibility of the
     *  adminstrator.
     */

	@Override
	public void addUser(BankAccountUser user) {
		if ( bankAccountUsers.contains(user)) {     //   I have it check whether user already exists in order to avoid duplicates
		System.out.println("User already exists");
		}else {
		bankAccountUsers.add(user);     //  If user does not exist then they are added to the list
		System.out.println("User has been added to list");
		}

	}

    /**
     *  This method allows the administrator to
     *  reset the account by setting a new password and resetting
     *  the number of failed login attempts to zero.
     *  @param bankAccountUser The bank account user for whom the
     *  account is to be reset.
     *  @param password The new password for the account that is to be
     *  reset.
     */

	@Override
	public void resetAccount(BankAccountUser bankAccountUser, String password) {
		if(getLoggedIn()==true) {
			bankAccountUser.setPassword(password);
			//  bracket is not placed here so that following part of the code cannot be done unless user is logged in
		if (bankAccountUser instanceof BankAccountStandardUser) {
			 ((BankAccountStandardUser) bankAccountUser).resetLoginAttempts();
			}
		}
	}

}

