package framework.pages.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.INavigation;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class UsersPage implements INavigation{	
	@FindBy(id = "j_id_t:j_id_16")
	WebElement newUserButton;
	
	@FindBy(id = "j_id_t:AllUserTable_data")
	WebElement userTable;
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return
	 */
	public NewUserPage clickAddNewUserButton() {
		newUserButton.click();
		return new NewUserPage();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getUsers() {
		return userTable.getText();
	}
}