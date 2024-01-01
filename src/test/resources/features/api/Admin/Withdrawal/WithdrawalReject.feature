
Feature:  As an administrator, I want to be able to reject the withdrawal information of a user with a given ID through the API connection.

  Scenario: TC01: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information, the correct (id), and accurate data (details) in the body,
                the expected behavior is that the status code in the request is 200.
                Additionally, the remark information in the request body should be confirmed as "success"

  Given The API user sets "/api/withdrawal/reject/{{id}}" path parameters
  When The API user sends POST request to "/api/withdrawal/reject/{{id}}" endpoint with valid authorization information
  Then The API user verifies that the status code is 200
  And The API User verifies that the message information in the response body is "success"


    Scenario: TC02: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information, the correct (id),
                  and without including data (details) in the body, the expected behavior is that the status code in the request is 200.
                  Additionally, the remark information in the request body should be confirmed as "success"

      Scenario: TC03: Verify that when a POST request with valid authorization information and a previously rejected (id) along with a body containing data fields (details) is sent to the 'api/withdrawal/reject/{{id}}' endpoint,
                      the returned status code is 203, and the message information in the request body is "No withdraw or withdraw status is not pending."

        Scenario: TC04: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information and without including the required (id) in the body (details),
                      the expected behavior is that the status code in the request is 203. Additionally, the message information in the request body should be confirmed as "No id"

          Scenario: TC05: When a valid POST request is sent to the 'api/withdrawal/reject/{{id}}' endpoint with proper authorization information and an (id) that corresponds to a non-existent record, along with a POST body (details),
                          the expected behavior is that the status code in the request is 203.
                          Additionally, the message information in the request body should be confirmed as "No withdraw."

            Scenario: TC06: When an invalid POST request with unauthorized authorization information is sent to the 'api/withdrawal/reject/{{id}}' endpoint, with the correct (id) and a POST body (details),
                      the expected behavior is that the status code in the request is 401.
                      Furthermore, the error information in the request body should be confirmed as "Unauthorized request"