Feature: Search Functionality

  As an Amazon user, I want to be able of search for
  specific product and select the first result on the list.

  Scenario: Search for a Product
    Given User search for Samsung Galaxy S9 64GB
    And Result Page is displayed
    And User save the price of the product to be selected
    When User select the first result
    Then Product Page should be displayed

