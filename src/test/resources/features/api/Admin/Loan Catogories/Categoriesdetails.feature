Feature: US_12 As an administrator, I want to access the category details of a user with a specified ID via API connection.

  Scenario Outline:TC_01:When a GET request with valid authorization information and correct data (id) is sent to the
  api/categories/details/{{id}} endpoint, the returned status code should be 200,
  and the request remark should be verified as "success"

    Given The API user sets "api/categories/details/<id>" path parameters
    Then The API adminuser saves the response from the categories details endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"


    Examples:
      | id |
      | 10 |

  Scenario:TC_02:When a GET request with valid authorization information and no 'id' is sent to the
  api/categories/details/{{id}} endpoint, the returned status code should be 203,
  and the request message should be verified as "No id"

    Given The API user sets "api/categories/details" path parameters
    Then The API adminuser saves the response from the categories details endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No id"

  Scenario Outline:TC_03: When a GET request with valid authorization information and a non-existent 'id' is sent to the
  api/categories/details/{{id}} endpoint,
  the returned status code should be 203, and the request message should be verified as "No category"

    Given The API user sets "api/categories/details/<id>" path parameters
    Then The API adminuser saves the response from the categories details endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API User verifies that the message information in the response body is "No category."

    Examples:
      | id  |
      | 777 |

  Scenario: TC_04:When a GET request with invalid authorization information is sent to the
  api/categories/details/{{id}} endpoint, the returned status code should be 401,
  and the error message in the request body should be verified as "Unauthorized request"

    Given The API user sets "api/categories/details/<id>" path parameters
    Then The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  Scenario Outline: The contents of data (id, name, image, description, status, created_at, updated_at) in the request body should be verified

    Given The API user sets "api/categories/details/<id>" path parameters
    And The API adminuser saves the response from the categories details endpoint with valid authorization information
    Then The API adminuser verifies that the content of the data field in the response body includes <id>,"<name>","<image>","<description>",<status>,"<created_at>","<updated_at>"

    Examples:
      | id  | name      |image|description|status |created_at                 |updated_at                 |
      | 1   | Basic Loan|null |Basic Loan |1      |2023-10-16T09:29:44.000000Z|2023-10-16T09:29:44.000000Z|
