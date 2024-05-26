Feature: As a user I want to search the products and filter them by category, price, and name.

  @smoke
  Scenario: Search for products
    Given I am on the home page
    When I search for "Iphone"
    Then I should see a list of products that contain the word "Iphone"

  @test
  Scenario: Filter the search result with Brand Category
    Given I am on the home page
    And I search for "Mobile Phones"
    When I select the search category as "Samsung"
    Then I should see a list of products that contain the word "Samsung" and are from the category "Samsung"

  Scenario: As a user, I want to search and a single product in the cart
    Given I am on a search page for product "Samsung"
    When I add top two products in the cart
    Then Cart icon on the top right corner is updated with the count as 2
    And total amount of the two product is displayed in the side bar

