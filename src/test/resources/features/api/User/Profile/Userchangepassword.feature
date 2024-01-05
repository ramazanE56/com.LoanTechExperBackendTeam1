
Feature: US_007 As a user, I want to be able to update the change password information for a registered user in the system through API connection.

  Scenario: TC_01 When a PATCH request with valid authorization information and correct data
  (current_password, password) is sent to the user/changepassword endpoint,
  the returned status code should be 200, and the message in the request body should be verified as "Password changes successfully"

    * The API user sets "user/changepassword" path parameters
    * The API user prepares a POST request with correct data to send to the user changepassword add endpoint.
    * The API user saves the response from the user changepassword detail endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the message information in the response body is "Password changes successfully"
  @api
  Scenario: TC_02 When a PATCH request with valid authorization information and a new password containing only digits
  (current_password, password) is sent to the user/changepassword endpoint, the returned status code should be 203,
  and the message in the request body should be verified as "The password must contain at least one uppercase and one lowercase letter. (and 1 more error)"

    * The API user sets "user/changepassword" path parameters
    * The API user prepare a POST request with missing data to send to the user ticket add endpoint.
    * The API user saves the response from the user changepassword detail endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the message information in the response body is "The password must contain at least one uppercase and one lowercase letter. (and 1 more error)"
  @api
  Scenario: TC_03 When a PATCH request with valid authorization information
  and a new password containing at least one uppercase letter, one lowercase letter,
  and a digit (current_password, password) is sent to the user/changepassword endpoint, the returned status code should be 203,
  and the message in the request body should be verified as "The password must contain at least one symbol."

    * The API user sets "user/changepassword" path parameters
    * The API user prepares a post request consisting of uppercase and lowercase letters and numbers to be sent to the user ticket add endpoint.
    * The API user saves the response from the user changepassword detail endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the message information in the response body is "The password must contain at least one symbol."

  Scenario: TC_O4 Verify that when a PATCH request with invalid authorization information and correct data
  (current_password, password) is sent to the 'user/changepassword' endpoint, the returned status code is 401,
  and the error message in the request body is "Unauthorized request"

    * The API user sets "user/changepassword" path parameters
    * The API user prepares a PATCH request containing the correct data to send to the user changepassword add endpoint
    * The API user recordss the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

