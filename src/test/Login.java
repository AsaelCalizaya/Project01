package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.pages.login.LoginPage;

public class Login {
	
	private LoginPage loginPage = new LoginPage();

	@Test
	public void verifyLogin() {

		loginPage.login("admin@admin.com","admin11");
		Assert.assertTrue(loginPage.getResult("Admin Admin"));
		loginPage.quit();
	}

}
