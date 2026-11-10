package appiumlearning;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	
@Test
public void exportExtentReport()
{

	ExtentReports extentReport = new ExtentReports();
	ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extentreport.html/");
	extentSparkReporter.config().setTheme(Theme.DARK);
	extentSparkReporter.config().setReportName("Automation Report");
	extentSparkReporter.config().setDocumentTitle("Document");
	
	extentReport.attachReporter(extentSparkReporter);
	
	
	ExtentTest extentTest= extentReport.createTest("My First Test").assignAuthor("sanjay").assignDevice("Samsung").assignCategory("Regression");
	extentTest.pass("Test Case is Pass");
	extentTest.info("Device is connect with System");
	
	
	ExtentTest extentTest1= extentReport.createTest("My Second Test").assignAuthor("Piyush").assignCategory("Sprint").assignDevice("Nexus");
	extentTest1.pass("Test Case is Pass");
	extentTest1.info("Device is connect with System");
	
	
	extentReport.flush();
}
	
}
