package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class BaseTest {

    public WebDriver driver;
    
    @BeforeSuite
    public void beforeSuite() {

        System.out.println("===== Test Suite Started =====");
    }
    
    @BeforeClass
    public void beforeClass() {
        System.out.println("===== Test Class Started =====");
    }
    
    @BeforeTest
    public void beforeTest() {
        System.out.println("===== TestNG Test Started =====");
    }
    
    @BeforeGroups("smoke")
    public void beforeSmokeGroup() {
        System.out.println("===== Smoke Group Started =====");
    }
    
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

    	if (browser.equalsIgnoreCase("chrome")) {
    	    driver = new ChromeDriver();
    	}
    	else if (browser.equalsIgnoreCase("firefox")) {
    	        driver = new FirefoxDriver();
    	}
    	else {
    	    throw new IllegalArgumentException("Unsupported browser: " + browser);
    	}

        driver.manage().window().maximize();

        driver.get("http://122.175.7.217:5557/");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
        
    }
    
    @AfterSuite
    public void afterSuite() {

        System.out.println("===== Test Suite Finished =====");
    }
    
    @AfterClass
    public void afterClass() {
    	System.out.println("===== Test Class Finished =====");
    }
    
    @AfterTest
    public void afterTest() {
        System.out.println("===== TestNG Test Finished =====");
    }
    
    @AfterGroups("smoke")
    public void afterSmokeGroup() {
        System.out.println("===== Smoke Group Finished =====");
    }
}