Feature: Checkout process
@Sanity
  Scenario: Complete checkout with valid information
    Given I have a product in the cart
    When I proceed to checkout
    And I enter valid personal information
    And I finish the checkout
    Then I should see the order confirmation message
