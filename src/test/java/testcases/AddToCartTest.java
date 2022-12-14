package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.SignInPage;
import utils.BaseDriver;
import utils.JsonFileReader;

public class AddToCartTest {

    WebDriver driver;
    BaseDriver baseDriver;
    JsonFileReader reader = new JsonFileReader();

    // pageObjects
    HomePage homePage;
    SignInPage signInPage;
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        baseDriver = new BaseDriver(driver);
        driver = baseDriver.setUpDriver();
        baseDriver.navigateTo(reader.getAttribute("url"));
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }


    @Test
    public void testAddProductToCart() {
        homePage.goToLogin();
        String email = reader.getAttribute("email");
        String password = reader.getAttribute("password");
        signInPage.signIn(email, password);
        String productName = "Samsung Galaxy S9 64GB";
        homePage.searchProduct(productName);
        searchResultsPage.storePriceProduct();
        searchResultsPage.selectFirstResult();
    }


    @AfterMethod
    public void tearDown() {
        baseDriver.quitDriver();
    }


}
