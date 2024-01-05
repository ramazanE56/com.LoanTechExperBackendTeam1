Feature: US_51:As an administrator, I want to be able to reject the deposit information
  of a user with a given ID through the API connection.

  Scenario Outline: TC_01:When a valid POST request is sent to the 'api/deposit/reject/{{id}}'
  endpoint with proper authorization information, the correct (id),
  and the accurate data (message) in the body, the expected behavior
  is that the status code in the request is 200. Additionally,
  the message information in the request body
  should be confirmed as "Deposit request rejected successfully"


    Given The API user sets "api/deposit/reject/<id>" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data
    When The API adminuser sends a POST request and saves the response from the deposit reject endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API adminuser verifies that the message information in the response body is "Deposit request rejected successfully"
    


    Examples:
      | id  |
      | 673|

  Scenario Outline: TC_02:When a valid POST request is sent to the 'api/deposit/reject/{{id}}'
  endpoint with proper authorization information, the correct (id),
  and a POST body that does not include the required data (message),
  the expected behavior is that the status code in the request is 200.
  Additionally, the message information in the request body should be confirmed as
  "Deposit request rejected successfully"

    Given The API user sets "api/deposit/reject/<id>" path parameters
    When The API adminuser sends a POST request and saves the response from the deposit reject endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API adminuser verifies that the message information in the response body is "Deposit request rejected successfully"

    Examples:
  |id|
  |672|

  @api
  Scenario Outline: TC_03:Verify that when a POST request with valid authorization
  information and a previously rejected (id) along with a body containing
  data fields (message) is sent to the 'api/deposit/reject/{{id}}'
  endpoint, the returned status code is 203, and the message
  information in the request body is "No deposit or deposit status is not pending."

    Given The API user sets "api/deposit/reject/<id>" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data
    When The API adminuser sends a POST request and saves the response from the deposit reject endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API adminuser verifies that the message information in the response body is "No deposit or deposit status is not pending."

    Examples:
      |id|
      |670|
  @api
  Scenario: TC_04:When a valid POST request is sent to the 'api/deposit/reject/{{id}}'
  endpoint with proper authorization information and a POST body that does not include the required (id)
  but includes (message), the expected behavior is that the status code in the request is 203.
  Additionally, the message information in the request body should be confirmed as "No id"

    Given The API user sets "api/deposit/reject/" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data
    When The API adminuser sends a POST request and saves the response from the deposit reject endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API adminuser verifies that the message information in the response body is "No id"
  @api
  Scenario Outline: TC_05:When a valid POST request is sent to the 'api/deposit/reject/{{id}}'
  endpoint with proper authorization information and a POST body containing an invalid (id) for
  a non-existent record (message), the expected behavior is that the status code in the request is 203.
  Additionally, the message information in the request body should be confirmed as "No deposit."

    Given The API user sets "api/deposit/reject/<id>" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data
    When The API adminuser sends a POST request and saves the response from the deposit reject endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API adminuser verifies that the message information in the response body is "No deposit."

    Examples:
      |id|
      |3555|
  @api
  Scenario Outline: TC_06:When an invalid POST request with unauthorized authorization information
  is sent to the 'api/deposit/reject/{{id}}' endpoint with the correct (id) and a POST body (message),
  the expected behavior is that the status code in the request is 401. Furthermore,
  the error information in the request body should be confirmed as "Unauthorized request"

    Given The API user sets "api/deposit/reject/<id>" path parameters
    Then The API adminuser prepares a POST request with valid authorization information and correct data
    Then The API adminuser sends a POST request and saves the response from the deposit reject endpoint with invalid authorization information
    And The API user verifies that the status code is 401
    And The API admin verifies that the data message information in the response body is "Unauthorized request"
    Examples:
      |id|
      |255|



