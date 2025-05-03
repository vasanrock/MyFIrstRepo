Feature: Login to Sauce Demo
@SmokeTest
  Scenario: Successful login with valid credentials
    Given I am on the Sauce Demo login page
    When I enter valid username and password
    And I click the login button
    And I should be redirected to the products page
    Then I click logout button

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the Sauce Demo login page
    When I enter invalid username and password
    And I click the login button
    And I should see an error message
   