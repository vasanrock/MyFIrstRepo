Feature: Add and remove products from the cart
@Regression
  Scenario: Add a product to the cart
    Given I am logged in to Sauce Demo
    When I add a product to the cart
    Then the cart badge should display 1 item

  Scenario: Remove a product from the cart
    Given I have added a product to the cart
    When I remove the product from the cart
    Then the cart should be empty
