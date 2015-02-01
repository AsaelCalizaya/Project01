package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.period.PeriodDetailsPage;
import framework.pages.programs.ProgramDetailPage;
import framework.utils.DataProviderClass;

/**
 * Title: 
 * @author Asael Calizaya
 *
 */
public class VerifyIfPeriodWasCreated {

	
	@Test(dataProvider = "PeriodDataXlsx",dataProviderClass = DataProviderClass.class)
	public void createPeriod(String name, String startDate) {
		ProgramDetailPage programDetail = new ProgramDetailPage();
		PeriodDetailsPage detailPage = programDetail
				.clickProgramLink()
				.clickDetailProgram()
				.clickPeriodButton()
				.clickAddNewPeriodButton()
				.setPeriodName(name)
				.setStartPeriodDate(startDate);
    	System.out.println(detailPage.getPeriodName() + "---" + name);
		Assert.assertTrue(detailPage.getPeriodName().contains(name));
	}
}