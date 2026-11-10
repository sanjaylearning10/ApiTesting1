package appiumlearning;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class GeneralStoreBrowserMode extends BaseClassGenralStore {

	public static void main(String... args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
		androidDriver.hideKeyboard();

		androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		androidDriver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));

		androidDriver.findElement(By.xpath("//*[@text='Argentina']")).click();
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		androidDriver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		androidDriver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		androidDriver.findElement(By.className("android.widget.CheckBox")).click();
		
		AndroidElement termandCondition= androidDriver.findElementById("com.androidsample.generalstore:id/termsButton");
		
		TouchAction touchAction = new TouchAction(androidDriver);
		
		touchAction.longPress(longPressOptions().withElement(element(termandCondition)).withDuration(ofSeconds(10))).release().perform();
		androidDriver.findElementByClassName("android.widget.Button").click();
		androidDriver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

	}

	
}