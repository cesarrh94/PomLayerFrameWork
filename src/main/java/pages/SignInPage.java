package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JsonFileReader;
import utils.PageActions;

import java.time.Duration;
import java.util.Scanner;

public class SignInPage implements PageActions {

    private WebDriver driver;

    JsonFileReader reader = new JsonFileReader();

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By emailInput = By.id("ap_email");
    By continueButton = By.id("continue");
    By passwordInput = By.id("ap_password");
    By signInButton = By.id("signInSubmit");
    By authWarningMessage = By.id("auth-warning-message-box");
    By authCaptcha = By.id("auth-captcha-image");
    By authInputCaptcha = By.id("auth-captcha-guess");

    @Override
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @Override
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    @Override
    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    @Override
    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    @Override
    public void clickWhenEnabled(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // custom methods
    public void handleSignInAuth() {
        if (driver.findElement(authWarningMessage).isDisplayed() ||
            driver.findElement(authCaptcha).isDisplayed()) {
            type(reader.getAttribute("password"), passwordInput);
            Scanner scanner = new Scanner(System.in);
            System.out.println("type characters to sign in: ");
            String authString = scanner.nextLine();
            System.out.println("authentication string: " + authString);
            type(authString, authInputCaptcha);
            click(signInButton);
            scanner.close();
        } else {
            System.out.println("Auth not required");
        }
    }

    public void signIn(String email, String password) {
        clickWhenEnabled(driver, emailInput);
        type(email, emailInput);
        click(continueButton);
        clickWhenEnabled(driver, passwordInput);
        type(password, passwordInput);
//        click(signInButton);
//        handleSignInAuth();
    }

    public void clickSignInButton() {
        click(signInButton);
    }
}
