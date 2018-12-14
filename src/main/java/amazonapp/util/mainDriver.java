package amazonapp.util;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class mainDriver extends BaseTest {
	protected AppiumDriver<WebElement> driver;

	public void driver() {
		this.driver = super.getDriver();
	}
}
