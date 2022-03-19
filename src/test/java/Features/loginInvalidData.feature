Feature: Login as admin using incorrect credentials

  As an user I want to check what happens if I log in with incorrect credentials

  Scenario Outline: Login with different data
    Given User use invalid login "<login>" or password "<password>"
    Then Span message is displayed
    Examples:
      | login  | password |
      | Admin  | asdsda   |
      | Asdaa  | admin123 |
      | Asadaa | asdsda   |