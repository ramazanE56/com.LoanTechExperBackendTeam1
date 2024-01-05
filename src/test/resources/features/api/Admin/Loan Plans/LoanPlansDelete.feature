Feature: API_US022 As an administrator, I should be able to delete a loan plan record in the system through API connection.

  Scenario Outline:  TC01 When a valid DELETE request with appropriate authorization credentials and correct
    data (id) is sent to the 'api/loanplans/delete/{{id}}' endpoint, it should return a status code
    of 200, and the message in the request body should be "Loan plan deleted"

    Given The API user sets "api/loanplans/delete/<id>" path parameters
    And The API user saves the response from the user loanplans delete endpoint with valid authorization information
    #Api kullanicisi user loanplans delete endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 200
    And The API User verifies that the message information in the response body is "Loan plan deleted"

    Examples:
      | id  |
      | 141 |
  @api
  Scenario: TC02 When a DELETE request with valid authorization information and no 'id' is sent to the
  user/ticket/delete/{{id}} endpoint, the returned status code should be 203, and the message in the
  response body should be verified as "No id"

    Given The API user sets "api/loanplans/delete" path parameters
    And The API user saves the response from the user loanplans delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"

  @api
  Scenario Outline: TC03 When a DELETE request with valid authorization credentials and an (id) that does not
  correspond to an existing record is sent to the 'api/loanplans/delete/{{id}}' endpoint, it should return a
  status code of 203, and the message in the request body should be "No loanplan."

    Given The API user sets "api/loanplans/delete/<id>" path parameters
    And The API user saves the response from the user loanplans delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No loanplan."

    Examples:
      | id  |
      | 141 |

  @api
  Scenario Outline: TC04 When an invalid DELETE request body is sent with unauthorized credentials to the
  'api/loanplans/delete/{{id}}' endpoint, it should return a status code of 401, and the error message in the
  request body should be "Unauthorized request"

    Given The API user sets "api/loanplans/delete/<id>" path parameters
    Then The API admin saves the response from the admin loanplan delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized
    Examples:
      | id |
      | 207 |



  @api
  Scenario Outline: TC05 The deletion of the loan plan record intended to be removed through the API should be
  verified. This can be confirmed by sending a GET request to the 'api/loanplans/details/{{id}}' endpoint with
  the Deleted Loan Plan id returned in the request body, thus validating that the record has been deleted

    Given The API user sets "api/loanplans/details/<id>" path parameters
    And The API user saves the response from the user loanplans delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No loanplans."

    Examples:
      | id  |
      | 141 |
