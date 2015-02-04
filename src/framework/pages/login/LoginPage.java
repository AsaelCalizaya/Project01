package framework.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.users.UsersPage;
import framework.utils.SeleniumDriverManager;

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
		driver.get("http://localhost:8080/");
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public UsersPage login(String user , String pass) {
		textBoxUser.sendKeys(user);
		textBoxPassword.sendKeys(pass);
		buttonLogin.click();
		return new UsersPage();
	}

	/**
	 * 
	 * @param userName
	 * @return
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
