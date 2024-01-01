Feature: API_US060: As an administrator, I should be able to delete a withdrawal record in the system through the API connection.

  Scenario Outline: TC001 :When a valid DELETE request is sent to the 'api/withdrawal/delete/{{id}}' endpoint with proper authorization information and the correct (id),
  the expected behavior is that the status code in the request is 200.Additionally, the message information in the request body should be confirmed as "withdrawal deleted"

    Given The API user sets "api/withdrawal/delete/<id>" path parameters
    Then  The API user saves the response from the delete endpoint with valid authorization information
    Then  The API user verifies that the status code is 200
    And   The API User verifies that the message information in the response body is "withdrawal deleted"

    Examples:
      | id  |
      | 188 |

  Scenario: TC002: When a valid DELETE request is sent to the 'api/withdrawal/delete/{{id}}' endpoint with proper authorization information but without including the required (id),
  the expected behavior is that the status code in the request is 203.
  Additionally, the message information in the request body should be confirmed as "No id"

    Given The API user sets "api/withdrawal/delete" path parameters
    Then  The API user saves the response from the delete endpoint with valid authorization information
    Then  The API user verifies that the status code is 203
    And   The API User verifies that the message information in the response body is "No id"

  Scenario Outline: TC003: When a valid DELETE request is sent to the 'api/withdrawal/delete/{{id}}' endpoint with proper authorization information and
  an (id) that corresponds to a non-existent record, the expected behavior is that the status code in the request is 203.
  Additionally, the message information in the request body should be confirmed as "No withdrawal"
    Given The API user sets "api/withdrawal/delete/<id>" path parameters
    Then  The API user saves the response from the delete endpoint with valid authorization information
    Then  The API user verifies that the status code is 203
    And   The API User verifies that the message information in the response body is "No withdrawal"

    Examples:
      | id  |
      | 18225 |

  Scenario Outline: TC004:When an invalid DELETE request with unauthorized authorization information is sent to the 'api/withdrawal/delete/{{id}}' endpoint,
  the expected behavior is that the status code in the request is 401.
  Furthermore, the error information in the request body should be confirmed as "Unauthorized request"
    Given The API user sets "api/withdrawal/delete/<id>" path parameters
    Then  The API user saves the response from the delete endpoint with invalid authorization information

    Examples:
      | id  |
      | 186 |


  Scenario Outline: TC005:The deletion of the withdrawal record through the API should be confirmed by sending a GET request to the 'api/withdrawal/details/{{id}}' endpoint
  with the Deleted withdrawal id from the request body. This action verifies that the record has been deleted

    Given The API user sets "api/withdrawal/details/<id>" path parameters
    Then  The API adminuser saves the response from the withdrawal endpoint with get reguest
    Given The API user sets "api/withdrawal/delete/<id>" path parameters
    Then  The API user saves the response from the delete endpoint with valid authorization information
    Given The API user sets "api/withdrawal/details/<id>" path parameters
    Then  The API adminuser saves the response from the withdrawal endpoint with get reguest
    And   The API User verifies that the message information in the response body is "No withdraw."

    Examples:
      | id  |
      | 189 |
