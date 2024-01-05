
Feature: US59: As an administrator, I want to be able to reject the withdrawal information of a user with a given ID through the API connection.

  Scenario Outline: TC01: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information,
                  the correct (id), and accurate data (details) in the body,
                  the expected behavior is that the status code in the request is 200.
                  Additionally, the remark information in the request body should be confirmed as "success"

  * The API user sets "api/withdrawal/reject/<id>" path parameters
  * The API user prepares a POST request containing the correct data to send to the api withdrawal reject endpoint with valid authorization information
  * The API adminuser sends a POST request and saves the response withdrawal reject with valid authorization information
  * The API user verifies that the status code is 200
  * The API user verifies that the remark information in the response body is "success"

    Examples:
      | id |
      | 421|


  Scenario Outline: TC02: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information, the correct (id),
                      and without including data (details) in the body, the expected behavior is that the status code in the request is 200.
                      Additionally, the remark information in the request body should be confirmed as "success"

    * The API user sets "api/withdrawal/reject/<id>" path parameters
    * The API adminuser sends a POST request and saves the response no data withdrawal reject with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

    Examples:
        | id |
        |422|


  Scenario Outline: TC03: Verify that when a POST request with valid authorization information and a previously rejected (id) along with a body containing data fields (details) is sent to the 'api/withdrawal/reject/{{id}}' endpoint,
                      the returned status code is 203, and the message information in the request body is "No withdraw or withdraw status is not pending."

    * The API user sets "api/withdrawal/reject/<id>" path parameters
    * The API user prepares a POST request containing the correct data to send to the api withdrawal reject endpoint with valid authorization information
    * The API user sends a POST request and saves the response with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No withdraw or withdraw status is not pending."

    Examples:
      | id |
      | 421|


  Scenario: TC04: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information and without including the required (id) in the body (details),
                      the expected behavior is that the status code in the request is 203. Additionally, the message information in the request body should be confirmed as "No id"

    * The API user sets "api/withdrawal/reject" path parameters
    * The API user prepares a POST request containing the correct data to send to the api withdrawal reject endpoint with valid authorization information
    * The API user sends a POST request and saves the response with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"


  Scenario Outline: TC05: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information and an (id) that corresponds to a non-existent record, along with a POST body (details),
                          the expected behavior is that the status code in the request is 203.
                          Additionally, the message information in the request body should be confirmed as "No withdraw."

    * The API user sets "api/withdrawal/reject/<id>" path parameters
    * The API user prepares a POST request containing the correct data to send to the api withdrawal reject endpoint with valid authorization information
    * The API user sends a POST request and saves the response with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No withdraw."

    Examples:
      | id |
      | 1216|


  Scenario Outline: TC06: When an invalid POST request with unauthorized authorization information is sent to the 'api/withdrawal/reject/{{id}}' endpoint, with the correct (id) and a POST body (details),
                      the expected behavior is that the status code in the request is 401.
                      Furthermore, the error information in the request body should be confirmed as "Unauthorized request"

    * The API user sets "api/withdrawal/reject/<id>" path parameters
    * The API user prepares a POST request containing the correct data to send to the api withdrawal reject endpoint with valid authorization information
    * The API adminuser sends a POST request and saves the response with invalid authorization information
    * The API adminuser verifies that the status_code is 401
    * The API adminser verifies that the message information in the response body is "Unauthorized request"

    Examples:
      | id |
      | 421|
