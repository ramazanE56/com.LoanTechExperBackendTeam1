Feature: US_65:"As an administrator, I want to be able to update the information of registered
         withdrawal methods in the system through the API connection.

Scenario Outline: TC_01:When valid authorization information, correct 'id',
           and accurate data (name, min_limit, max_limit) are sent in a
           PATCH body to the 'api/withdraw/methods/update/{{id}}'
           endpoint, it should be verified that the returned status code is 200,
           and the message information in the request body is "Withdraw method updated successfully"


  Given The API user sets "api/withdraw/methods/update/<id>" path parameters
  Then The API adminuser prepares a PATCH request with valid authorization information and correct data (name, min_limit, max_limit)
  Then The API adminuser sends a PATCH request and saves the response from the withdraw methods update add endpoint with valid authorization information
  Then The API user verifies that the status code is 200
  And The API user verifies that the remark information in the withdraw response body is "Withdraw method updated successfully"

Examples:
  |id|
  |255|

  @api
  Scenario Outline: TC_02:Verify that when a PATCH request is sent to the
                    'api/withdraw/methods/update/{{id}}' endpoint with valid authorization information,
                    and the request body does not contain the correct 'id'
                    and data fields (name, min_limit, max_limit), the returned status code is 200,
                    and the message in the request body is "Withdraw method updated successfully"

    Given The API user sets "api/withdraw/methods/update/<id>" path parameters
    Then The API adminuser prepares a PATCH request with valid authorization information and correct data (name, min_limit, max_limit)
    Then The API adminuser sends a PATCH request and saves the response from the withdraw methods update add endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the withdraw response body is "Withdraw method updated successfully"

    Examples:
      |id|
      |255|

  @api
  Scenario: TC_03:Verify that when a PATCH request is sent to the
            'api/withdraw/methods/update/{{id}}' endpoint with valid authorization information and
            a body lacking the 'id' field but containing data fields (name, min_limit, max_limit),
            the returned status code is 203, and the message in the request body is "No id."

    Given The API user sets "api/withdraw/methods/update/" path parameters
    Then The API adminuser prepares a PATCH request with valid authorization information and  data fields (name, min_limit, max_limit)
    Then The API adminuser sends a PATCH request and saves the response from the withdraw methods update add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the withdraw response body is "No id."


  Scenario Outline: TC_04:Verify that when a PATCH request is sent to the
                   'api/withdraw/methods/update/{{id}}' endpoint with valid authorization information and
                   a body containing an (id) that does not exist in the records,
                   along with data fields (name, min_limit, max_limit), the returned status code is 203,
                   and the message in the request body is "There is no method with this id to be updated"


    Given The API user sets "api/withdraw/methods/update/<id>" path parameters
    Then The API adminuser prepares a PATCH request with valid authorization information and correct data (name, min_limit, max_limit)
    Then The API adminuser sends a PATCH request and saves the response from the withdraw methods update add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the withdraw response body is "There is no method with this id to be updated"

    Examples:
      |id|
      |255555|


  Scenario Outline: TC_05:Verify that when a PATCH request is sent to the 'api/withdraw/methods/update/{{id}}'
                    endpoint with invalid authorization information but with the correct 'id'
                    and a PATCH body containing data fields (name, min_limit, max_limit),
                    the returned status code is 401, and the error message in the request body is
                    "Unauthorized request"


    Given The API user sets "api/withdraw/methods/update/<id>" path parameters
    Then The API admin records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    And The API user verifies that the status code is 401
    And The API admin verifies that the data message information in the response body is "Unauthorized request"
    Examples:
      |id|
      |255|


Scenario Outline: TC_06:The update of the withdrawal methods record through the API should be verified.
                  This can be confirmed by sending a GET request to the 'api/withdraw/methods/details/{{id}}'
                  endpoint with the Updated method id returned in the request body


  Given The API user sets "api/withdraw/methods/details/<id>" path parameters
  Then The API adminuser saves the GET response from the blogs add  endpoint with valid authorization information
  And The API user verifies that the status code is 200
  And The API user verifies that the remark information in the response body is "success"

  Examples:
    |id|
    |255|



































