# NTTData automation exercise
# Feature description: to purchase a item, user must be able to add products to the cart
# Context: The goal is to validate including a item to the cart in a web development scenario with selenium, java, maven, cucumber, junit, intellij and Allure report
# These test are executed in user interface level and are acceptance tests

Feature: Add products to Cart

  Scenario: 1.Validating products values on cart
    Given user is logged on Swag Labs
    When adding products to the cart
    Then products will be successfully added to the cart

  Scenario: 2.Validating total value purchase
    Given user is logged on Swag Labs
    And adding products to the cart
    When buying products of the cart
    Then products will be bought successfully
    And user will logout of the website



