Feature: Sign In Functionality

  As an user with valid credentials, I want to be able to
  sign in on Amazon.

  Scenario: Sign In with valid credentials
    Given User is on Sign In Page
    When User sign in with a valid username and password
    Then Home page should be displayed

