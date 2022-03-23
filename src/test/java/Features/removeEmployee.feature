Feature: Remove Employee

  As an Admin I want to able delete an Employee when he is fired

  Scenario: Remove an Employee
    Given User logs in as Admin
    And User click the PIM menu
    And User fill the Employee Name field
    And User click on the Search button
    When User mark checkbox next to the employee data
    And User click on the Delete button
    And User confirm delete of employee
    Then User get message "Successfully Deleted"
