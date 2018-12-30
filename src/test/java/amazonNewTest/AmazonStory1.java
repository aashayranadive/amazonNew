package amazonNewTest;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import amazonapp.pages.Category;
import amazonapp.pages.Hamburger;
import amazonapp.pages.HomePage;
import amazonapp.pages.KindlePage;
import amazonapp.util.BaseTest;
import amazonapp.util.commonPath;

@Listeners(amazonapp.util.listener.class)

public class AmazonStory1 extends BaseTest{


	@Test 	(description = "Amazon Test For Kindle Shopping")
	public void KindleShopping_Test() throws Exception {
		HomePage homepage = new HomePage(driver);
		Hamburger hamburger = new Hamburger(driver);
		Category category = new Category(driver);
		KindlePage kindlePage = new KindlePage(driver);

		//Test Begins

		test = report.startTest("Amazon Test For Kindle E-Reader Shopping");

		//Step 1: Tap on Hamburger Button.
		homepage.tapHamburgerButton();
		//Step2: Select Shop by Category Option.
		hamburger.tapShopByCategory(); 
		Thread.sleep(5000);
		category.tapKindleCat();
		//Step4: Select Kindle E-Reader
		category.selKindleEreader();
		//Step5: Choose Kindle Voyage
		kindlePage.selectKindleBasic();
	}

@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			commonPath.getScreenshot(getDriver(),result.getName());
		}
	}
}

