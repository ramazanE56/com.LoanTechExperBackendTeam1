Feature: API_US004 : As a user, I want to be able to update the close information of a registered user ticket through API connection.
  @api
  Scenario Outline: TC01 : When a PATCH request with valid authorization information and correct 'id' is sent to
                    the user/ticket/close/{{id}} endpoint, the returned status code should be 200, and
                    the message in the request body should be verified as "Support ticket closed successfully!"

    Given The API user sets "user/ticket/close/<id>" path parameters
    And The API user saves the response from the user ticket close endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the message information in the response body is "Support ticket closed successfully!"


    Examples:
      | id  |
      | 160 |

@api
  Scenario: TC02: When a PATCH request with valid authorization information and no 'id' is sent to the
                  user/ticket/close/{{id}} endpoint, the returned status code should be 203, and the message in
                  the response body should be verified as "No id"

    Given The API user sets "user/ticket/close" path parameters
    And The API user saves the response from the user ticket close endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"

  @api
  Scenario Outline: TC03:  When a PATCH request with valid authorization information and a non-existent 'id' is sent
                            to the user/ticket/close/{{id}} endpoint, the returned status code should be 203, and the message in the
                            response body should be verified as "No ticket."

    Given The API user sets "user/ticket/close/<id>" path parameters
    And The API user saves the response from the user ticket close endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No ticket."

    Examples:
      | id  |
      | 28122023 |

  @api
  Scenario Outline: TC04: Verify that when a PATCH request with invalid authorization information and the correct
                          'id' is sent to the 'user/ticket/close/{{id}}' endpoint, the returned status code is 401, and the error
                          message in the response body is "Unauthorized request"

    Given The API user sets "user/ticket/close/<id>" path parameters
    Then The API user saves the response from the user ticket close endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized


    Examples:
      | id  |
      | 123 |


  @api
  Scenario Outline: TC05: The update of the ticket record through the API should be verified. This can be confirmed
                          by sending a GET request to the 'user/ticket/detail/{{id}}' endpoint with the Closed ticket id returned in
                          the response body, thus validating that the record has been updated

    Given The API user sets "user/ticket/detail/<id>" path parameters
    And The API user saves the response from the user ticket detail endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user Verifies that the status information in the response body is <status>

    Examples:
  |id|status|
  |160|3    |