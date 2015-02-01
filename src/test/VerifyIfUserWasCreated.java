package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.navigation.Navigation;
import framework.pages.users.UsersPage;
import framework.utils.DataProviderClass;

public class VerifyIfUserWasCreated {
	
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
