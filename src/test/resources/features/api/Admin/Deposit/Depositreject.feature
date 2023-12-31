Feature: US_51:As an administrator, I want to be able to reject the deposit information
         of a user with a given ID through the API connection.

Scenario Outline: TC_01:When a valid POST request is sent to the 'api/deposit/reject/{{id}}'
            endpoint with proper authorization information, the correct (id),
            and the accurate data (message) in the body, the expected behavior
            is that the status code in the request is 200. Additionally,
            the message information in the request body
            should be confirmed as "Deposit request rejected successfully"


  Given The API user sets "api/deposit/reject/<id>" path parameters
  Then  The API adminuser prepares a POST request without data to send to the admin categories add endpoint


  
  Examples:
    | id  |
    | 1   |




