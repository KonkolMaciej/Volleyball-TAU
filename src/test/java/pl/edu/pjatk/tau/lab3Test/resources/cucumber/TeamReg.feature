Feature: test create to find an Team by regex

  Scenario: Find Team by regex
    Given there is one Team
    When start of this team is passed as "Tapla*"
    Then we should find this Team
    But  we have more team in list