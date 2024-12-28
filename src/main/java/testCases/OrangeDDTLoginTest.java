package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeHRMLoginPage;
import utilities.DataProviders;

public class OrangeDDTLoginTest extends BaseClass {

	

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class) 
	
	public void VerifyLoginDDt(String uname, String pwd) {

		try {

			OrangeHRMLoginPage olp = new OrangeHRMLoginPage(driver);

			olp.enterUsername(uname);
			olp.enterPassword(pwd);
			olp.clickLogin();

			boolean status = olp.checkLoginStatus();

			if (status == true) {

				Assert.assertTrue(true);

			}

			else {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
