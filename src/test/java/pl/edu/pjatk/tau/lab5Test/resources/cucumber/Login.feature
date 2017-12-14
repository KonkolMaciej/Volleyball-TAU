Feature: test login to webservice
  Scenario Outline: login to webservice
    Given there is url to webservice
    When i use login <name> and password <password> in form
    Then we should login to page
    Examples:
      | name | password |
      |"emailExampleAs@wp.pl"  | "password123" |
