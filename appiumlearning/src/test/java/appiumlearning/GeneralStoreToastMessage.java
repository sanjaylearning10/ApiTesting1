package appiumlearning;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreToastMessage extends BaseClassGenralStore {
	
	public static void main(String...args)  throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		

		String toastMessage= androidDriver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastMessage);
		
	}

}
