package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageActions;

import java.time.Duration;

public class SearchResultsPage implements PageActions {

    private WebDriver driver;
    private String price;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By firstResultContainer = By.xpath("//div[@data-cel-widget='search_result_1']");
    By firstResultLink = By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']");
    By symbol = By.xpath("//span[@class='a-price-symbol']");
    By priceWhole = By.xpath("//span[@class='a-price-whole']");
    By priceFraction = By.xpath("//span[@class='a-price-fraction']");

    // getter method
    public String getPrice() {
        return price;
    }

    // setter method
    public void setPrice() {
        price = getText(symbol) + getText(priceWhole) + "." + getText(priceFraction);
        System.out.println("price from srp: " + price);
    }

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
    public void selectFirstResult() {
        clickWhenEnabled(driver, firstResultLink);
        click(firstResultLink);
    }

}
