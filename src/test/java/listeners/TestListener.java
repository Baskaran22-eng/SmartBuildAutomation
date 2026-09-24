package listeners;

import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(org.testng.ITestResult result) {

	    System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(org.testng.ITestResult result) {

	    System.out.println("Test Passed: " + result.getName());
	}
	
	@Override
	public void onTestFailure(org.testng.ITestResult result) {

	    System.out.println("Test Failed: " + result.getName());

	    WebDriver driver =((base.BaseTest) result.getInstance()).driver;

	    System.out.println("Driver captured for failed test.");
	    
	    TakesScreenshot screenshot = (TakesScreenshot) driver;

	    File source = screenshot.getScreenshotAs(OutputType.FILE);

	    File destination = new File("screenshots/" + result.getName() + ".png");

	    source.renameTo(destination);
	}
}
