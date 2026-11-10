package appiumlearning;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
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



public class DragDrop extends BaseClass {
	
	public static void main(String...args)  throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
	//	androidDriver.rotate(ScreenOrientation.LANDSCAPE);
	//	androidDriver.rotate(ScreenOrientation.PORTRAIT);
		TouchAction touchAction= new TouchAction(androidDriver);
		
		AndroidElement sourceElement=	androidDriver.findElementsByClassName("android.view.View").get(0);
	
		AndroidElement destinationElement=	androidDriver.findElementsByClassName("android.view.View").get(1);
		
		touchAction.longPress(longPressOptions().withElement(element(sourceElement)).
				withDuration(ofSeconds(10))).moveTo(element(destinationElement)).release().perform();
		
		System.out.println(androidDriver.findElementById("io.appium.android.apis:id/drag_result_text").getText());
	
		
	}

}
