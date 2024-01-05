
  Feature: API_US041 As an administrator, I want to be able to approve the loan information of a user with a
    given ID through the API connection.


    Scenario Outline: TC_01 When valid authorization information and correct data (id) are sent to the
      api/loans/approve/{{id}} endpoint with a PATCH request, it should be verified that the
      returned status code is 200 and the message in the request body is "Loan approved successfully"

      * The API user sets "api/loans/approve/<id>" path parameters
      * The API adminuser prepares a PATCH request with valid authorization information and correct data
      * The API adminuser sends a PATCH request and saves the response from the user loans approve endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API admin verifies that the message information in the response body is "Loan approved successfully"
      Examples:
        | id  |
        | 174 |

    @api
    Scenario Outline: Tc_02 Verify that when a PATCH request with valid authorization information and a previously
      approved (id) is sent to the 'api/loans/approve/{{id}}' endpoint, the returned status code is 203, and
      the message information in the request body is "No loan or loan status is not pending."

      * The API user sets "api/loans/approve/<id>" path parameters
      * The API adminuser prepares a PATCH request with valid authorization information and correct data
      * The API adminuser sends a PATCH request and saves the response from the user loans approve endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No loan or loan status is not pending."
      Examples:
        | id  |
        | 174 |
    @api
    Scenario Outline: TC_03 When valid authorization information and a PATCH body without (id) are sent to the
      api/loans/approve/{{id}} endpoint, it should be verified that the returned status code is 203 and the
      message in the request body is "No id"

      * The API user sets "api/loans/approve/<id>" path parameters
      * The API adminuser prepares a PATCH request with valid authorization information and correct data
      * The API adminuser sends a PATCH request and saves the response from the user loans approve endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No id"
      Examples:
        | id |
        |    |
    @api
    Scenario Outline: TC_04 Valid authorization information should be passed to the 'api/loans/approve/{{id}}'
      endpoint, and when a PATCH body containing an invalid (id) for an unregistered record is sent,
      the expected status code is 203, and the message information in the request body should be verified as
      "No loan."

      * The API user sets "api/loans/approve/<id>" path parameters
      * The API adminuser prepares a PATCH request with valid authorization information and correct data
      * The API adminuser sends a PATCH request and saves the response from the user loans approve endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No loan."
      Examples:
        | id            |
        | 7657686877867 |

    @api
    Scenario Outline: TC_05 When an invalid authorization is provided along with a PATCH body to the
        'api/loans/approve/{{id}}' endpoint, the expected status code is 401, and the error message
        in the request body should be verified as "Unauthorized request"

      * The API user sets "api/loans/approve/<id>" path parameters
      * The API user saves the response from the user ticket close endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized

      Examples:
        | id |
        | 174  |