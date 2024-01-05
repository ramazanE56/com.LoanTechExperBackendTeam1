Feature: US_33 As an administrator, I should be able to delete a ticket record in the system through API connection.

    Scenario Outline: TC_01 When a valid DELETE request with appropriate authorization
   credentials and correct (id) is sent to the
  'api/tickets/delete/{{id}}' endpoint, it should return a status code of 200,
   and the message in the request body should be "Ticket deleted"

    * The API user sets "api/tickets/delete/<id>" path parameters
    * The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API adminuser verifies that the message information in the response body is "Ticket deleted"

    Examples:
      | id |
      | 293 |
  @api
    Scenario: TC_02 When a DELETE request with valid authorization credentials
    and without the required (id) is sent to
    the 'api/tickets/delete/{{id}}' endpoint, it should return a status code of 203,
    and the message in the request body should be "No id"

      * The API user sets "api/tickets/delete" path parameters
      * The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API adminuser verifies that the message information in the response body is "No id"

  @api
    Scenario Outline: TC_03 When a DELETE request with valid authorization credentials and
   an (id) that does not correspond to an existing record is sent to the
  'api/tickets/delete/{{id}}' endpoint, it should return a status code of 203,
   and the message in the request body should be "No ticket."

      * The API user sets "api/tickets/delete/<id>" path parameters
      * The API adminuser saves the response from the user ticket delete endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API adminuser verifies that the message information in the response body is "No ticket."

      Examples:
        | id |
        | 45677834786843|
  @api
      Scenario Outline: TC_04 When an invalid DELETE request body is sent with unauthorized credentials to the
      'api/tickets/delete/{{id}}' endpoint, it should return a status code of 401,
      and the error message in the request body should be "Unauthorized request"


        * The API user sets "api/tickets/delete/<id>" path parameters
        * The API adminuser saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized

        Examples:
          | id  |
          | 292 |
  @api
        Scenario Outline: TC_05 The deletion of the desired ticket record via API should be
        confirmed by sending a GET request to the 'api/tickets/details/{{id}}'
        endpoint with the Deleted ticket id obtained from the request body.
        This verification process ensures that the record has been successfully deleted

          * The API user sets "api/tickets/details/<id>" path parameters
          * The API adminuser saves the response from the user ticket detail endpoint with valid authorization information
          * The API user verifies that the status code is 203
          * The API adminuser verifies that the message information in the response body is "No ticket."

          Examples:
            | id |
            | 293 |



