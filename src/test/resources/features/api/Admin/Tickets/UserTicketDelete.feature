
  Feature: US05: As a user, I should be able to delete a user ticket record in the system through API connection.

    Scenario Outline: TC01: When a DELETE request with valid authorization information and correct 'id' is sent to the user/ticket/delete/{{id}} endpoint,
                      the returned status code should be 200,
                      and the message in the request body should be verified as "Ticket deleted"

      * The API user sets "user/ticket/delete/<id>" path parameters
      * The API user saves the response from the user ticket delete endpoint with valid authorization information.
      * The API user verifies that the status code is 200
      * The API User verifies that the message information in the response body is "Ticket deleted"

      Examples:
        | id |
        | 307 |
    @api
      Scenario: TC02: When a DELETE request with valid authorization information and no 'id' is sent to the user/ticket/delete/{{id}} endpoint,
                      the returned status code should be 203,
                      and the message in the request body should be verified as "No id"

        * The API admin sets "user/ticket/delete/" path parameters
        * The API user saves the response from the user ticket delete endpoint with valid authorization information.
        * The API user verifies that the status code is 203
        * The API User verifies that the message information in the response body is "No id"
    @api
        Scenario Outline: TC03: When a DELETE request with valid authorization information and a non-existent 'id' is sent to the user/ticket/delete/{{id}} endpoint,
                        the returned status code should be 203,
                        and the message in the request body should be verified as "No ticket."

          * The API admin sets "user/ticket/delete/<id>" path parameters
          * The API user saves the response from the user ticket delete endpoint with valid authorization information.
          * The API user verifies that the status code is 203
          * The API User verifies that the message information in the response body is "No ticket."

          Examples:
            | id |
            | 897654321 |
    @api
          Scenario Outline: TC04: Verify that when a DELETE request with invalid authorization information and the correct 'id' is sent to the 'user/ticket/delete/{{id}}' endpoint,
                           the returned status code is 401, and the error message in the request body is "Unauthorized request"

            * The API user sets "user/ticket/delete/<id>" path parameters
            * The API user saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized

            Examples:
              | id  |
              | 301 |
    @api
          Scenario Outline: TC05: The deletion of the ticket record intended to be removed through the API should be verified.
                            This can be confirmed by sending a GET request to the 'user/ticket/detail/{{id}}' endpoint with the Deleted ticket id returned in the request body,
                            thus validating that the record has been deleted

            * The API user sets "user/ticket/detail/<id>" path parameters
            * The API user saves the response from the user ticket detail endpoint with valid authorization information.
            * The API user verifies that the status code is 203
            * The API User verifies that the message information in the response body is "No ticket."
            Examples:
              | id |
              | 301|






