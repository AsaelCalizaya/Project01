package test;

import java.sql.SQLException;

import org.testng.annotations.*;

import framework.bd.*;
import framework.pages.login.LoginPage;

/**
 * 
 * @author Asael Calizaya
 *
 */
public class StartTest {	
	private LoginPage loginPage = new LoginPage();
	private ConnectionBD delete = new ConnectionBD();
	
	/**
	 * Can login into JagdPanther like an administrator
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
    	delete.DeletePerson();
    	delete.DeleteStage();
    	delete.DeletePeriod();
    	delete.DeleteProgram();
    }
}
