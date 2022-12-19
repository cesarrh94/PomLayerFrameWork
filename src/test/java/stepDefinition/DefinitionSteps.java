package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DefinitionSteps {

    @Given("I am on signin page")
    public void i_am_on_signin_page() {
        System.out.println("hello sign in page");
    }
    @And("I enter username and password")
    public void i_enter_username_and_password() {
        System.out.println("username and password");
    }
    @And("I click sign in button")
    public void i_click_sign_in_button() {
        System.out.println("click sign in button");
    }
    @When("I search for a {string}")
    public void i_search_for_a(String string) {
        System.out.println("string: " + string);
    }
    @And("I select the first product on the results list and save the price")
    public void i_select_the_first_product_on_the_results_list_and_save_the_price() {
        System.out.println("select a product from list result");
    }
    @And("Validate the price from the product page against search page")
    public void validate_the_price_from_the_product_page_against_search_page() {
        System.out.println("Validate price between pp vs sp");
    }
    @And("I click on add to cart button")
    public void i_click_on_add_to_cart_button() {
        System.out.println("click add to cart button");
    }
    @Then("I am on the cart page")
    public void i_am_on_the_cart_page() {
        System.out.println("hello from cart page");
    }
    @And("Validate the price from the cart page against search page")
    public void validate_the_price_from_the_cart_page_against_search_page() {
        System.out.println("Validate price between cp vs sp");
    }
    @And("Validate the cart has {int} item on it")
    public void validate_the_cart_has_item_on_it(Integer int1) {
        System.out.println("validate quantity");
    }


}
