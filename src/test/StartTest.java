package test;

import java.sql.SQLException;

import org.testng.annotations.*;

import framework.pages.login.LoginPage;
import framework.utils.reporter.JyperionListener;

/**
 * 
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class StartTest {	
	private LoginPage loginPage = new LoginPage();
	
	/**
	 * Can login into JagdPanther like an administrator
	 * @throws SQLException 
	 */
	@BeforeSuite
	public void init() {
		loginPage.login("admin@admin.com","admin11");
	}
	
	/**
	 * Can logout of JagdPanther
	 * Also delete all data from data base except the Admin user
	 * @throws SQLException
	 */
	@AfterSuite
    public void quit() throws SQLException {
    	loginPage.quit();    	
    }
}
