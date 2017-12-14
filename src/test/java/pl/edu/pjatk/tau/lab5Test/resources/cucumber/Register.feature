Feature:  register to website

  Scenario Outline: register to website
    Given there is url to page and click to register page
    When I  filled <passwd>, <firstName>, <lastName>, <city>, <street>
    Then account should be registered
    Examples:
      | passwd | firstName 	| lastName 	| city 		| street 	|
      	| "password12@" | "jan"| "kowalski"	| "Gdynia" | "fajna"|
      	| "password12@" | "Tomek"| "kowalski"| "Gdynia" | "jakas"|
