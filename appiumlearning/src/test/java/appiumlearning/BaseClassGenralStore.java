package appiumlearning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassGenralStore {

	public static AndroidDriver desiredCapabilities(String device) throws MalformedURLException

	{
		/// Users/kanishk/eclipse-workspace/appiumlearning/src/test/resources/ApiDemos-debug.apk
		File fileDirectory = new File("src/test/resources");

		File fis = new File(fileDirectory, "General-Store.apk");

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		if (device.equalsIgnoreCase("realdevice")) {
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		} else if (device.equalsIgnoreCase("emulator")) {
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_32_arm64-v8a");
		}
		desiredCapabilities.setCapability(MobileCapabilityType.APP, fis.getAbsolutePath());
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		return  androidDriver;
	}

}
