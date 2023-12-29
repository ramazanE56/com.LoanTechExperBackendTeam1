Feature: US_028: As an administrator, I want to access the list of tickets via API connection.

  Scenario: TC_01: When a GET request with valid authorization information is sent to the 'api/tickets/list' endpoint, it should be verified that the returned status code is 200, and the remark information in the request indicates "success"

    Given The API admin sets "admin/ticket/list" path parameters
    And The API adminuser saves the response from the user ticket list endpoint with valid authorization information
    Then The API user verifies that the status code is 200
    And The API user verifies that the remark information in the response body is "success"

    Scenario: TC_02: When an invalid GET request with unauthorized credentials is sent to the 'api/tickets/list' endpoint, it should return a status code of 401, and the request error message should be "Unauthorized request"

      Given The API admin sets "admin/ticket/list" path parameters
      Then The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  Scenario Outline: TC_03: Verify the information (user_id, name, email, ticket, subject, status, priority, last_reply, created_at, updated_at) returned in the request for Id(x)

    Given The API admin sets "admin/ticket/list" path parameters
    And The API adminuser saves the response from the user ticket list endpoint with valid authorization information
    Then Verify the information of the one with the id <dataIndex> in the API user response body: <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"


    Examples:
      | dataIndex | user_id | name                 | email | ticket | subject     | status | priority | last_reply          | created_at                  | updated_at                  |
      | 0         | 196     | suphi atilim celikoz | s@c   | 147867 | Test Ticket | 3      | 0        | 2023-12-28 08:53:34 | 2023-12-28T13:53:34.000000Z | 2023-12-28T14:13:33.000000Z |