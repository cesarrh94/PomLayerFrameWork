Feature: Add to cart functionality

  As user, I want to add a product to my cart.

  Scenario: Adding a product to the cart
    Given User is on the product page
    When User click on add to cart button
    Then Product should be on the cart
