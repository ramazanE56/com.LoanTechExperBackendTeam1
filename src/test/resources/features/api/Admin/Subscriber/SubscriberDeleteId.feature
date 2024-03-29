Feature:US_27 As an administrator, I should be able to delete a
         subscriber record in the system through API connection.

Scenario Outline: TC_01:When a valid DELETE request with appropriate authorization credentials
          and correct (id) is sent to the 'api/subscriber/delete/{{id}}' endpoint,
          it should return a status code of 200,
          and the message in the request body should be "Subscriber deleted successfully"

  Given The API user sets "api/subscriber/delete/<id>" path parameters
 # And The API adminuser prepares a POST request without data to send to the admin api subscriber add endpoint
  And The API adminuser saves the response from the admin api subscriber delete endpoint with valid authorization information
  Then The API user verifies that the status code is 200
  And The API User verifies that the message information in the response body is "Subscriber deleted successfully"

  Examples:
  |id|
  |328|
  @api
Scenario: TC_02:When a DELETE request with valid authorization credentials
          and without the required (id) is sent to the 'api/subscriber/delete/{{id}}'
          endpoint, it should return a status code of 203, and the message in the request body should be "No id"

  Given The API user sets "api/subscriber/delete" path parameters
  And The API adminuser saves the response from the admin api subscriber delete endpoint with valid authorization information
  Then The API user verifies that the status code is 203
  And The API User verifies that the message information in the response body is "No id"

  @api
Scenario Outline: TC_03:When a DELETE request with valid authorization credentials and
          an (id) that does not correspond to an existing record is sent to the 'api/subscriber/delete/{{id}}'
          endpoint, it should return a status code of 203, and the message in the request body should be "No subscriber "

  Given The API user sets "api/subscriber/delete/<id>" path parameters
  And The API adminuser saves the response from the admin api subscriber delete endpoint with valid authorization information
  Then The API user verifies that the status code is 203
  And The API User verifies that the message information in the response body is "No subscriber "


  Examples:
  |id|
  |626262|

Scenario Outline: TC_04: When an invalid DELETE request body is sent with unauthorized credentials to the
                    'api/subscriber/delete/{{id}}' endpoint, it should return a status code of 401,
                     and the error message in the request body should be "Unauthorized request"


    Given The API user sets "api/subscriber/delete/<id>" path parameters
    Then The API admin records the delete response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    And The API user verifies that the status code is 401
    And The API admin verifies that the data message information in the response body is "Unauthorized request"

    Examples:
      | id  |
      | 210 |
  @api
Scenario Outline: TC_05 : The deletion of the desired subscriber record via
                    API should be confirmed by sending a GET request to the 'api/subscriber/details/{{id}}'
                    endpoint with the Deleted Subscriber id obtained from the request body.
                    This verification process ensures that the record has been successfully deleted

    Given The API user sets "api/subscriber/delete/<id>" path parameters
    And The API adminuser saves the response from the admin api subscriber delete endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No subscriber "

    Examples:
      | id  |
      | 210 |





