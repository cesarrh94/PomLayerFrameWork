Feature: Validate Price

  Scenario: Validate price on cart page
    Given User is on cart page
    And Product select on product page is on the cart
    When User compare the price on search page against cart page
    Then Price should be the same