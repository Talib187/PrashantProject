package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CalendarPage;

public class CalendarTest extends BaseClass {

	@Test
	public void verifyLogin() {

		logger.info("********** Starting TC_002Login Test**************");

		try {

			CalendarPage cp = new CalendarPage(driver);
			
			cp.clickOndate();

				}

		catch (Exception e) {

			System.out.println(e);
			Assert.fail();
		}

		logger.info("********** Finished TC_002Login Test **************");

	}
}
