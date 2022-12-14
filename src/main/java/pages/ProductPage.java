package pages;

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

    // getter method
    public String getPrice() {
        return price;
    }

    // setter method
    public void setPrice() {
        price = priceSpan.getText();
        System.out.println("price from pp: " + priceSpan.getText());
    }

    // WebElements
    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartbutton;

    @FindBy(xpath = "//span[@class='a-price a-text-price a-size-medium']")
    private WebElement priceSpan;

    @FindBy(id = "nav-cart")
    private WebElement cartLink;

    @FindBy(xpath = "//input[@aria-labelledby='attachSiNoCoverage-announce']")
    private WebElement noGuaranteeCoverageButton;

    // custom methods
    public void clickWhenEnabled(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void addProductToCart() {
        clickWhenEnabled(driver, addToCartbutton);
        addToCartbutton.click();
    }

    public void goToCart() {
        clickWhenEnabled(driver, cartLink);
        cartLink.click();
    }

    public void rejectGuaranteePolice() {
        clickWhenEnabled(driver, noGuaranteeCoverageButton);
        noGuaranteeCoverageButton.click();
    }

}
