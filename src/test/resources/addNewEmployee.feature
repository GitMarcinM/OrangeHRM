Feature: Add a new Employee

  As an Admin I want to add a new employee without logging in when we will hire a new employee

  Scenario: Add a new Employee
    Given User logs in as Admin
    And User click the PIM menu
    And User click on the Add button
    When User fill the required fields
    And User click on the Save button
    Then New employee was created
    And The data matches