package amazonapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import amazonapp.util.commonPath;
import io.appium.java_client.AppiumDriver;



public class Hamburger extends commonPath
{
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]")
	private WebElement ShopByCat;

	public Hamburger(AppiumDriver<WebElement> driver) {
		super();
		PageFactory.initElements(driver, this);

	}

	public void tapShopByCategory() throws Exception{
		try {if(ShopByCat.isDisplayed()) {
			ShopByCat.click();
			Log.info("Shop By Category is Tapped");
			reporting("Shop By Category Selection", "Shop By Category should be clicked",
					"Shop By Category is be clicked", "pass");
		}
		else {
			Log.info("Shop By Category is not Tapped");
			reporting("Shop By Category Selection", "Shop By Category should be clicked",
					"Shop By Category is not clicked", "fail");
			Assert.fail();
		}
		}
		catch(Exception e) {
		}
	}
}

