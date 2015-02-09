package test;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.pages.HomePage;
import framework.pages.period.PeriodDetailPage;
import framework.utils.DataProviderClass;

/**
 * Title: Register new applicant-JagdPanther allows create new applicants
 * @author Asael Calizaya
 *
 */
public class VerifyIfApplicantWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Create precondition to create an applicant
	 * @throws SQLException
	 */
	@BeforeClass
	public void createProgram() throws SQLException {
		con.CreateProgram("1", "program1", "program1", "description1");
		con.CreatePeriod("1", "2015-02-02", "period1", "Active", "1");
	}
	
	/**
	 * Description: This test case verifies that JagdPanther allows create new 
	 * applicants to a period when press on "nuevo postulante"
	 * @param ci: applicant CI
	 * @param name: applicant Name
	 * @param lastName: applicant LastName
	 * @param eMail: applicant Email
	 * @param cellphone: applicant CellPhone
	 */
	@Test(dataProvider = "ApplicantDataXlsx",dataProviderClass = DataProviderClass.class)
	public void createApplicant(String ci,String name,String lastName,String eMail,String cellphone) {
		HomePage home = new HomePage();
		PeriodDetailPage periodDetail = home
				.clickPeriodLink()
				.clickEditButton()
				.clickApplicantButton()
				.clickNewApplicantButton()
				.createApplicant(ci, name, lastName, eMail, cellphone);		
		Assert.assertTrue(periodDetail.getAllAplicants().contains(eMail));			
	}
	
	/**
	 * Delete all applicants on BD
	 * @throws SQLException
	 */
	@AfterClass
	public void deleteData() throws SQLException {
		con.DeletePerson();
		con.DeletePeriod();
		con.DeleteProgram();
	}
}
