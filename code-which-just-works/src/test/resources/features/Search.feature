Feature: As a user I want to search the products and filter them by category, price, and name.

  @smoke
  Scenario: Search for products
    Given I am on the home page
    When I search for "Iphone"
    Then I should see a list of products that contain the word "Iphone"