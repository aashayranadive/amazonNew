package amazonapp.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import amazonapp.util.BaseTest;


public class commonPath extends BaseTest {
	//protected AppiumDriver<WebElement> driver;
	protected static AppiumDriver<WebElement> driver;

	public void driver() {
		this.driver = super.getDriver();
	}


	//Take Screenshot
	public static void getScreenshot(AppiumDriver<WebElement> driver, String TestScreenshots) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return;
		}
	public static void reporting(String Description, String Expected, String Actual, String StepStatus) throws Exception{
		//String screenshotPath = getScreenshot(driver);
		if(StepStatus.toLowerCase().contains("pass")) {
			test.log(LogStatus.PASS, Description, Actual);
		}
		else if (StepStatus.toLowerCase().contains("fail")) {
			test.log(LogStatus.FAIL, Description,Actual);
			//test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}
	}

	
}





