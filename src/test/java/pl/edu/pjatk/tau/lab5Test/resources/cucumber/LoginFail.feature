Feature:  fail test login to website

  Scenario Outline: login to website
    Given there is url to page
    When i use name <name> and  password <password> in form
    Then we click login button and we shouldn't login to page
    Examples:
      | name                 | password      |
      | "sadasdsadsad@wp.pl" | "dasdsadsad"  |
      | "maciek@wp.pl"       | "dasasdssdad" |
      | "aciek@wp.pl"        | "dasdsadsad"  |
