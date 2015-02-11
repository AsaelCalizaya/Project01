package test;

import java.io.IOException;
import java.sql.SQLException;

import jxl.read.biff.BiffException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import framework.bd.ConnectionBD;
import framework.bd.ManageProgramsSuitSetup;
import framework.pages.HomePage;
import framework.pages.period.PeriodDetailPage;
import framework.utils.DataProviderClass;
import framework.utils.reporter.JyperionListener;

/**
 * Title: Register new applicant-JagdPanther allows create new applicants
 * @author Asael Calizaya
 *
 */
@Listeners(JyperionListener.class)
public class VerifyIfApplicantWasCreated {
	private ConnectionBD con = new ConnectionBD();
	
	/**
	 * Create precondition to create an applicant
	 * @throws SQLException
	 * @throws IOException 
	 * @throws BiffException 
	 */
	@BeforeClass
	public void createProgram() throws SQLException, BiffException, IOException {
		ManageProgramsSuitSetup programCreation = new ManageProgramsSuitSetup();
		programCreation.CreateProgramsBD();
		programCreation.CreatePeriodBD();
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
