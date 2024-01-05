
Feature: US_18 As an administrator, I want to access the loan plan details of a user with a specified ID via API connection.
  @api
  Scenario Outline: TC_01 When a GET request with valid authorization information and correct data
  (id) is sent to the api/loanplans/details/{{id}} endpoint, the returned status code should be 200, and the request remark should be verified as "success"

    * The API user sets "api/loanplans/details/<id>" path parameters
    * The API adminuser saves the response from the loanplans details endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"
    Examples:
      | id |
      | 139|

  @api
    Scenario: TC_02 api/loanplans/details/{{id}} endpoint'ine gecerli authorization bilgileri ve (id) icermeyen bir
    GET request gönderildiginde dönen status code'un 203 oldugu ve request message bilgisinin "No id" oldugu dogrulanmali

     * The API user sets "api/loanplans/details" path parameters
     * The API adminuser saves the response from the loanplans details endpoint with valid authorization information
     * The API user verifies that the status code is 203
     * The API adminuser verifies that the message information in the response body is "No id"
  @api
  Scenario Outline: TC_03 When a GET request with valid authorization information and no 'id' is sent to the
  api/loanplans/details/{{id}} endpoint, the returned status code should be 203, and the request message should be verified as "No id"

    * The API user sets "api/loanplans/details/<id>" path parameters
    * The API adminuser saves the response from the loanplans details endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API adminuser verifies that the message information in the response body is "No loanplans."
    Examples:
      | id |
      | 12|

    Scenario: TC_04 When a GET request with invalid authorization information is sent to the api/loanplans/details/{{id}}
    endpoint, the returned status code should be 401, and the error message in the request body should be verified as "Unauthorized request"
    * The API user sets "api/loanplans/details/<id>" path parameters
    * The API user records the response with invalid authorization information,



