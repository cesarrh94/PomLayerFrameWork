Feature: Signin functionality

  As user with valid credentials, I want to be able to sign in.

  Scenario: Signin with valid credentials
    Given User is on signin page
    When User enters username and password
    And clicks on signin button
    Then User should be redirected to home page
