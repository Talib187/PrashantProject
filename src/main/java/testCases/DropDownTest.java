package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ErailDrpPage;
import utilities.ErailXLUtils;

public class DropDownTest extends BaseClass {

	@Test
	public void verifyDropdowns() {

		logger.info("********** Starting TC_002Login Test**************");

		try {

			ErailDrpPage lp = new ErailDrpPage(driver);

			lp.enterFromStation();
			lp.select4thDrp();
			List<String> drpValues = lp.getListFromDrp();

			for (String drpValue : drpValues) {
				System.out.println(drpValue);
			}

			String filePath = ".//testData//ExpectedStations.xlsx";

			ErailXLUtils xlUtils = new ErailXLUtils(filePath);
			// xlUtils.writeListToExcel(drpValues, "ActualStations");

			for (int i = 0; i <= drpValues.size() - 1; i++) {

				String drpValue = drpValues.get(i);
				String ExpectedStation = xlUtils.getCellData("expectedStations", (i + 1), 0);

				if (drpValue.equalsIgnoreCase(ExpectedStation)) {
					// System.out.println("Value in drpoddown: " + drpValue + " MATCHES with value
					// in excel: " + ExpectedStation);

					Assert.assertEquals(drpValue, ExpectedStation, "Both value matched");
				}

				else {

					// System.out.println("Value in drpoddown: " + drpValue + " DOES'NT MATCHES with
					// value in excel: "+ ExpectedStation);

					Assert.assertEquals(drpValue, ExpectedStation, "Both value matched");

				}
			}
		}

		catch (Exception e) {

			System.out.println(e);
			Assert.fail();
		}

		logger.info("********** Finished TC_002Login Test **************");

	}
}
