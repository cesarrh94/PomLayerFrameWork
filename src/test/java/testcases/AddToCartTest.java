package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.JsonFileReader;

public class AddToCartTest {

    WebDriver driver;
    BaseDriver baseDriver;
    JsonFileReader reader = new JsonFileReader();

    @BeforeMethod
    public void setUp() {
        baseDriver = new BaseDriver(driver);
        driver = baseDriver.setUpDriver();
        baseDriver.navigateTo(reader.getAttribute("url"));
    }


    @Test
    public void testAddProductToCart() {
        System.out.println("Hello from test");
    }


    @AfterMethod
    public void tearDown() {
        baseDriver.quitDriver();
    }


}
