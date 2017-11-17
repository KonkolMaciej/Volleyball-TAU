Feature: delete
  As a user
  I want delete all records
  So that I doing it

  Scenario: remove lists
    Given I have a list with record
    When I delete it
    Then  result should be 0
