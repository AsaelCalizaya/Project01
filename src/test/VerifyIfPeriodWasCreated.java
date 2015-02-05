package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.pages.HomePage;
import framework.pages.period.PeriodDetailPage;
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
		HomePage home = new HomePage();
		PeriodDetailPage detailPage = home
				.clickProgramLink()
				.clickDetailProgram()
				.clickPeriodButton()
				.clickAddNewPeriodButton()
				.setPeriodName(name)
				.setStartPeriodDate(startDate);
		Assert.assertTrue(detailPage.getPeriodName().contains(name));
	}
}