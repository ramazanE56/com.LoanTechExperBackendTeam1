
Feature: API_US066 : As an administrator, I should be able to delete the withdrawal methods record in the system through the API connection.
  @api
  Scenario: TC01 : When a valid authorization information and a correct 'id' are sent in a DELETE
                    request to the 'api/withdraw/methods/delete/{{id}}' endpoint, it should be verified that the returned status code is 200,
                    and the message information in the request body is "Withdraw Method deleted"

    Given The API user sets "api/withdraw/methods/add" path parameters
    And The API adminuser prepares a POST request without data to send to the api admin withdrawmethods add endpoint
    And The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API User verifies that the message information in the response body is "Withdraw Method deleted"



  @api
  Scenario: TC02 : When valid authorization information and a DELETE request without the 'id'
  are sent to the 'api/withdraw/methods/delete/{{id}}' endpoint,
  it should be verified that the returned status code is 203, and the message
  information in the request body is "No id"

    Given The API user sets "api/withdraw/methods/delete" path parameters
    And The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"


  @api
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

  @api
    Scenario Outline: TC04 api/withdraw/methods/delete/{{id}} endpoint'ine
                      gecersiz authorization bilgileri ile bir DELETE body gönderildiginde dönen
                      status code'in 401 oldugu ve request body'deki error bilgisinin "Unauthorized request" oldugu dogrulanmali

      Given The API user sets "api/withdraw/methods/delete/<id>" path parameters
      Then The API user saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized

      Examples:
        | id  |
        | 187 |

  @api
      Scenario Outline: TC05 : The deletion of the withdrawal methods record through the API should be verified.
                                This can be confirmed by sending a GET request to the 'api/withdraw/methods/details/{{id}}'
                                endpoint with the Deleted method id returned in the request body

        Given The API user sets "api/withdraw/methods/details/<id>" path parameters
        And The API adminuser saves the response from the admin withdraw methods details endpoint with valid authorization information
        Then The API user verifies that the status code is 203
        And The API User verifies that the message information in the response body is "No Withdraw Method"

        Examples:
          | id  |
          | 180 |



