
  Feature: API_US008 As a user, I want to access the user plan through API connection.


    Scenario: TC_01 When a GET request with valid authorization information is sent to the user/plan endpoint, the
      returned status code should be 200, and the request remark should be verified as "success"

      * The API user sets "user/plan" path parameters
      * The API user saves the response from the user ticket list endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API user verifies that the message information in the response body is "success"


    Scenario: TC_02 Verify that when a GET request is sent to the 'user/plan' endpoint with invalid authorization
    information, the returned status code is 401, and the error message in the request body is "Unauthorized request"

      * The API user sets "user/plan" path parameters
      * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    @api
    Scenario Outline: TC_03 Verify the information returned in the request for the entity with id(x)
    (name, image, description, status, created_at, updated_at)

      * The API user sets "'user/plan" path parameters
      * The API user saves the request from the user plan endpoint with valid authorization information
      * The API user verifies that the content of the <dataIndex> field in the request body includes <id>, "<name>", "<image>", "<description>", <status>, "<created_at>", "<updated_at>"
      Examples:
        | dataIndex | id  |  | name       | image | description    | status | created_at                  | updated_at                  |
        | 0         | 114 |  | Nidia Lind | null  | lonnie.kerluke | 1      | 2023-12-22T18:39:41.000000Z | 2023-12-22T18:39:41.000000Z |


    # "id": 114,
    # "name": "Nidia Lind",
    # "image": null,
    # "description": "lonnie.kerluke",
    # "status": 1,
    # "created_at": "2023-12-22T18:39:41.000000Z",
    # "updated_at": "2023-12-22T18:39:41.000000Z",
