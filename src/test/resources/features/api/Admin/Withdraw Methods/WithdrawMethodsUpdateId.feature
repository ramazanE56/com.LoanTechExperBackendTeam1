Feature: US_65:"As an administrator, I want to be able to update the information of registered
         withdrawal methods in the system through the API connection.
@12
Scenario: TC_01:When valid authorization information, correct 'id',
           and accurate data (name, min_limit, max_limit) are sent in a
           PATCH body to the 'api/withdraw/methods/update/{{id}}'
           endpoint, it should be verified that the returned status code is 200,
           and the message information in the request body is "Withdraw method updated successfully"


  Given The API user sets "api/withdraw/methods/update/<id>" path parameters
  And The API adminuser prepares a GET request containing the the correct id and accurate data send to the api withdrawal pending endpoint with valid authorization information
  Then The API adminuser prepares a PATCH request containing the the correct id and accurate data send to the api withdrawal uptaded endpoint with valid authorization information
  And The API adminuser sends a PATCH request and saves the response with valid authorization information
  Then The API user verifies that the status code is 200
  And The API user verifies that the remark information in the response body is "Withdraw method updated successfully"
















































