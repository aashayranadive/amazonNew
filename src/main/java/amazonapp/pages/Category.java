package amazonapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonapp.util.commonPath;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Category extends commonPath
{

	@FindBy(xpath="//android.view.View[@content-desc='Kindle E-Readers & eBooks']")
	private WebElement kindleCat;

	@FindBy(xpath="//android.view.View[@content-desc='Kindle E-Readers ']")
	private WebElement kindleEreader;

	public Category(AppiumDriver<WebElement> driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void tapKindleCat() throws Exception{
		try {
			if(kindleCat.isDisplayed()) {
				kindleCat.click();
				Log.info("Kindle Category is selected");
				reporting("Select Kindle Category", "Kindle Category should be clicked",
						"Kindle Category is clicked", "pass");

			}
			else {Log.info("Kindle Category is not Tapped");
			reporting("Select Kindle Category", "Kindle Category should be clicked",
					"Kindle Category is not clicked", "fail");

			Assert.fail();
			}
		}
		catch (Exception e) {
		}
	}

	public void selKindleEreader() throws Exception{

		try{ if(kindleEreader.isDisplayed()) {
			kindleEreader.click();
			Log.info("Kindle E-Reader is selected");
			reporting("Select Kindle E-Reader", "Kindle E-Reader section should open",
					"Kindle E-Reader Section is Opened", "pass");
		}
		else {Log.info("Kindle Category is not Tapped");
		reporting("Select Kindle E-Reader", "Kindle E-Reader section should open",
				"Kindle E-Reader Section failed to Open", "fail");
		Assert.fail();
		}
		}
		catch (Exception e) {
		}
	}
}

