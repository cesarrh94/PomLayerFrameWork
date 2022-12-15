Feature: Search functionality

  As user, I want to be able of search for a
  specific product and select the first result on the list.

  Scenario: Search for a product
    Given User search for Samsung Galaxy S9 64GB
    When Search results should be displayed
    And User must select first result
    Then User should be redirected to product page

