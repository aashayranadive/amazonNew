package amazonapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazonapp.util.commonPath;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class KindlePage extends commonPath
{

	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View")
	private WebElement kindleBasic;

	public KindlePage(AppiumDriver<WebElement> driver) {
		super();
		PageFactory.initElements(driver, this);

	}

	public void selectKindleBasic() throws Exception{
		Thread.sleep(5000);
	
		try {
			if (kindleBasic.isDisplayed()) {
				kindleBasic.click();
				Log.info("Kindle Basic is selected");
				reporting("Select Kindle Basic", "Kindle Basic item should be selected",
						"Kindle Basic item is selected", "pass");
			}
			else {
				Log.info("Kindle Basic is selected");
				reporting("Select Kindle Basic", "Kindle Basic item should be selected",
						"Kindle Basic item is not selected", "fail");
			}
		}
		catch (Exception e) {

		}
	}



}

