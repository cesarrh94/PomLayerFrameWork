package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import utils.BaseDriver;
import utils.JsonFileReader;

public class DefinitionSteps {

    WebDriver driver;
    BaseDriver baseDriver;
    JsonFileReader reader = new JsonFileReader();

    // pageObjects
    HomePage homePage;
    SignInPage signInPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    @Given("I am on signin page")
    public void i_am_on_signin_page() {
        baseDriver = new BaseDriver(driver);
        driver = baseDriver.setUpDriver();
        baseDriver.navigateTo(reader.getAttribute("url"));
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        homePage.goToLogin();
    }
    @And("I enter username and password")
    public void i_enter_username_and_password() {
        String email = reader.getAttribute("email");
        String password = reader.getAttribute("password");
        signInPage.signIn(email, password);
    }
    @And("I click sign in button")
    public void i_click_sign_in_button() {
        signInPage.clickSignInButton();
    }
    @When("I search for a {string}")
    public void i_search_for_a(String string) {
        homePage.searchProduct(string);
    }
    @And("I select the first product on the results list and save the price")
    public void i_select_the_first_product_on_the_results_list_and_save_the_price() {
        searchResultsPage.setPrice();
        searchResultsPage.selectFirstResult();
    }
    @And("Validate the price from the product page against search page")
    public void validate_the_price_from_the_product_page_against_search_page() {
        productPage.setPrice();
        Assert.assertEquals(productPage.getPrice(), searchResultsPage.getPrice());

    }
    @And("I click on add to cart button")
    public void i_click_on_add_to_cart_button() {
        productPage.addProductToCart();
    }
    @Then("I am on the cart page")
    public void i_am_on_the_cart_page() {
        System.out.println("I am on Cart Page");
    }
    @And("Validate the price from the cart page against search page")
    public void validate_the_price_from_the_cart_page_against_search_page() {
        cartPage.setPrice();
        Assert.assertEquals(cartPage.getPrice(), searchResultsPage.getPrice());
    }
    @And("Validate the cart has {int} item on it")
    public void validate_the_cart_has_item_on_it(Integer int1) {
        cartPage.setQuantityProduct();
        Assert.assertEquals(cartPage.getQuantityProduct(), int1);
        baseDriver.quitDriver();
    }

}
