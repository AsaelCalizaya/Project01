package framework.pages.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.utils.SeleniumDriverManager;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class UsersPage {
	WebDriver driver;
	
	@FindBy(id = "j_id_t:j_id_16")
	WebElement newUserButton;
	
	@FindBy(id = "j_id_t:AllUserTable_data")
	WebElement userTable;
	
	public UsersPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public NewUserPage clickAddNewUserButton() {
		newUserButton.click();
		return new NewUserPage();
	}
	
	public String getUsers() {
		return userTable.getText();
	}
}