
  Feature: API_US020 As an administrator, I want to update the existing loan plan information via API connection.


    Scenario Outline: TC_01 When a POST request with valid authorization information, correct 'id', and valid data (category_id,
      name, title) is sent to the api/loanplans/update/{{id}} endpoint, the returned status code should be 200,
      and the message in the response body should be verified as "Loanplans updated successfully"

      * The API user sets "api/loanplans/update/<id>" path parameters
      * The API adminuser prepares a POST request with valid authorization information and correct data (category_id, name, title)
      * The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API admin verifies that the message information in the response body is "Loanplan updated successfully"
      Examples:
        | id  |
        | 158 |


    Scenario Outline: TC_02 When a POST request with valid authorization information, correct 'id', and no data
      (category_id, name, title) is sent to the api/loanplans/update/{{id}} endpoint, the returned status
      code should be 203, and the remark in the request body should be verified as "failed"

      * The API user sets "api/loanplans/update/<id>" path parameters
      * The API adminuser prepares a POST request with valid authorization information and without data (category_id, name, title)
      * The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API user verifies that the remark information in the response body is "failed"

      Examples:
        | id  |
        | 158 |

    Scenario Outline: TC_03  When a POST request with valid authorization information and no 'id' is sent to the
      api/loanplans/update/{{id}} endpoint with a body containing data (category_id, name, title), the
      returned status code should be 203, and the message in the request body should be verified as "No id."

      * The API user sets "api/loanplans/update/<id>" path parameters
      * The API adminuser prepares a POST request with valid authorization information and correct data (category_id, name, title)
      * The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "No id."
      Examples:
        | id |
        |    |


    Scenario Outline: TC_04 When a POST request with valid authorization information and a non-existent
      'id' is sent to the api/loanplans/update/{{id}} endpoint with a body containing data (category_id,
      name, title), the returned status code should be 203, and the message in the request body should
      be verified as "There is no loanplans with this id to be updated"

      * The API user sets "api/loanplans/update/<id>" path parameters
      * The API adminuser prepares a POST request with valid authorization information and correct data (category_id, name, title)
      * The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API admin verifies that the message information in the response body is "There is no loanplans with this id to be updated"
      Examples:
        | id            |
        | 24587y5287528 |


    Scenario Outline: TC_05 When a POST request with invalid authorization information and a valid 'id' is
      sent to the api/loanplans/update/{{id}} endpoint with a body containing data (category_id, name, title),
      the returned status code should be 401, and the error message in the request body should be verified as
      "Unauthorized request"

      * The API user sets "api/loanplans/update/<id>" path parameters
      * The API user prepares a POST request containing the correct data to send to the user ticket add endpoint
      * The API user sends a POST request and saves the response from the user ticket add endpoint with invalid authorization information
      * The API user verifies that the status code is 401
      * The API user verifies that the error information in the response body is "Unauthorized request"

      Examples:
        | id |
        | 158  |


    Scenario Outline: TC_06 The update of the desired loanplans record through the API should be verified.
      This can be confirmed by sending a GET request to the api/loanplans/details/{{id}} endpoint with the
      Updated loan plan id returned in the request body to ensure that the record has been successfully updated.

      * The API user sets "api/loanplans/details/<id>" path parameters
      * The API user saves the response from the user ticket detail endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API user verifies that the success attribute in the response body is true
      * The API user verifies that the id information in the response body is <valueId>

      Examples:
        | id  | valueId |
        | 158 | 158     |




