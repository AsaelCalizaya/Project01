package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.navigation.Navigation;
import framework.pages.users.UsersPage;
import framework.utils.DataProviderClass;
/**
 * Title: Verify that a new user can be created
 * @author Asael Calizaya
 *
 */
public class VerifyIfUserWasCreated {
	/**
	 * Description: This test case is to verify that a new user can be created when
	 * "Aniadir" button in users page is pressed
	 * @param ci
	 * @param name
	 * @param lastName
	 * @param email
	 */
    @Test(dataProvider = "UsersDataXlsx", dataProviderClass = DataProviderClass.class)
    public void createNewUser(String ci, String name, String lastName, String email) {
	    Navigation navigation = new Navigation();  
	    UsersPage users = navigation
	    	.clickUsersLink()
	    	.clickAddNewUserButton()
	    	.createNewUser(ci, name, lastName, email);
	    Assert.assertTrue(users.getUsers().contains(name));
    }
}
