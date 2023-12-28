Feature: API_US013 : As an administrator, I want to create a new category record via API connection.

  @ism1
  Scenario: TC01 : When a POST request with valid authorization information and correct data (name, description)
            is sent to the api/categories/add endpoint, the returned status code should be 200, and the remark in
            the response body should be verified as "success"

    Given The API user sets "api/categories/add" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data (name, description)
    When The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"

  @ism2
    Scenario: TC02 : When a POST (name, description) request with valid authorization information and incomplete missing
                      data (description) is sent to the api/categories/add endpoint, the returned status code should be 203,
                      and the remark in the request body should be verified as "failed"

      Given The API user sets "api/categories/add" path parameters
      And The API adminuser prepares a POST request containing the incorrect data to send to the admin categories add endpoint
      And The API adminuser prepares a POST request with valid authorization information and correct data Added category id
      Then The API user verifies that the status code is 203
      And The API user verifies that the remark information in the response body is "failed"

  @ism3
    Scenario: TC03 : When a POST request with valid authorization information and no data (name, description)
                    is sent to the api/categories/add endpoint, the returned status code should be 203, and the remark
                    in the request body should be verified as "failed"

      Given The API user sets "api/categories/add" path parameters
      And The API adminuser prepares a POST request without data to send to the admin categories add endpoint
      And The API adminuser prepares a POST request with valid authorization information and correct data Added category id
      Then The API user verifies that the status code is 203
      And The API user verifies that the remark information in the response body is "failed"


  @ism4
Scenario: TC04 : When a POST request with invalid authorization information and a
                  POST body (name, description) is sent to the api/categories/add endpoint,
                  the returned status code should be 401, and the error message in the request body should be verified as 'Unauthorized request'


  Given The API user sets "api/categories/add" path parameters
  And The API adminuser prepares a POST request containing the correct data to send to the admin categories add endpoint
  When The API adminuser sends a POST request and saves the response from the admin categories add endpoint with invalid authorization information
  Then The API user verifies that the status code is 401
  And The API user verifies that the error information in the response body is "Unauthorized request"




  @ism5
  Scenario Outline: TC05 : The creation of a new category record through the API should be verified.
  This can be confirmed by sending a GET request to the api/categories/details/{{id}} endpoint with the
  Added category id returned in the request body

    Given The API user sets "api/categories/add" path parameters
    And The API adminuser prepares a POST request with valid authorization information and correct data Added category id
    Then The API user sets "api/categories/details/<id>" path parameters
    When The API adminuser saves the response from the categories add endpoint with valid authorization information get
    And The API adminuser verifies that the Added category id returned 507


    Examples:
      | id |
      | 507 |

