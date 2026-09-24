package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


public class LoginTest extends BaseTest {
	
	LoginPage loginPage;
	private final String VALID_USERNAME = "sairam kummara";
	private final String VALID_PASSWORD = "Sm@rtbuild09";
	
	@BeforeMethod
	public void createPageObjects() {
	    loginPage = new LoginPage(driver);
	}
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() {

	    return new Object[][] {
	        {"invalid_user", VALID_PASSWORD},
	        {VALID_USERNAME, "invalid"},
	        {"", VALID_PASSWORD},
	        {VALID_USERNAME, ""},
	        {"", ""}
	    };
	}
	
	@Test(priority = 1, groups = {"smoke", "regression"},retryAnalyzer = retry.RetryAnalyzer.class)
	public void validLoginTest() {

		loginPage.openLoginPage();
		
		loginPage.login(VALID_USERNAME, VALID_PASSWORD);

	    Assert.assertTrue(
	    		loginPage.isDashboardDisplayed(),
	            "Dashboard is not displayed after successful login"
	    );
	}
	
	@Test(priority = 3, dataProvider = "loginData", groups = {"regression"})
	public void loginValidationTest(String username, String password) {
	    loginPage.openLoginPage();

	    loginPage.login(username, password);

	    Assert.assertTrue(
	            loginPage.isLoginErrorDisplayed(),
	            "Login error message is not displayed"
	    );
	}
	
	@Test(priority = 2, groups = {"regression"})
	public void cancelLogoutTest() {

	    loginPage.openLoginPage();

	    loginPage.login(VALID_USERNAME, VALID_PASSWORD);

	    loginPage.clickLogout();

	    loginPage.clickCancelLogout();

	    Assert.assertTrue(
	            loginPage.isDashboardDisplayed(),
	            "Dashboard is not displayed after cancel logout"
	    );
	}
	
}
