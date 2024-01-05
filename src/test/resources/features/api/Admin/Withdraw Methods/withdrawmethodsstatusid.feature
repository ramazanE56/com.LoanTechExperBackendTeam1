Feature:  APi_US064 :As an administrator, I want to be able to update the status information of registered withdrawal methods through the API connection.


  Scenario Outline: TC01: When a valid authorization information and a correct PATCH body containing the id are sent to the 'api/withdraw/methods/status/{{id}}' endpoint,
  it should be verified that the returned status code is 200, and the message information in the request body is "Status changed"


    Given The API user sets "api/withdraw/methods/status/<id>" path parameters
    And The API adminuser PATCH Hsaves the response from the admin withdraw methods close endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API admin verifies that the message information in the response body is "Status changed"

    Examples:
      | id  |
      | 55  |


  Scenario: TC02: When valid authorization information and a PATCH body without the 'id' are sent to the 'api/withdraw/methods/status/{{id}}' endpoint,
  it should be verified that the returned status code is 203, and the message information in the request body is "No id"


    Given The API user sets "api/withdraw/methods/status/" path parameters
    And The API adminuser saves the response from the admin ticket close endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API admin verifies that the message information in the response body is "No id"


  Scenario: TC03: When valid authorization information and a PATCH body containing a non-existent 'id' are sent to the 'api/withdraw/methods/status/{{id}}' endpoint,
  it should be verified that the returned status code is 203, and the message information in the request body is "No withdraw method."


    Given The API user sets "api/withdraw/methods/status/<id>" path parameters
    And The API adminuser saves the response from the admin ticket close endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API admin verifies that the message information in the response body is "No withdraw method."


  Scenario: TC04: When invalid authorization information and a PATCH body containing the 'id' are sent to the 'api/withdraw/methods/status/{{id}}' endpoint,
  it should be verified that the returned status code is 401, and the error information in the request body is "Unauthorized request"



    Given The API user sets "api/withdraw/methods/status/<id>" path parameters
    Then The API user saves the response from the user ticket close endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized



  Scenario: TC05: The update of the withdrawal methods status record through the API should be verified.
  This can be confirmed by sending a GET request to the 'api/withdraw/methods/details/{{id}}' endpoint with the Method id returned in the request body


    Given The API user sets "api/withdraw/methods/status/<id>" path parameters
    And The API adminuser saves the response from the admin ticket close endpoint with valid authorization information


