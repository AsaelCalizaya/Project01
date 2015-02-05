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
public class NewUserPage implements INavigation {
	@FindBy(id="j_id_t:inputCi")
	WebElement textBoxCI;
	
	@FindBy(id="j_id_t:inputName")
	WebElement textBoxName;
	
	@FindBy(id="j_id_t:inputLastName")
	WebElement textBoxLastName;
	
	@FindBy(id="j_id_t:inputEmail")
	WebElement textBoxEmail;
	
	@FindBy(id="j_id_t:j_id_1d")
	WebElement buttonSave;
	
	public NewUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click on Save button
	 * @return: a New user page
	 */
	public UsersPage clickSaveButton() {
		buttonSave.click();
		return new UsersPage();
	}
	
	/**
	 * Set User CI
	 * @param ci: user CI
	 * @return: returns this page
	 */
	public NewUserPage setCI(String ci) {		
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	/**
	 * Set User Name
	 * @param name: User name
	 * @return: returns this page
	 */
	public NewUserPage setName(String name) {
		textBoxName.sendKeys(name);
		return this;
	}

	/**
	 * Set User LastName
	 * @param lastName: User lastName
	 * @return: returns this page
	 */
	public NewUserPage setLastName(String lastName) {
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	/**
	 * Set User Email
	 * @param eMail: user email
	 * @return: returns this page
	 */
	public NewUserPage setEmail(String eMail) {
		textBoxEmail.sendKeys(eMail);
		return this;
	}
	
	/**
	 * Create a new user with following parameters
	 * @param ci: User CI
	 * @param Name: User name
	 * @param Lastname: User lastName 
	 * @param email: User email
	 * @return: The users page 
	 */
	public UsersPage createNewUser(String ci, String Name, String Lastname,String email) {
		setCI(ci);
		setName(Name);
		setLastName(Lastname);
		setEmail(email);
		return clickSaveButton();			
	}
}