
Feature: US17: As an administrator, I want to access the list of loan plans via API connection.
  @api
  Scenario: TC01: When a GET request with valid authorization information is sent to the api/loanplans/list endpoint,
          the returned status code should be 200, and the request remark should be verified as "success"

    Given The API user sets "api/loanplans/list" path parameters
    When The API user sends GET request to api loanplans list endpoint
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"


  Scenario: TC02: When a GET request with invalid authorization information is sent to the api/loanplans/list endpoint,
            the returned status code should be 401, and the error message in the request should be verified as "Unauthorized request"

    Given The API user sets "api/loanplans/list" path parameters
    Then The API adminuser records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    Then The API user verifies that the status code is 401
    And The API adminuser verifies that the remark information in the response body is "Unauthorized request"

 Scenario Outline: : TC03: Verify the information returned in the request for the entity with id(x)
  (category_id, form_id, name, title, minimum_amount, maximum_amount, per_installment, installment_interval, total_installment, application_fixed_charge, application_percent_charge, instruction, delay_value, fixed_charge, percent_charge, is_featured, status, created_at, updated_at, id, name, image, description, status, created_at, updated_at)

    Given The API user sets "api/loanplans/details/<id>" path parameters
    When The API adminuser saves the response from the api loanplans list endpoint with valid authorization information
    Then Verify the information of the one with the id <dataIndex> in the API user response body <category_id>,<form_id>,"<name>","<title>","<minimum_amount>","<maximum_amount>","<per_installment>",<installment_interval>,<total_installment>,"<application_fixed_charge>","<application_percent_charge>","<instruction>",<delay_value>,"<fixed_charge>","<percent_charge>",<is_featured>,<status>,"<created_at>","<updated_at>"

    Examples:
     |  id| dataIndex | category_id | form_id | name        | title      | minimum_amount | maximum_amount | per_installment | installment_interval | total_installment | application_fixed_charge | application_percent_charge | instruction      | delay_value | fixed_charge | percent_charge | is_featured | status | created_at                | updated_at                  |
     | 153|    0      |1            |378      |Car Loan 9   |Car Loan 9  | 2000.00000000  | 5000.00000000  |4.00             |20                    |20                 |20.00000000               |3.00000000                  |omer orak         |25           |100.00000000  |1.00000000      |0            |1       |2023-12-29T19:37:33.000000Z| 2023-12-29T19:37:33.000000Z |


