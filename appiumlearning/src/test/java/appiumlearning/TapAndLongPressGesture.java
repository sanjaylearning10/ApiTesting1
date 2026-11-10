package appiumlearning;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;



public class TapAndLongPressGesture extends BaseClass {
	
	public static void main(String...args)  throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		TouchAction touchAction= new TouchAction(androidDriver);
		
		AndroidElement destinationElement=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		
		touchAction.tap(tapOptions().withElement(element(destinationElement))).perform();
		
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		
		AndroidElement peopleNamesElement=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
	
		touchAction.longPress(longPressOptions().withElement(element(peopleNamesElement)).withDuration(ofSeconds(10))).release().perform();
		
		List<AndroidElement> list = androidDriver.findElementsByClassName("android.widget.TextView");
		
		System.out.println(list.get(0).getText());
		System.out.println(list.get(1).getText());
		
		
		
	}

}
