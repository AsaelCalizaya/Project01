package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.HomePage;
import framework.pages.period.PeriodDetailsPage;
import framework.utils.DataProviderClass;

/**
 * Title: Register new applicant-JagdPanther allows create new applicants
 * @author Asael Calizaya
 *
 */
public class VerifyIfApplicantWasCreated {
	
	/**
	 * Description: This test case verifies that JagdPanther allows create new 
	 * applicants to a period when press on "nuevo postulante"
	 * @param ci
	 * @param name
	 * @param lastName
	 * @param eMail
	 * @param cellphone
	 */
	@Test(dataProvider = "ApplicantDataXlsx",dataProviderClass = DataProviderClass.class)
	public void createApplicant(String ci,String name,String lastName,String eMail,String cellphone) {
		HomePage home = new HomePage();
		PeriodDetailsPage periodDetail = home
				.clickPeriodLink()
				.clickEditButton()
				.clickApplicantButton()
				.clickNewApplicantButton()
				.createApplicant(ci, name, lastName, eMail, cellphone);		
		Assert.assertTrue(periodDetail.getAllAplicants().contains(eMail));			
	}
}
