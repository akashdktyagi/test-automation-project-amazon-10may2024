Feature: I want to search for products

  @smoke
  Scenario: As a user I wish to search for a product "IPhone"
    Given I am on the homepage
    When I search for "IPhone"
    Then I should see the search results for "IPhone"