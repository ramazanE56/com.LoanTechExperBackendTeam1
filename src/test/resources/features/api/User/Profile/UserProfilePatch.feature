Feature: US_06: As a user, I want to be able to update the user profile information in the system through API connection.

  Scenario: TC01 When a PATCH request with valid authorization information and correct data (firstname, lastname, address, state, zip, city)
  is sent to the user/profile endpoint, the returned status code should be 200, and the message in the request body
  should be verified as "Profile updated successfully"

    Given The API user sets "user/profile" path parameters
    And The API user prepares a PATCH request containing the correct data to send to the user ticket add endpoint
    When The API user sends a PATCH request and saves the response from the user ticket add endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the message information in the response body is "Profile updated successfully"



  Scenario: TC02 : Verify that when a PATCH request with valid authorization information and incomplete data
  (address, state, zip, city) is sent to the 'user/profile' endpoint, the returned status code is 203, and
  the remark information in the request body is "failed"

    Given The API user sets "user/profile" path parameters
    And The API user prepares a PATCH request with missing data to send to the user ticket add endpoint.
    When The API user sends a PATCH request and saves the response from the user ticket add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the response body is "failed"



  Scenario: TC03 : Verify that when a PATCH request with valid authorization information and an empty body
  (firstname, lastname, address, state, zip, city) is sent to the 'user/profile' endpoint, the returned
  status code is 203, and the remark information in the request body is "failed"


    Given The API user sets "user/profile" path parameters
    And The API user prepares a PATCH request with missing data to send to the user ticket add endpoint.
    When The API user sends a PATCH request and saves the response from the user ticket add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the response body is "failed"


  Scenario: TC04 : Verify that when a PATCH request with invalid authorization information and correct data
  (firstname, lastname, address, state, zip, city) is sent to the 'user/profile' endpoint, the returned
  status code is 401, and the error message in the request body is "Unauthorized request"

    Given The API user sets "user/profile" path parameters
    And The API user prepares a PATCH request containing the correct data to send to the user ticket add endpoint
    When The API user sends a PATCH request and saves the response from the user ticket add endpoint with invalid authorization information
    Then The API user verifies that the status code is 401
    And The API user verifies that the error information in the response body is "Unauthorized request"