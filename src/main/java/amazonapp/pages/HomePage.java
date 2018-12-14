package amazonapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonapp.util.commonPath;
import amazonapp.util.mainDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class HomePage extends commonPath
{
	@FindBy(id="in.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	private WebElement Hamburger;

	public HomePage(AppiumDriver<WebElement> driver) {
		super();
		PageFactory.initElements(driver, this);

	}

	public void tapHamburgerButton() throws Exception{
		try { 
			if(Hamburger.isDisplayed()) {
				Hamburger.click();
				Log.info("Hamburger Icon is Tapped");
				reporting("Hamburger Icon selection", "Hamburger icon should be clicked",
						"Hamburger Icon is selected", "pass");
			}
			else {
				Log.info("Hamburger Icon is not Tapped");
				reporting("Hamburger Icon Selection", "Hamburger icon should be clicked",
						"Hamburger Icon is not selected", "fail");
				Assert.fail();
			}
		}
		catch (Exception e) {
		}
	}



}

