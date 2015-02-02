package framework.pages.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.pages.navigation.Navigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class UsersPage extends Navigation{
	
	@FindBy(id = "j_id_t:j_id_16")
	WebElement newUserButton;
	
	@FindBy(id = "j_id_t:AllUserTable_data")
	WebElement userTable;
	
	public NewUserPage clickAddNewUserButton()	{
		newUserButton.click();
		return new NewUserPage();
	}
	
	public String getUsers(){
		return userTable.getText();
	}
}