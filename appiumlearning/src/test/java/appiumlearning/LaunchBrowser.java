package appiumlearning;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LaunchBrowser extends BaseClass {
	
	public static void main(String...args)  throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		androidDriver.findElement(By.id("android:id/checkbox")).click();
		androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("hello");	
	//	androidDriver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		androidDriver.findElementsByClassName("android.widget.Button").get(1).click();
		
	}

}
