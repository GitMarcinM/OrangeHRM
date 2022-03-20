Feature: Website language change as Admin

  As an Admin I want to change the language to German on the whole Orange HRM Website

  Scenario: Website language change
    Given User logs in as Admin
    And User chooses Configuration option from the Admin menu
    And User chooses Location option from the Configuration menu
    When User click on the Edit button
    And User chooses German language from the dropdown list
    And User click on the Save button
    Then Website language changes into German