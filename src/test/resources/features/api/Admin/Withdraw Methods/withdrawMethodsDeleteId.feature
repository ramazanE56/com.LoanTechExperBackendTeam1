Feature: API_US066 : As an administrator, I should be able to delete the withdrawal methods record in the system through the API connection.
  @ism13
  Scenario Outline: TC01 : When a valid authorization information and a correct 'id' are sent in a DELETE
                    request to the 'api/withdraw/methods/delete/{{id}}' endpoint, it should be verified that the returned status code is 200,
                    and the message information in the request body is "Withdraw Method deleted"

    Given The API user sets "api/withdraw/methods/delete/<id>" path parameters
    And The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API User verifies that the message information in the response body is "Withdraw Method deleted"

    Examples:
      | id  |
      | 181 |


  Scenario : TC02 : When valid authorization information and a DELETE request without the 'id'
  are sent to the 'api/withdraw/methods/delete/{{id}}' endpoint,
  it should be verified that the returned status code is 203, and the message
  information in the request body is "No id"

    Given The API user sets "api/withdraw/methods/delete" path parameters
    And The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"


  @ism14
    Scenario Outline: TC03 : When valid authorization information and a DELETE request containing a non-existent 'id' are sent
                              to the 'api/withdraw/methods/delete/{{id}}' endpoint, it should be verified that the returned
                              status code is 203, and the message information in the request body is "No Withdraw Method"

      Given The API user sets "api/withdraw/methods/delete/<id>" path parameters
      And The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information
      Then The API user verifies that the status code is 203
      And The API User verifies that the message information in the response body is "No Withdraw Method"

      Examples:
        | id       |
        | 29122023 |


