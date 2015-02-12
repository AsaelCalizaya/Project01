package test;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.users.UsersPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Verify that a new user can be created
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class VerifyIfUserWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Description: This test case is to verify that a new user can be created when
	 * "Aniadir" button in users page is pressed
	 * @param ci: User CI
	 * @param name: User Name
	 * @param lastName: User LastName
	 * @param email: UserEmail
	 */
    @Test(dataProvider = "UsersDataXlsx", dataProviderClass = DataProviderClass.class)
    public void createNewUser(String ci, String name, String lastName, String email) {
    	HomePage home = new HomePage();  
	    UsersPage users = home
	    	.clickUsersLink()
	    	.clickAddNewUserButton()
	    	.createNewUser(ci, name, lastName, email);
	    Assert.assertTrue(users.getUsers().contains(name));
    }
    
     /**
      * Delete all users except the admin user
      * @throws SQLException
      */
    @AfterMethod
    public void deleteData() throws SQLException {
    	con.DeletePerson();
    }
}
