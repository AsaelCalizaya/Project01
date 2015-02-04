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
public class NewUserPage {
	WebDriver driver;
	
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
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public UsersPage clickSaveButton() {
		buttonSave.click();
		return new UsersPage();
	}
	
	public NewUserPage setCI(String ci) {		
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	public NewUserPage setName(String name) {
		textBoxName.sendKeys(name);
		return this;
	}

	public NewUserPage setLastName(String lastName) {
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	public NewUserPage setEmail(String eMail) {
		textBoxEmail.sendKeys(eMail);
		return this;
	}
	
	public UsersPage createNewUser(String ci, String Name, String Lastname,String email) {
		setCI(ci);
		setName(Name);
		setLastName(Lastname);
		setEmail(email);
		return clickSaveButton();			
	}
}