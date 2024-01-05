@api
Feature: API_US010: As a user, I want to access the list of loans via API connection.
  Scenario: TC01: When a valid GET request is sent to the 'user/list/loan'
      endpoint with the appropriate authorization credentials, it should return
      a status code of 200, and the request remark should be "success"

    * The API user sets "user/list/loan" path parameters
    * The API user saves the response from the user list loan endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

  Scenario: TC02: Verify that when a GET request is sent to the 'user/list/loan'
    endpoint with invalid authorization information, the returned status code is 401, and the error message in the request body is "Unauthorized request"
    Given The API user sets "user/list/loan" path parameters
    Then The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    #Api kullanicisi responsei geçersiz authorization bilgisi ile kaydeder, status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular

  Scenario Outline: Verify the information returned in the request for the entity with id(x) (user_id, plan_id, amount, per_installment, installment_interval, delay_value, charge_per_installment, delay_charge, given_installment,)

    Given The API user sets "user/list/loan" path parameters
    Then Verify the information of the one with the id <dataIndex> in the API user response body: <id>, "<user_id>", "<plan_id>", "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", "<given_installment>"


    Examples:
      | dataIndex | id | user_id | plan_id | amount     | per_installment    | installment_interval | delay_value | charge_per_installment  | delay_charge   | given_installment |
      | 0         | 6  | 1       |   1     | 1000.00000000 | 30.00000000        | 30                   | 15           | 100.06000000          | 0.00000000     | 0 |

