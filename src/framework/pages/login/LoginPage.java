package framework.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.users.UsersPage;
import framework.utils.SeleniumDriverManager;
import framework.utils.Globals;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="j_id_i:j_id_q") 
	WebElement buttonLogin;
	
	@FindBy(id="j_id_i:userName") 
	WebElement textBoxUser;
	
	@FindBy(id="j_id_i:password") 
	WebElement textBoxPassword;
	
	/**
	 * This method is to get the URL to run the test
	 */
	public LoginPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		driver.get(Globals.URL);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Login with the following parameters
	 * @param user: user name
	 * @param pass: password
	 * @return: return the users page
	 */
	public UsersPage login(String user , String pass) {
		textBoxUser.sendKeys(user);
		textBoxPassword.sendKeys(pass);
		buttonLogin.click();
		return new UsersPage();
	}

	/**
	 * Verify if the user name if correct
	 * @param userName: user name
	 * @return: return a boolean value
	 * True when the user name is correct
	 * False when the user name is incorrect
	 */
	public Boolean getResult(String userName) {
		return driver.findElement(By.linkText(userName)).isEnabled();
	}

	/**
	 * This method is to quit the driver
	 */
	public void quit() {
		driver.quit();
	}
}