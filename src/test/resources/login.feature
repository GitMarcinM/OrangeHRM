Feature: Login using data from the table

  As an user I want to check what happens if I log in with data from the table

  Scenario Outline: Login with different data
    Given User use login "<login>" and password "<password>" from the table
    Then User is logged or span message is displayed
    Examples:
      | login  | password |
      | Admin  | asdsda   |
      | Asdaa  | admin123 |
      | Asadaa | asdsda   |
      | Admin  | admin123 |