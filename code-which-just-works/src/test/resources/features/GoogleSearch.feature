
@google @issue:JIRA-1000
Feature: Test Google for various search terms

  @xrayTest:JIRA-1
  Scenario: Search for "Selenium"
    Given I open Google
    When I search for "Selenium"
    Then the page title should start with "1Selenium"

  @xrayTest:JIRA-2
  Scenario: Search for "Cucumber"
    Given I open Google
    When I search for "Cucumber"
    Then the page title should start with "Cucumber"

  @xrayTest:JIRA-3
  Scenario: Search for "Protractor"
    Given I open Google
    When I search for "Protractor"
    Then the page title should start with "Protractor"

  @xrayTest:JIRA-4
  Scenario: Search for "Jasmine"
    Given I open Google
    When I search for "Jasmine"
    Then the page title should start with "Jasmine"

  @xrayTest:JIRA-5
  Scenario: Search for "Mocha"
    Given I open Google
    When I search for "Mocha"
    Then the page title should start with "Mocha"

  @xrayTest:JIRA-6
  Scenario: Search for "Chai"
    Given I open Google
    When I search for "Chai"
    Then the page title should start with "Chai"

  @xrayTest:JIRA-7
  Scenario: Search for "Jest"
    Given I open Google
    When I search for "Jest"
    Then the page title should start with "Jest"

  @xrayTest:JIRA-8
  Scenario: Search for "Nightwatch"
    Given I open Google
    When I search for "Nightwatch"
    Then the page title should start with "Nightwatch"

  @xrayTest:JIRA-8
  Scenario: Search for "WebdriverIO"
    Given I open Google
    When I search for "WebdriverIO"
    Then the page title should start with "WebdriverIO"

  @xrayTest:JIRA-10
  Scenario: Search for "Appium"
    Given I open Google
    When I search for "Appium"
    Then the page title should start with "Appium"

  @xrayTest:JIRA-11
  Scenario: Search for "Robot Framework"
    Given I open Google
    When I search for "Robot Framework"
    Then the page title should start with "Robot Framework"

  @xrayTest:JIRA-12
  Scenario: Search for "Katalon Studio"
    Given I open Google
    When I search for "Katalon Studio"
    Then the page title should start with "Katalon Studio"

  @xrayTest:JIRA-13
  Scenario: Search for "TestNG"
    Given I open Google
    When I search for "TestNG"
    Then the page title should start with "TestNG"


  @xrayTest:JIRA-14
  Scenario: Search for "Japan"
    Given I open Google
    When I search for "Japan"
    Then the page title should start with "failed"

  @xrayTest:JIRA-15
  Scenario: Search for "India"
    Given I open Google
    When I search for "India"
    Then the page title should start with "failed"

  @xrayTest:JIRA-16
  Scenario: Search for "Russia"
    Given I open Google
    When I search for "Russia"
    Then the page title should start with "failed"

  @xrayTest:JIRA-17
  Scenario: Search for "SMU"
    Given I open Google
    When I search for "SMU"
    Then the page title should start with "failed"

