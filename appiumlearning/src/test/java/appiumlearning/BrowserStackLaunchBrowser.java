package appiumlearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserStackLaunchBrowser {

	public static void main(String...args)throws MalformedURLException

	{
		/// Users/kanishk/eclipse-workspace/appiumlearning/src/test/resources/ApiDemos-debug.apk
		//File fileDirectory = new File("src/test/resources");

		//File fis = new File(fileDirectory, "General-Store.apk");

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			
		desiredCapabilities.setCapability("browserstack.user", "sanjay_GW5D0j");
		desiredCapabilities.setCapability("browserstack.key", "zw8SqRqS1yVVytYA86hD");
			// Initialise the remote Webdriver using BrowserStack remote URL
			
		desiredCapabilities.setCapability("app", "bs://894d5f03e5c5a79c9d3e3e33049e14647ac059a8");
			// Specify device and os_version for testing
		
		desiredCapabilities.setCapability("device", "Google Pixel 3");
		desiredCapabilities.setCapability("os_version", "9.0");
			// Set other BrowserStack capabilities
		desiredCapabilities.setCapability("project", "Sanjay First Java Project");
		desiredCapabilities.setCapability("build", "Java Android");
		desiredCapabilities.setCapability("name", "Appium_first_testFecthAllText");
		
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), desiredCapabilities);
		
	//	IOSDriver<IOSElement> androidDriver1 = new IOSDriver<IOSElement>(new URL("http://hub.browserstack.com/wd/hub"), desiredCapabilities);
	
		
		//androidDriver.findElementByAccessibilityId(null).click();
		androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Views\")")).click();
		androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"WebView\"))"));
		
		androidDriver.quit();
	}

}
