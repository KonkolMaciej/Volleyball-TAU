Feature: create and delete
  As a user
  I want create three records
  but not decited and i delete it..
  So that I doing it using scenario

  Scenario Outline: create teams
    Given I have a scenario with record
    When I create is <id> name <teamName> city <City> and liga <Liga>
    And I delete record using <id> because i make mistake
    Then the result should be 0
    Examples:
      | id | teamName | City     | Liga |
      | 1  | "Tapla"  | "Gdynia" | "I"  |
      | 2  | "Alpat"  | "Gdynia" | "I"  |
      | 3  | "Trefl"  | "Gdańsk" | "I"  |
