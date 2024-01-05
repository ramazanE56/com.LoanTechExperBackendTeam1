Feature: API_US014:As an administrator, I want to update the existing category information via API connection.
  @api
  Scenario: TC01 When a POST request with valid authorization information, correct 'id', and valid data (name)
  is sent to the api/categories/update/{{id}} endpoint, the returned status code should be 200, and the
  message in the request body should be verified as "Category updated successfully"

    Given The API admin sets "api/categories/update/634" path parameters
    And The API user prepares a POST request containing the correct data to send to the admin categories add endpoint
    #Api kullanicisi user ticket add endpointine gondermek icin dogru datalar iceren bir post request hazirlar
    When The API user sends a POST request and saves the response from the admin categories add endpoint with valid authorization information
    #Api kullanicisi post request gonderir ve user ticket add endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 200
    And The API admin verifies that the message information in the response body is "Category updated successfully"
    #Api kullanicisi response bodydeki message bilgisinin "Category added successfully" oldugunu doğrular
  @api
  Scenario: TC02 When a POST request with valid authorization information, correct 'id', and valid data (name)
  is sent to the api/categories/update/{{id}} endpoint, the returned status code should be 200, and the message
  n the request body should be verified as "Category updated successfully"

    Given The API admin sets "api/categories/update/634" path parameters
    And The API admin prepares a POST request containing the correct data to send to the admin categories add endpoint
    #Api kullanicisi user ticket add endpointine gondermek icin dogru datalar iceren bir post request hazirlar
    When The API user sends a POST request and saves the response from the admin categories add endpoint with valid authorization information
    #Api kullanicisi post request gonderir ve user ticket add endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 200
    And The API admin verifies that the message information in the response body is "Category updated successfully"
    #Api kullanicisi response bodydeki message bilgisinin "Category added successfully" oldugunu doğrular


  Scenario: TC03 When a POST request with valid authorization information, correct 'id', and no data (name, description)
  is sent to the api/categories/update/{{id}} endpoint, the returned status code should be 203, and the remark in the
  request body should be verified as "failed"

    Given The API user sets "api/categories/update/634" path parameters
    And The API administrator prepares a POST request with incorrect data to be sent to the admin categories adding endpoint
    #Api kullanicisi user ticket add endpointine gondermek icin data icermeyen bir post request hazirlar
    When The API user sends a POST request and saves the response from the admin categories add endpoint with valid authorization information
    Then The API user verifies that the status code is 203
    And The API user verifies that the remark information in the response body is "failed"
    #Api kullanicisi response bodydeki remark bilgisinin "failed" oldugunu dogrular

  @api
  Scenario: TC04 When a POST request with valid authorization information and no 'id' is sent to the
  api/categories/update/{{id}} endpoint with a POST body containing data (name, description), the returned status
  code should be 203, and the message in the request body should be verified as "No id."

    Given The API admin sets "api/categories/update" path parameters
    And The API user prepares a POST request containing the correct data to send to the admin categories add endpoint
    #Api kullanicisi user ticket add endpointine gondermek icin dogru datalar iceren bir post request hazirlar
    When The API user sends a POST request and saves the response from the admin categories add endpoint with valid authorization information
    #Api kullanicisi post request gonderir ve user ticket add endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 203
    And The API admin verifies that the message information in the response body is "No id."

  @api
  Scenario: TC05 When a POST request with valid authorization information and a non-existent 'id' is sent to the
  api/categories/update/{{id}} endpoint with a POST body containing data (name, description), the returned status
  code should be 203, and the message in the request body should be verified as "There is no category with this id to
  be updated"

    Given The API admin sets "api/categories/update/207" path parameters
    And The API user prepares a POST request containing the correct data to send to the admin categories add endpoint
    #Api kullanicisi user ticket add endpointine gondermek icin dogru datalar iceren bir post request hazirlar
    When The API user sends a POST request and saves the response from the admin categories add endpoint with valid authorization information
    #Api kullanicisi post request gonderir ve user ticket add endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 203
    And The API admin verifies that the message information in the response body is "There is no category with this id to be updated"


  @api
  Scenario: TC06 When a POST request with invalid authorization information, correct 'id', and a POST body
  (name, description) is sent to the api/categories/update/{{id}} endpoint, the returned status code should be 401,
  and the error message in the request body should be verified as "Unauthorized request"

    Given The API admin sets "api/categories/update/634" path parameters
    And The API user prepares a POST request containing the correct data to send to the admin categories add endpoint
    When The API user sends a POST request and saves the response from the user ticket add endpoint with invalid authorization information
    #Api kullanicisi post request gonderir ve user ticket add endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 401
    And The API user verifies that the error information in the response body is "Unauthorized request"
    #Api kullanicisi response bodydeki error bilgisinin "Unauthorized request" oldugunu dogrular

  @api
  Scenario: TC07 The update of the desired category record through the API should be verified. This can be confirmed by
  sending a GET request to the api/categories/details/{{id}} endpoint with the Updated Category Id returned in the
  request body to ensure that the record has been successfully updated

    Given The API user sets "api/categories/details/634" path parameters
    And The API admin saves the response from the admin categories details list endpoint with valid authorization information
    #Api kullanicisi user ticket list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    Then The API user verifies that the status code is 200
    #Api kullanicisi status codeun 200 oldugunu dogrular
    And The API user verifies that the remark information in the response body is "success"


