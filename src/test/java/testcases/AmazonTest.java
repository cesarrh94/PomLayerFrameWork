package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseDriver;
import utils.JsonFileReader;

public class AmazonTest {

    WebDriver driver;
    BaseDriver baseDriver;
    JsonFileReader reader = new JsonFileReader();

    // pageObjects
    HomePage homePage;
    SignInPage signInPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        baseDriver = new BaseDriver(driver);
        driver = baseDriver.setUpDriver();
        baseDriver.navigateTo(reader.getAttribute("url"));
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }


    @Test
    public void testAddProductToCart() throws InterruptedException {
        homePage.goToLogin();
        String email = reader.getAttribute("email");
        String password = reader.getAttribute("password");
        signInPage.signIn(email, password);
        String productName = "Samsung Galaxy S9 64GB";
        homePage.searchProduct(productName);
        searchResultsPage.setPrice();
        searchResultsPage.selectFirstResult();
        productPage.setPrice();
        productPage.addProductToCart();
        productPage.goToCart();
        Assert.assertEquals(productPage.getPrice(), searchResultsPage.getPrice());
        cartPage.setPrice();
        cartPage.setQuantityProduct();
        Assert.assertEquals(cartPage.getPrice(), searchResultsPage.getPrice());
        Assert.assertEquals(cartPage.getQuantityProduct(), 1);
        productName = "Alienware Aw3418DW";
        homePage.searchProduct(productName);
        searchResultsPage.selectFirstResult();
        productPage.addProductToCart();
        productPage.rejectGuaranteePolice();
        productPage.addProductToCart();
        productPage.goToCart();
        Thread.sleep(3000);
        cartPage.setQuantityProduct();
        Assert.assertEquals(cartPage.getQuantityProduct(), 2);
    }


    @AfterMethod
    public void tearDown() {
        baseDriver.quitDriver();
    }


}
