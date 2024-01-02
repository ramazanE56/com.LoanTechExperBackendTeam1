
  Feature: API_US071 As an administrator, I should be able to delete the blog record in the
    system through the API connection.


    Scenario Outline: TC_01 Verify that when a DELETE request with valid authorization information and the correct
      'id' is sent to the 'api/blogs/remove/{{id}}' endpoint, the returned status code is 200,
      and the message in the request body is "Blog removed successfully"

      * The API user sets "api/blogs/remove/<id>" path parameters
      * The API user saves the response from the delete endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API admin verifies that the message information in the response body is "Blog removed successfully"
      Examples:
        | id  |
        | 141 |


    Scenario Outline: TC_02 When a DELETE request with valid authorization information and containing a
      non-existent 'id' is sent to the 'api/blogs/remove/{{id}}' endpoint, it should be verified that
      the returned status code is 203, and the message information in the request body indicates "No blog."

      * The API user sets "api/blogs/remove/<id>" path parameters
      * The API user saves the response from the delete endpoint with invalid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No blog."
      Examples:
        | id             |
        | 87687576565787 |


    Scenario Outline: TC_03 When a DELETE request with valid authorization information and without the 'id'
    is sent to the 'api/blogs/remove/{{id}}' endpoint, it should be verified that the returned status
    code is 203, and the message information in the request body indicates "No id"

      * The API user sets "api/blogs/remove/<id>" path parameters
      * The API user saves the response from the delete endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No id"
      Examples:
        | id |
        |    |

    Scenario Outline: TC_04 When an invalid authorization information is used to send a DELETE request
      body to the 'api/blogs/remove/{{id}}' endpoint, it should be verified that the returned status
      code is 401, and the error information in the request body indicates "Unauthorized request"

      * The API user sets "api/blogs/remove/<id>" path parameters
      * The API user saves the response from the delete endpoint with invalid authorization information

      Examples:
        | id  |
        | 141 |
 # https://qa.loantechexper.com/
    @wip
    Scenario Outline: TC_05 The deletion of the blogs record through the API should be verified. This can be
      confirmed by sending a GET request to the 'api/blogs/details/{{id}}' endpoint with the Removed  blog
      id returned in the request body

      * The API user sets "api/blogs/details/<id>" path parameters
      * The API adminuser saves the response from the user ticket list endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No blog"

      Examples:
        | id  |
        | 141 |
