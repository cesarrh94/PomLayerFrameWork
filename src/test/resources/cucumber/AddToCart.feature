Feature: Add to Cart Functionality

  As an Amazom user, I want to a product to my cart.

  Scenario: Adding a Product to the Cart
    Given User is on the Product Page
    And User saves the price of the product
    And Compares prices to be the same
    When User add product to cart
    Then User should be redirected to Cart Page
