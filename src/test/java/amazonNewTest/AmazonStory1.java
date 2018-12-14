package amazonNewTest;

import org.testng.annotations.Test;

import amazonapp.pages.Category;
import amazonapp.pages.Hamburger;
import amazonapp.pages.HomePage;
import amazonapp.pages.KindlePage;
import amazonapp.util.BaseTest;

public class AmazonStory1 extends BaseTest{
		

	@Test 
	public void KindleShopping_Test() throws Exception {
		HomePage homepage = new HomePage(driver);
		Hamburger hamburger = new Hamburger(driver);
		Category category = new Category(driver);
		KindlePage kindlePage = new KindlePage(driver);
		
				
		//test = report.startTest("Amazon Test For Kindle E-Reader Purchase");
		//Step 1: Tap on Hamburger Button.
		homepage.tapHamburgerButton();
		//Step2: Select Shop by Category Option.
		hamburger.tapShopByCategory(); 
		Thread.sleep(5000);
		category.tapKindleCat();
		//Step4: Select Kindle E-Reader
		//Thread.sleep(5000);
		category.selKindleEreader();
		//Step5: Choose Kindle Voyage
		kindlePage.selectKindleBasic();
	}

}
