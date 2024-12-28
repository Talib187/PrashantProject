package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public  Logger logger;
	public WebDriver driver;
	public Properties prop;
	public static ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	public void setUp() throws IOException {

		// Loading config.properties fiel

		FileReader file = new FileReader("C:\\Users\\mtali\\eclipse-workspace\\opencart\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);

		logger = LogManager.getLogger(this.getClass());

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		
	//m	driver.get("https://opensource-demo.orangehrmlive.com/");


		logger.info("URL entered in the browser.");

	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String trgPath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "-" + timeStamp + ".png";
		File trg = new File(trgPath);

		src.renameTo(trg);

		return trgPath;

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
