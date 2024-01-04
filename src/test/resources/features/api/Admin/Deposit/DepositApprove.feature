Feature: As an administrator, I want to be able to update the deposit information of a user in the
  system to 'approved' through the API connection.

  Scenario Outline: TC01: When a valid PATCH request is sent to the 'api/deposit/approve/{{id}}'endpoint with proper
  authorization information and the correct data (id) in the body, the expected behavior is thatthe status code in the
  request is 200. Additionally, the message information in the request body should be confirmed as "Deposit request
  approved successfully"

    Given The API user sets "api/deposit/approve/<id>" path parameters
    And The API user saves the response from the admin deposit approve close endpoint with valid authorization information
    #Api kullanicisi user ticket close endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 200
    And The API admin verifies that the message information in the response body is "Deposit request approved successfully"
    #Api kullanicisi response bodydeki message bilgisinin "Deposit request approved successfully" oldugunu doğrular

    Examples:
      | id  |
      | 658 |

  Scenario Outline: TC02: Verify that when a PATCH request with valid authorization information and a previously approved
  (id) is sent to the 'api/deposit/approve/{{id}}' endpoint, the returned status code is 203, and the message information
  in the request body is "No deposit or deposit status is not pending."

    Given The API user sets "api/deposit/approve/<id>" path parameters
    And The API user saves the response from the admin deposit approve close endpoint with valid authorization information
    #Api kullanicisi user ticket close endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No deposit or deposit status is not pending."
    #Api kullanicisi response bodydeki message bilgisinin "No deposit or deposit status is not pending." oldugunu doğrular

    Examples:
      | id  |
      | 129 |

  Scenario: TC03: When a valid PATCH request is sent to the 'api/deposit/approve/{{id}}' endpoint with proper authorization
  information but without including the required (id) in the body, the expected behavior is that the status code in the
  request is 203. Additionally, the message information in the request body should be confirmed as "No id"

    Given The API user sets "api/deposit/approve" path parameters
    And The API user saves the response from the admin deposit approve close endpoint with valid authorization information
    #Api kullanicisi user ticket close endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"
    #Api kullanicisi response bodydeki message bilgisinin "No id" oldugunu doğrular

  Scenario Outline: TC04: When a valid PATCH request is sent to the 'api/deposit/approve/{{id}}' endpoint with proper
  authorization information and an (id) that corresponds to a non-existent record in the body, the expected behavior is
  that the status code in the request is 203. Additionally, the message information in the request body should be
  confirmed as "No deposit."

    Given The API user sets "api/deposit/approve/<id>" path parameters
    And The API user saves the response from the admin deposit approve close endpoint with valid authorization information
    #Api kullanicisi user ticket close endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No deposit."
    #Api kullanicisi response bodydeki message bilgisinin "No deposit." oldugunu doğrular

    Examples:
      | id  |
      | 1064 |

  Scenario Outline: TC05: When an invalid PATCH request with unauthorized authorization information is sent to the
  'api/deposit/approve/{{id}}' endpoint, the expected behavior is that the status code in the request is 401.
  Additionally, the error information in the request body should be confirmed as "Unauthorized request"

    Given The API user sets "api/deposit/approve/<id>" path parameters
    Then The API user saves the response from the user ticket close endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized
    #Api kullanicisi user ticket close endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder, status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular

    Examples:
      | id  |
      | 123 |



