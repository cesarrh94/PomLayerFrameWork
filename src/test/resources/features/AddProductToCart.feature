Feature: Add products to cart

  In order to add 2 products to cart,
  As a signed in user on Amazon.com.mx
  I want to search for any product, compare their prices,
  validate the quantity of products and add them to the cart.

  Scenario: Add Samsung Galaxy S9 64GB and Alienware Aw3418DW to cart
    Given I am on signin page
    And I enter username and password
    And I click sign in button
    When I search for a "Samsung Galaxy S9 64GB"
    And I select the first product on the results list and save the price
    And Validate the price from the product page against search page
    And I click on add to cart button
    And I am on the cart page
    And Validate the price from the cart page against search page
    And Validate the cart has 1 item on it
    Then I search for a "Alienware Aw3418DW"
    And I select the first product on the result list
    And I click on add to cart button
    And Validate the cart has 2 items on it




