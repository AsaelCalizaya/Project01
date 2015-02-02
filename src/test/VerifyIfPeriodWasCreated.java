package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.period.PeriodDetailsPage;
import framework.pages.programs.ProgramDetailPage;
import framework.utils.DataProviderClass;

/**
 * Title: Verify that a new period can be created in a program
 * @author Asael Calizaya
 *
 */
public class VerifyIfPeriodWasCreated {

	/**
	 * Description:This test case is to verify that a period can be created to a program
	 * @param name
	 * @param startDate
	 */
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
		Assert.assertTrue(detailPage.getPeriodName().contains(name));
	}
}