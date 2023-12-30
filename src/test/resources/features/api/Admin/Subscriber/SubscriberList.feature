Feature: API_US023: As an administrator, I want to access the list of subscribers via API connection.
@ism11
Scenario: TC01  When a valid GET request is sent to the 'api/subscriber/list' endpoint with
                  the appropriate authorization credentials, it should return a status code of 200, and the request remark should be "success"

  Given The API user sets "api/subscriber/list" path parameters
  And The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
  Then The API user verifies that the status code is 200
  And The API user verifies that the remark information in the response body is "success"


  Scenario: TC02  "When an invalid GET request with unauthorized credentials
                    is sent to the 'api/subscriber/list' endpoint, it should return a status code of 401,
                    and the request error message should be "Unauthorized request"

    Given The API user sets "api/subscriber/list" path parameters
    Then The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

@ism12
   Scenario Outline: TC03  Verify the information returned in the request for the entity with id(x) (email, created_at, updated_at)

     Given The API user sets "api/subscriber/list" path parameters
     And The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information
     Then Verify information of the one with the id <dataIndex> in the API admin response body "<email>" "<created_at>" "<updated_at>".

     Examples:
       | dataIndex | email            | created_at                  | updated_at                  |
       | 0         | megenc@gmail.com | 2023-12-28T00:08:43.000000Z | 2023-12-28T00:08:43.000000Z |



