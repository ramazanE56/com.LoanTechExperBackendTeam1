
Feature: APi_US025:As an administrator, I want to create a new subscriber record via API connection.
  @api
  Scenario: TC01: When a valid POST request with appropriate authorization credentials and correct data (email) is sent to the 'api/subscriber/add' endpoint,
  it should return a status code of 200,
  and the remark in the request body should be "success"


    Given The API user sets "api/subscriber/add" path parameters
    And The API adminuser prepares a POST request containing the correct data to send to the admin subscriber add endpoint
    When The API adminuser sends a POST request and saves the response from the admin subscriber add endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"

  @api
  Scenario: TC02:When a POST request with valid authorization credentials and incorrect data (mail) is sent to the 'api/subscriber/add' endpoint,
  it should return a status code of 203, and the remark in the request body should be "failed"

    Given The API user sets "api/subscriber/add" path parameters
    And The API adminuser prepares a POST request containing the missing email
    When The API adminuser sends a POST request and saves the response from the admin subscriber add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the response body is "failed"

  Scenario: TC03 :When a POST request with valid authorization credentials and an empty data (email) in the body is sent to the 'api/subscriber/add' endpoint,
  it should return a status code of 203, and the remark in the request body should be "failed"


    Given The API user sets "api/subscriber/add" path parameters
    And The API adminuser prepares a POST request containing the missing email
    When The API adminuser sends a POST request and saves the response from the admin subscriber add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the response body is "failed"


  @api
  Scenario: TC04:When an invalid POST request with unauthorized credentials and a body containing data (email) is sent to the 'api/subscriber/add' endpoint,
  it should return a status code of 401and the error message in the request body should be "Unauthorized request"

    Given The API user sets "api/subscriber/add" path parameters
    And The API user prepares a POST request containing the correct data to send to the user ticket add endpoint
    When The API user sends a POST request and saves the response from the user ticket add endpoint with invalid authorization information
    Then The API user verifies that the status code is 401
    And The API user verifies that the error information in the response body is "Unauthorized request"



  Scenario Outline: TC05:The creation of a new subscriber record intended to be generated through the API should be verified.This can be
  confirmed by sending a GET request to the 'api/subscriber/details/{{id}}' endpoint with the Added Subscriber Id returned in the request body,
  thus validating that the record has been created



    Given The API user sets "api/subscriber/details/<id>" path parameters
    And The API user saves GET the response from the admin subscriber details endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    Then The API user verifies that the id information in the response body is <valueId>

    Examples:
      | id  | valueId |
      | 55 | 55     |