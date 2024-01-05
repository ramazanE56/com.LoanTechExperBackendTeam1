@api
Feature: API_US011 : As an administrator, I want to access the list of categories via API connection.


  Scenario: TC01 : When a valid GET request is sent to the 'api/categories/list' endpoint with the appropriate authorization credentials,
  it should return a status code of 200, and the request remark should be "success"

    Given The API user sets "api/categories/list" path parameters
    And The API adminuser saves the response from the admin categories list endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"


  Scenario: TC02 :When an invalid GET request with unauthorized credentials is sent to the 'api/categories/list' endpoint,
  it should return a status code of 401, and the request error message should be "Unauthorized request"


    Given The API user sets "api/categories/list" path parameters
    Then The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  Scenario Outline: TC03: Verify the information returned in the request for the entity with id(x) (name, image, description, status, created_at, updated_at)

    Given The API user sets "api/categories/details/<id>" path parameters
    And The API user saves the response from the user ticket list endpoint with valid authorization information
    Then Verify the information of the one with the id  in the API admin response body <id>,<dataIndex>,"<name>","<image>","<description>",<status>,"<created_at>","<updated_at>"


    Examples:
    |id  | dataIndex | name   | image | description                                   | status | created_at                | updated_at                |
    |507 | 0         |Car Loan|null   |If you want to buy a car, this loan is for you.|1       |2023-12-27T16:46:47.000000Z|2023-12-27T16:46:47.000000Z|