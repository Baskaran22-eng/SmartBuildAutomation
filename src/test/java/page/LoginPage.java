package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
	WebDriver driver;
    WebDriverWait wait;
    
    By meterManagement = By.cssSelector(
            "div[style='transition-delay: 300ms;']");
    
    By signInLink = By.cssSelector("a[href='/Login']");
    
    By usernameField = By.name("username");
    By passwordField = By.name("pswd");
    By loginButton = By.cssSelector("button[type='submit']");
    By loginErrorMessage = By.xpath(
            "//div[text()='Username or password is incorrect']");
    
    By dashboard = By.cssSelector("a[href='/SubAdminDashboard']");
    
    By logoutButton = By.xpath("//div[normalize-space()='Logout']");
    
    By cancelLogoutButton = By.xpath("//button[normalize-space()='Cancel']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))
            .sendKeys(username);
    }
    
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))
            .sendKeys(password);
    }
    
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
            .click();
    }
    
    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public boolean isLoginErrorDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginErrorMessage))
                .isDisplayed();
    }
    
    public void clickMeterManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(meterManagement))
            .click();
    }
    
    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink))
            .click();
    }
    
    public void openLoginPage() {
        clickMeterManagement();
        clickSignIn();
    }
    
    public boolean isDashboardDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboard))
                .isDisplayed();
    }
    
    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton))
            .click();

    }
    
    public void clickCancelLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(cancelLogoutButton))
            .click();
    }
}
