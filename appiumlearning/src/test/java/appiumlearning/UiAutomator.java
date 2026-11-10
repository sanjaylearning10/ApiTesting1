package appiumlearning;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomator extends BaseClass {
	
	public static void main(String...args)  throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		
		//androidDriver.findElement(MobileBy.AndroidUIAutomator("")).click()
		//androidDriver.findelementby
		System.out.print(androidDriver.findElement
				(MobileBy.AndroidUIAutomator("new UiSeelctor().clickable(true)")).getText());
	}

}
