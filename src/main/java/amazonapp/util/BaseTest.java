package amazonapp.util;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import amazonapp.util.commonPath;

import io.appium.java_client.AppiumDriver;

public class BaseTest {

	protected static AppiumDriver<WebElement> driver;
	public ExtentReports report;
	public static ExtentTest test;
	public Logger Log = Logger.getLogger(Logger.class.getName());


	@BeforeSuite
	public void setup() throws Exception
	{
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Galaxy Grand Prime");
		cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");		
		cap.setCapability("noReset", "true");
		try {
			driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		catch (Exception e) {
		}

	}
	public AppiumDriver<WebElement> getDriver() {
		return driver;
	}

	@BeforeClass
	public void startTest(){
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	}


	@AfterClass
	public void endTest(){
		report.endTest(test);
		report.flush();
	}




}
