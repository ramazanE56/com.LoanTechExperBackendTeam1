Feature: US_016: As an administrator, I should be able to delete a category record in the system through API connection.

  Scenario Outline: TC_01: When a DELETE request with valid authorization information and correct 'id' is sent to the
  api/categories/delete/{{id}} endpoint, the returned status code should be 200, and the message in the request body
  should be verified as "category deleted"

    Given The API user sets "api/categories/delete/<id>" path parameters
    And The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API User verifies that the message information in the response body is "category deleted"

    Examples:
      | id  |
      | 664 |


  Scenario: TC_02: When a DELETE request with valid authorization information and no 'id' is sent to the
  api/categories/delete/{{id}} endpoint, the returned status code should be 203, and the message in the request body
  should be verified as "No id"

    Given The API user sets "api/categories/delete/<id>" path parameters
    And The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"


  Scenario Outline: TC_03: When a DELETE request with valid authorization information and a non-existent 'id' is sent to the api/categories/delete/{{id}} endpoint, the returned status code should be 203, and the message in the request body should be verified as "No category"

    Given The API user sets "api/categories/delete/<id>" path parameters
    And The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No category"

    Examples:
      | id  |
      | 664 |


  Scenario Outline:TC_04: When a DELETE request with invalid authorization information and correct 'id' is sent to the
  api/categories/delete/{{id}} endpoint, the returned status code should be 401, and the error message in the request
  body should be verified as "Unauthorized request"

    Given The API user sets "api/categories/delete/<id>" path parameters
    Then The API adminuser saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized
    And The API User verifies that the message information in the response body is "Unauthorized request"

    Examples:
      | id  |
      | 664 |


  Scenario Outline:TC_05: The deletion of the desired category record through the API should be verified. This can be confirmed by sending a GET request to the api/categories/details/{{id}} endpoint with the Deleted category id returned in the request body to ensure that the record has been successfully deleted

    Given The API user sets "api/categories/delete/<id>" path parameters
    And The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"

    Examples:
      | id  |
      | 664 |