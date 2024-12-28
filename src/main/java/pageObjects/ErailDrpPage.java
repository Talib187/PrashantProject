package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.dateUtils;
import utilities.dateUtils.DateUtils;

public class ErailDrpPage extends BasePage {

	public ErailDrpPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"txtStationFrom\"]")
	WebElement txtFrom;

	@FindBy(xpath = "//*[@id=\"txtStationFrom\"]")
	WebElement txtTo;

	@FindBy(xpath = "//div[contains(@id, 'AutocompleteContainter')]/div/div/div[4]")
	WebElement drop4th;

	@FindBy(xpath = "//div[contains(@id, 'AutocompleteContainter')]/div/div/div")
	List<WebElement> drpList;
	
	@FindBy (xpath = "//input[@title=\"Select Departure date for availability\"]")
	WebElement clickOnDate;
	


	public void enterFromStation() {

		txtFrom.clear();
		txtFrom.sendKeys("DEL");
	}

	public void select4thDrp() {

		drop4th.click();
		System.out.println("Selected dropdown is : " + drop4th.getAttribute("title"));

	}

	public List<String> getListFromDrp() {

		List<String> valueDrpList = new ArrayList<String>();

		for (WebElement drpEle : drpList) {
			// System.out.println(ele.getAttribute("title"));

			valueDrpList.add(drpEle.getAttribute("title"));
		}

		return valueDrpList;
	}
	
	public void clickOndate() {
		clickOnDate.click();
	}
	
	public void selectFutureDate() {

	String futureDate = DateUtils.getDateAfter30Days();
	
    String xpath = "//input[@title='Select Departure date for availability' and @value='" + futureDate + "']";
    
    WebElement selFutureDate = driver.findElement(By.xpath(xpath));
    
    selFutureDate.click();

	
	}
}
