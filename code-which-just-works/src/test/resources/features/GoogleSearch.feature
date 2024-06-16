
@google
Feature: Test Google for various search terms

  Scenario: Search for "Selenium"
    Given I open Google
    When I search for "Selenium"
    Then the page title should start with "Selenium"

  Scenario: Search for "Cucumber"
    Given I open Google
    When I search for "Cucumber"
    Then the page title should start with "Cucumber"

  Scenario: Search for "Protractor"
    Given I open Google
    When I search for "Protractor"
    Then the page title should start with "Protractor"

  Scenario: Search for "Jasmine"
    Given I open Google
    When I search for "Jasmine"
    Then the page title should start with "Jasmine"

  Scenario: Search for "Mocha"
    Given I open Google
    When I search for "Mocha"
    Then the page title should start with "Mocha"

  Scenario: Search for "Chai"
    Given I open Google
    When I search for "Chai"
    Then the page title should start with "Chai"

  Scenario: Search for "Jest"
    Given I open Google
    When I search for "Jest"
    Then the page title should start with "Jest"

  Scenario: Search for "Nightwatch"
    Given I open Google
    When I search for "Nightwatch"
    Then the page title should start with "Nightwatch"

  Scenario: Search for "WebdriverIO"
    Given I open Google
    When I search for "WebdriverIO"
    Then the page title should start with "WebdriverIO"

  Scenario: Search for "Appium"
    Given I open Google
    When I search for "Appium"
    Then the page title should start with "Appium"

  Scenario: Search for "Robot Framework"
    Given I open Google
    When I search for "Robot Framework"
    Then the page title should start with "Robot Framework"

  Scenario: Search for "Katalon Studio"
    Given I open Google
    When I search for "Katalon Studio"
    Then the page title should start with "Katalon Studio"

  Scenario: Search for "TestNG"
    Given I open Google
    When I search for "TestNG"
    Then the page title should start with "TestNG"