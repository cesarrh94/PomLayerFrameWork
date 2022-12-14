package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageActions;

import java.time.Duration;

public class HomePage implements PageActions {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By loginLink = By.id("nav-link-accountList");
    By searchBar = By.id("twotabsearchtextbox");


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
    public void goToLogin() {
        clickWhenEnabled(driver, loginLink);
        click(loginLink);
    }

    public void searchProduct(String productName) {
        clickWhenEnabled(driver, searchBar);
        type(productName, searchBar);
        submit(searchBar);
    }
}
