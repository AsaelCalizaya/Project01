package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.period.PeriodDetailsPage;
import framework.utils.DataProviderClass;

public class VerifyIfApplicantWasCreated {
	
	
	@Test(dataProvider = "ApplicantDataXlsx",dataProviderClass = DataProviderClass.class)
	public void createApplicant(String ci,String name,String lastName,String eMail,String cellphone) {
		
		PeriodDetailsPage periodDetails = new PeriodDetailsPage();
		PeriodDetailsPage periodDetail = periodDetails
				.clickPeriodLink()
				.clickEditButton()
				.clickApplicantButton()
				.clickNewApplicantButton()
				.createApplicant(ci, name, lastName, eMail, cellphone);		
		Assert.assertTrue(periodDetail.getAllAplicants().contains(eMail));			
	}
}
