@AddToCart
Feature: Search and Add product to Cart

  Scenario: User should search for a product, add it to basket and validate
    Given User is on homepage of website
    When User fill registration page details
    And User clicks on Register Button
    And User should continue shopping on user account page
    And User search for <"Watches"> in the search bar
    And User select <"Garmin"> brand
    And User select "Garmin Forerunner 45S Sports Smartwatch (39mm) - Black"
    And User adds product to cart
    And User refresh the homepage
    And User search for <"Watches"> in the search bar
    And User select <"Garmin"> brand
    And User select "Garmin QuickFit 22mm Silicone Watch Band - Flame Red"
    And User adds product to cart
    And User refresh the homepage
    And User click on basket button
    Then User can see the product/s inside the basket/cart
      | Garmin Forerunner 45S Sports Smartwatch (39mm) - Black |
      | Garmin QuickFit 22mm Silicone Watch Band - Flame Red   |

