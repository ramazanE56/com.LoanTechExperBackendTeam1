Feature: API_US024: As an administrator, I want to access the subscriber details of a user with a specified ID via API connection.

  Scenario Outline: TC01:When a valid GET request with appropriate authorization credentials and
  correct data (id) is sent to the 'api/subscriber/details/{{id}}' endpoint,
  it should return a status code of 200, and the request remark should be "success"

    Given The API user sets "api/subscriber/details/<id>" path parameters
    Then The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"

    Examples:
      | id |
      | 34 |



  Scenario: TC02:When a GET request without the required data (id) and with valid authorization credentials is sent to the 'api/subscriber/details/{{id}}' endpoint, it should return a status code of 203, and the request message should be "No id"
    Given The API user sets "api/subscriber/details" path parameters
    Then The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"


  Scenario Outline: TC03:When a GET request with valid authorization credentials and an (id)
  that does not correspond to an existing record is sent to the 'api/subscriber/details/{{id}}' endpoint,
  it should return a status code of 203, and the request message should be "No subscriber "
    Given The API user sets "api/subscriber/details/<id>" path parameters
    Then The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No subscriber "

    Examples:
      | id   |
      | 3400 |


  Scenario Outline: TC04:When an invalid GET request with unauthorized credentials is sent to the 'api/subscriber/details/{{id}}' endpoint, it should return a status code of 401, and the error message in the request body should be "Unauthorized request"
    Given The API user sets "api/subscriber/details/<id>" path parameters
    And The API user saves the response get request endpoint with invalid authorization information

    Examples:
      | id |
      | 34 |


  Scenario Outline: TC05 :The contents of data (id, email, created_at, updated_at) in the request body should be verified
    Given The API user sets "api/subscriber/details/<id>" path parameters
    Then The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
    Then The API User verifies that id is <id> in the response body
    Then The API User verifies that email is "mehmetkahraman@gmail.com" in the response body
    Then The API User verifies that createdat is "2023-12-26T21:40:12.000000Z" in the response body
    Then The API User verifies that updatedat is "2023-12-28T23:14:18.000000Z" in the response body

    Examples:
      | id |
      | 34 |