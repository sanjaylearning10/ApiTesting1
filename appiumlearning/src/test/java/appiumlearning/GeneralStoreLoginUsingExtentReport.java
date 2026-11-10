package appiumlearning;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreLoginUsingExtentReport extends BaseClassGenralStore {
	
	
	ExtentReports extentResports;
	ExtentSparkReporter extentSparkReporter;
	ExtentTest extentTest;
	
	@BeforeSuite
	public void setupExtentReport()
	{
		extentResports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")  + "/extentreportlogin.html/");
		
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("Good Automation Suite Report");
		extentSparkReporter.config().setDocumentTitle("Reporting");
		
		extentResports.attachReporter(extentSparkReporter);
		
		
		
		
	}
	
	@Test
	public void loginApplication()  throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = desiredCapabilities("emulator");
		androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sanjay");
		androidDriver.hideKeyboard();
		
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		androidDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Argentina\").instance(0))"));     

		androidDriver.findElement(By.xpath("//*[@text='Argentina']")).click();
		androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		extentTest=extentResports.createTest("loginApplication")
				.assignAuthor("sanjay chandel")
				.assignDevice("Emualtor")
				.assignCategory("InSprint");
		
		TakesScreenshot takesScreenshot =androidDriver;
		String screenshot= takesScreenshot.getScreenshotAs(OutputType.BASE64);
		extentTest.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		
	}

	@AfterSuite
	public void tearDownReport()
	{
		extentResports.flush();
		
	}
	
}
