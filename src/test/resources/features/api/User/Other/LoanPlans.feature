@api
  Feature: API_US008 As a user, I want to access the user plan through API connection.


    Scenario: TC_01 When a GET request with valid authorization information is sent to the user/plan endpoint, the
      returned status code should be 200, and the request remark should be verified as "success"

      * The API user sets "'user/plan" path parameters
      * The API user saves the response from the user ticket list endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API user verifies that the message information in the response body is "success"