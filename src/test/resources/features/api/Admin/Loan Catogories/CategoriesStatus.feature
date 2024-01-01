@MK
Feature: API_US015 : As an administrator,  I want to update the status information of existing categories via API connection.

  Scenario Outline: TC001 : When a PATCH request with valid authorization information and correct data (id) is sent to the
  api/categories/status/{{id}} endpoint, the returned status code should be 200, and the message in the request body
  should be verified as "Status changed"

    Given The API user sets "api/categories/status/<id>" path parameters
    And   The API user saves the response endpoint with valid authorization information
    Then  The API user verifies that the status code is 200
    And   The API User verifies that the message information in the response body is "Status changed"

    Examples:
      | id  |
      | 487 |


  Scenario: TC002: When a PATCH request with valid authorization information and no 'id' is sent to the api/categories/status endpoint,
  the returned status code should be 203, and the message in the request body should be verified as "No id"

    Given The API user sets "api/categories/status" path parameters
    And   The API user saves the response endpoint with valid authorization information
    Then  The API user verifies that the status code is 203
    And  The API User verifies that the message information in the response body is "No id"

  Scenario Outline: TC003 : When a PATCH request with valid authorization information and a non-existent 'id' is sent to the
  api/categories/status/{{id}} endpoint,   the returned status code should be 203,
  and the message in the request body should be verified as "No category"
    Given The API user sets "api/categories/status/<id>" path parameters
    And   The API user saves the response endpoint with valid authorization information
    Then  The API user verifies that the status code is 203
    And   The API User verifies that the message information in the response body is "No category"

    Examples:
      | id   |
      | 9487 |


  Scenario Outline: TC04 : When a PATCH request with invalid authorization information and correct 'id' is sent to the api/categories/status/{{id}}
  endpoint, the returned status code should be 401,
  and the error message in the request body should be verified as "Unauthorized request"

    Given The API user sets "api/categories/status/<id>" path parameters
    And The API user saves the response endpoint with invalid authorization information

    Examples:
      | id  |
      | 487 |




  Scenario Outline: TC005 : The update of the desired category status record through the API should be verified.
  This can be confirmed by sending a GET request to the api/categories/details/{{id}} endpoint
  with the Status Updated id returned in the request body to ensure that the status record has been successfully updated

    Given The API user sets "api/categories/details/<id>" path parameters
    And   The API adminuser saves the response from the categories add endpoint with get reguest for first status
    Then  The API user sets "api/categories/status/<id>" path parameters
    Then  The API adminuser saves the response from the categories add endpoint with PATCH reguest
    Then The API user sets "api/categories/details/<id>" path parameters
    Then The API adminuser saves the response from the categories add endpoint with get reguest for updated status
    Then Verify that the desired category status record is updated via API

    Examples:
      | id  |
      | 487 |