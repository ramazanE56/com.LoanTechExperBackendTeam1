Feature: APi_US052 :As an administrator, I should be able to delete a deposit record in the system through the API connection.


  Scenario Outline: TC01: When a valid DELETE request is sent to the 'api/deposit/delete/{{id}}' endpoint with proper authorization information and the correct (id),
  the expected behavior is that the status code in the request is 200.
  Additionally, the message information in the request body should be confirmed as "Deposit deleted"

    Given The API user sets "api/deposit/delete/<id>" path parameters
    And The API adminuser saves the response from the admin Deposit deletedt  endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API User verifies that the message information in the response body is "Deposit deleted"


    Examples:
      | id |
      | 653 |

  Scenario: TC02 : When a valid DELETE request is sent to the 'api/deposit/delete/{{id}}' endpoint with proper authorization information but without including the required (id), the expected behavior
  is that the status code in the request is 203. Additionally, the message information in the request body should be confirmed as "No id"


    Given The API user sets "api/deposit/delete/" path parameters
    And The API adminuser saves the response from the admin Deposit deletedt  endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"



  Scenario Outline: TC03:


    Given The API user sets "api/deposit/delete/ <id>" path parameters
    And The API adminuser saves the response from the admin Deposit deletedt  endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No deposit"
    Examples:
      | id |
      |889 |


  Scenario Outline:   When an invalid DELETE request with unauthorized authorization information is sent to the 'api/deposit/delete/{{id}}' endpoint, the expected behavior
  is that the status code in the request is 401. Furthermore, the error information in the request body should be confirmed as "Unauthorized request"

    Given The API user sets "api/deposit/delete/ <id>" path parameters
    Then The API user saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized




    Examples:
      | id |
      | 653 |