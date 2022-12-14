package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private String price;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartbutton;

    @FindBy(xpath = "//span[@class='a-price a-text-price a-size-medium']")
    private WebElement priceSpan;

    public String getPrice() {
        return price;
    }

    // custom methods
    public void clickWhenEnabled(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void storePriceProduct() {
        price = priceSpan.getText();
        System.out.println("price from pp: " + priceSpan.getText());
    }

    public void addProductToCart() {
        clickWhenEnabled(driver, addToCartbutton);
        addToCartbutton.click();
    }




}
