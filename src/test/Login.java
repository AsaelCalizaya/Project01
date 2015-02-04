package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.login.LoginPage;

/**
 * Title: Verify that an administrator can login
 * @author Asael Calizaya
 *
 */
public class Login {
	
	private LoginPage loginPage = new LoginPage();

	/**
	 * This test case is to verify that an Administrator can login with his account
	 */
	@Test
	public void verifyLogin() {
		loginPage.login("admin@admin.com","admin11");
		Assert.assertTrue(loginPage.getResult("Admin Admin"));
		loginPage.quit();
	}

}
