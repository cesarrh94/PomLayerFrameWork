package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private String price;
    private int quantityProduct;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']//span")
    private WebElement priceSpan;

    @FindBy(id = "sc-subtotal-label-activecart")
    private WebElement quantitySpan;

    // getter & setter methods
    public String getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = priceSpan.getText();
        System.out.println("price from cp: " + price);
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct() {
        String quantity = quantitySpan.getText().substring(10,11);
        this.quantityProduct = Integer.parseInt(quantity.trim());
        System.out.println("quantity: " + this.quantityProduct);
    }

    // custom methods
    public void clickWhenEnabled(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
