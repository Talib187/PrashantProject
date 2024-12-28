package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.dateUtils;
import utilities.dateUtils.DateUtils;

public class CalendarPage extends BasePage {

	public CalendarPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@title=\"Select Departure date for availability\"]")

	WebElement clickOnDate;

	public void clickOndate() {

		String futureDate = DateUtils.getDateAfter30Days();
		clickOnDate.sendKeys(futureDate);

		clickOnDate.click();
	}

}
