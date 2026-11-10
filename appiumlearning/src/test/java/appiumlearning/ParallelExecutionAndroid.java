package appiumlearning;

import org.testng.annotations.Test;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class ParallelExecutionAndroid {

	@Test
	public void methodScrol() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("browserstack.user", "sanjay_GW5D0j");
		desiredCapabilities.setCapability("browserstack.key", "zw8SqRqS1yVVytYA86hD");	
		desiredCapabilities.setCapability("app", "bs://894d5f03e5c5a79c9d3e3e33049e14647ac059a8");		
		desiredCapabilities.setCapability("device", "Google Pixel 3");
		desiredCapabilities.setCapability("os_version", "9.0");
		desiredCapabilities.setCapability("project", "Sanjay First Java Project");
		desiredCapabilities.setCapability("build", "Java Android");
		desiredCapabilities.setCapability("name", "Appium_first_parallelMethod");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), desiredCapabilities);

		androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Views\")")).click();
		androidDriver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"WebView\"))"));

		androidDriver.quit();
	}

	@Test
	public void methodSwipe() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("browserstack.user", "sanjay_GW5D0j");
		desiredCapabilities.setCapability("browserstack.key", "zw8SqRqS1yVVytYA86hD");
		desiredCapabilities.setCapability("app", "bs://894d5f03e5c5a79c9d3e3e33049e14647ac059a8");
		desiredCapabilities.setCapability("device", "Samsung Galaxy Note 20");
		desiredCapabilities.setCapability("os_version", "10.0");
		desiredCapabilities.setCapability("project", "Sanjay First Java Project");
		desiredCapabilities.setCapability("build", "Java Android");
		desiredCapabilities.setCapability("name", "Appium_second_parallelMethod");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), desiredCapabilities);
		TouchAction touchAction = new TouchAction(androidDriver);
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		androidDriver.findElement(By.xpath("//*[@content-desc='6']")).click();	
		AndroidElement destinationElement = androidDriver.findElement(By.xpath("//*[@content-desc='30']"));
		touchAction.longPress(longPressOptions().withElement(element(destinationElement)).withDuration(ofSeconds(10)))
				.release().perform();
		androidDriver.findElement(By.id("android:id/toggle_mode")).click();
		androidDriver.findElement(By.id("android:id/input_hour")).sendKeys("6");
		androidDriver.findElement(By.id("android:id/input_minute")).sendKeys("19");
		//androidDriver.findElement(By.id("android:id/am_pm_spinner")).click();
		//androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PM']")).click();
		androidDriver.findElement(By.id("android:id/toggle_mode")).click();
		androidDriver.quit();
	}

}
