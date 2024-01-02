
Feature: US58 : As an administrator, I want to be able to approve the withdrawal information of a user with a given ID through the API connection.

  Scenario: TC01: When a valid PATCH request is sent to the 'api/withdrawal/approve/{{id}}' endpoint with proper authorization information,
                   the correct (id), and accurate data (details) in the body, the expected behavior is that the status code in the request is 200.
                  Additionally, the remark information in the request body should be confirmed as "success"

    * The API user sets "api/withdrawal/pending" path parameters
    * The API adminuser prepares a GET request containing the the correct id and accurate data send to the api withdrawal pending endpoint with valid authorization information
    * The API adminuser prepares a PATCH request containing the the correct id and accurate data send to the api withdrawal approve endpoint with valid authorization information
    * The API adminuser sends a PATCH request and saves the response with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


    Scenario Outline: TC02: Verify that when a PATCH request with valid authorization information and a previously approved (id) along with a body containing data fields (details) is sent
                    to the 'api/withdrawal/approve/{{id}}' endpoint, the returned status code is 203,
                    and the message information in the request body is "No withdraw or withdraw status is not pending."

      * The API user sets "api/withdrawal/approve/<id>" path parameters
      * The API adminuser prepares a PATCH request containing the the correct id and accurate data send to the api withdrawal approve id endpoint with valid authorization information
      * The API adminuser sends a PATCH request and saves the response with valid authorization information
      * The API user verifies that the status code is 203
      * The API user verifies that the remark information in the response body is "No withdraw or withdraw status is not pending."

      Examples:
        | id |
        | 400|

      Scenario: TC03: When a valid PATCH request is sent to the 'api/withdrawal/approve/{{id}}' endpoint with proper authorization information but without including the required (id) and with a PATCH body that lacks details,
                      the expected behavior is that the status code in the request is 203.
                      Additionally, the message information in the request body should be confirmed as "No id"

        * The API user sets "api/withdrawal/approve" path parameters
        * The API user prepares a PATCH request containing without including data to send to the api withdrawal approve endpoint with valid authorization information
        * The API adminuser sends a PATCH request and saves the response with valid authorization information
        * The API user verifies that the status code is 203
        * The API user verifies that the remark information in the response body is "No id"


    Scenario Outline: TC04: When a valid PATCH request is sent to the 'api/withdrawal/approve/{{id}}' endpoint with proper authorization information and an (id) that corresponds to a non-existent record, along with a PATCH body (details),
                           the expected behavior is that the status code in the request is 203.
                           Additionally, the message information in the request body should be confirmed as "No withdraw."

      * The API user sets "api/withdrawal/approve/<id>" path parameters
      * The API user prepares a PATCH request containing non-existent record to send to the api withdrawal approve endpoint with valid authorization information
      * The API adminuser sends a PATCH request and saves the response with valid authorization information
      * The API user verifies that the status code is 203
      * The API user verifies that the remark information in the response body is "No withdraw."

      Examples:
        | id |
        | 1265|


      Scenario Outline: TC05: When an invalid PATCH request with unauthorized authorization information is sent to the 'api/withdrawal/approve/{{id}}' endpoint, with the correct (id) and a PATCH body (details),
                              the expected behavior is that the status code in the request is 401.
                              Furthermore, the error information in the request body should be confirmed as "Unauthorized request"

        * The API user sets "api/withdrawal/approve/<id>" path parameters
        * The API user prepares a PATCH request containing with the correct id with unauthorized authorization information send to the api withdrawal approve endpoint with valid authorization information
        * The API adminuser sends a PATCH request and saves the response with invalid authorization information
        * The API user verifies that the status code is 401
        * The API user verifies that the remark information in the response body is "Unauthorized request"

        Examples:
          | id |
          | 395|







