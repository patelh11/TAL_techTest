@Register
Feature: User registration test

  Scenario: Verify that user register functionality is working successfully
    Given User is on homepage of website
    When User fill registration page details
    And User clicks on Register Button
    Then User should get welcome text <"Welcome to the TAKEALOT.com family!">
    And User should continue shopping on user account page
