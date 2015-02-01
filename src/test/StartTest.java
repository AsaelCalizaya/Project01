package test;

import java.sql.SQLException;

import org.testng.annotations.*;

import framework.bd.*;
import framework.pages.login.LoginPage;

public class StartTest {
	private LoginPage loginPage = new LoginPage();
	private ConnectionBD delete = new ConnectionBD();
	
	@BeforeSuite
	public void init() {
		loginPage.login("admin@admin.com","admin11");
	}
	
	@AfterSuite
    public void quit() throws SQLException{
    	loginPage.quit();
    	
    	delete.DeletePerson();
    	delete.DeleteStage();
    	delete.DeletePeriod();
    	delete.DeleteProgram();
    }
}
