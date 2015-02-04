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
	 * 
	 * @return
	 */
	public UsersPage clickSaveButton() {
		buttonSave.click();
		return new UsersPage();
	}
	
	/**
	 * 
	 * @param ci
	 * @return
	 */
	public NewUserPage setCI(String ci) {		
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public NewUserPage setName(String name) {
		textBoxName.sendKeys(name);
		return this;
	}

	/**
	 * 
	 * @param lastName
	 * @return
	 */
	public NewUserPage setLastName(String lastName) {
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	/**
	 * 
	 * @param eMail
	 * @return
	 */
	public NewUserPage setEmail(String eMail) {
		textBoxEmail.sendKeys(eMail);
		return this;
	}
	
	/**
	 * 
	 * @param ci
	 * @param Name
	 * @param Lastname
	 * @param email
	 * @return
	 */
	public UsersPage createNewUser(String ci, String Name, String Lastname,String email) {
		setCI(ci);
		setName(Name);
		setLastName(Lastname);
		setEmail(email);
		return clickSaveButton();			
	}
}