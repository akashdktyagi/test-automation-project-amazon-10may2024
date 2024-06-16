Feature: As a user I want to search the products and filter them by category, price, and name.

  Scenario: Search for products
    Given I am on the home page
    When I search for "Iphone" in top search bar
    Then I should see a list of products that contain the word "Iphone"

  Scenario: Filter the search result with Brand Category
    Given I am on the home page
    And I search for "Mobile Phones"  in top search bar
    When I select the search category as "Samsung"
    Then I should see a list of products that contain the word "Samsung" and are from the category "Samsung"


