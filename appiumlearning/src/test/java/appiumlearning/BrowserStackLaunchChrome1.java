package appiumlearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserStackLaunchChrome1 {

	public static void main(String...args)throws MalformedURLException

	{
		

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			
		desiredCapabilities.setCapability("browserstack.user", "sanjay_GW5D0j");
		desiredCapabilities.setCapability("browserstack.key", "zw8SqRqS1yVVytYA86hD");
			
			
	//	desiredCapabilities.setCapability("app", "bs://894d5f03e5c5a79c9d3e3e33049e14647ac059a8");
			
		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		desiredCapabilities.setCapability("device", "Google Pixel 3");
		desiredCapabilities.setCapability("os_version", "9.0");
			
		desiredCapabilities.setCapability("project", "Sanjay First Java Project");
		desiredCapabilities.setCapability("build", "Java Android");
		desiredCapabilities.setCapability("name", "Appium_launchBrowserusingRemoteWebDriver");
		
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		WebDriver androidDriver = new RemoteWebDriver(
				new URL("http://hub.browserstack.com/wd/hub"), desiredCapabilities);
	
		androidDriver.get("http://m.facebook.com");
		
		System.out.println("page title is " + androidDriver.getTitle());
		androidDriver.findElement(By.id("m_login_email")).sendKeys("hello world", Keys.ENTER);
		androidDriver.quit();
	
	}

}
