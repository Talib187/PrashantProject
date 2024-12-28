package pageObjects;

import java.net.PasswordAuthentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLoginPage extends BasePage {

	public OrangeHRMLoginPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(name = "username")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement btnLogin;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")
	WebElement textDashboard;

	public void enterUsername(String username) {

		txtUserName.sendKeys(username);

	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {

		btnLogin.click();
	}
	
	public boolean checkLoginStatus() {
		
		boolean status = textDashboard.isDisplayed();
		return status;
	}
}
