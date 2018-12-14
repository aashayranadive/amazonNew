package amazonapp.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

public class commonPath extends mainDriver {
	//protected AppiumDriver<WebElement> driver;
	public ExtentTest test;
	public ExtentReports report ;
	public Logger Log = Logger.getLogger(Logger.class.getName());
	protected AppiumDriver<WebElement> driver;

	public void driver() {
		this.driver = super.getDriver();
	}

/*	@BeforeClass
	public void startTest(){
		report = new ExtentReports(System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
		test.getDescription();
		return;
	}

	@AfterClass
	public void endTest(){
		report.endTest(test);
		report.flush();
	}*/
	
	

	/*@BeforeTest
	public void TestCase() {
		test = report.startTest("Amazon Test For Kindle E-Reader Purchase");
		return;
	}*/
	
	//Capture Screenshot
	public static String getScreenshot(AppiumDriver<WebElement> driver) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void reporting(String Description, String Expected, String Actual, String StepStatus) throws Exception {
		String screenshotPath = getScreenshot(driver);
		if(StepStatus.toLowerCase().contains("pass")) {
			test.log(LogStatus.PASS, Description,Actual);
		}
		else if (StepStatus.toLowerCase().contains("fail")) {
			test.log(LogStatus.FAIL, Description,Actual);
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
	}



}
