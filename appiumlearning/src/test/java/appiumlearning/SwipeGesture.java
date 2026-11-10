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



public class SwipeGesture extends BaseClass {
	
	public static void main(String...args)  throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		androidDriver.findElement(By.xpath("//*[@content-desc='6']")).click();	
		
		TouchAction touchAction= new TouchAction(androidDriver);
		
		AndroidElement destinationElement=	androidDriver.findElement(By.xpath("//*[@content-desc='30']"));
		
		
		touchAction.longPress(longPressOptions().withElement(element(destinationElement)).withDuration(ofSeconds(10))).release().perform();
		
		
		androidDriver.findElement(By.id("android:id/toggle_mode")).click();	
		
		androidDriver.findElement(By.id("android:id/input_hour")).sendKeys("6");	
		androidDriver.findElement(By.id("android:id/input_minute")).sendKeys("19");	
		
		androidDriver.findElement(By.id("android:id/am_pm_spinner")).click();
		androidDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PM']")).click();
		androidDriver.findElement(By.id("android:id/toggle_mode")).click();
	}

}
