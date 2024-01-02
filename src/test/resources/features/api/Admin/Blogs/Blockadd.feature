
  Feature: US_69 As an administrator, I want to be able to create a new blog record through the API connection.


@back
    Scenario: TC_01 When a valid authorization information and correct data (title, description) are sent in a POST body
    to the 'api/blogs/add' endpoint, it should be verified that the returned status code is 200, and the remark information in the request body indicates "success"

    * The API user sets "api/blogs/add" path parameters
    * The API user prepare a POST request containing the correct data to send to the user ticket add endpoint
    * The API adminuser saves the response from the blogs add  endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

      Scenario: TC_02 When valid authorization information and incomplete data (title, description)
      are sent in a POST body to the 'api/blogs/add' endpoint, it should be verified that
      the returned status code is 203, and the remark information in the request body indicates "failed"



        * The API user sets "api/blogs/add" path parameters
        * The API user prepare a POST request containing the missing data to send to the user ticket add endpoint
        * The API adminuser saves the response from the blogs add  endpoint with valid authorization information
        * The API user verifies that the status code is 203
        * The API user verifies that the remark information in the response body is "failed"

        Scenario: TC_03 When valid authorization information and an empty data (title, description)
        POST body are sent to the 'api/blogs/add' endpoint, it should be verified that the returned
        status code is 203, and the remark information in the request body indicates "failed"

          * The API user sets "api/blogs/add" path parameters
          * The API user prepare a POST request containing the empty data to send to the user ticket add endpoint
          * The API adminuser saves the response from the blogs add  endpoint with valid authorization information
          * The API user verifies that the status code is 203
          * The API user verifies that the remark information in the response body is "failed"

          Scenario: TC_04 When invalid authorization information and a POST body (title, description) are sent to the
          'api/blogs/add' endpoint, it should be verified that the returned status code is 401, and the error
          information in the request body indicates "Unauthorized request"

            * The API user sets "api/blogs/add" path parameters
            * The API user prepare a POST request containing the correct data to send to the user ticket add endpoint
            * The API adminuser records the response with invalid authorization information,
            * The API user verifies that the status code is 401
            * The API user verifies that the error information in the response body is "Unauthorized request"

            Scenario Outline: TC_05 The creation of a new blog record through the API should be verified.
            This can be confirmed by sending a GET request to the 'api/blogs/details/{{id}}'
            endpoint with the Added blog id returned in the request body

              * The API user sets "api/blogs/details/<id>" path parameters
              * The API adminuser saves the GET response from the blogs add  endpoint with valid authorization information
              * The API user verifies that the status code is 200
              * The API user verifies that the remark information in the response body is "success"

              Examples:
                | id |
                | 92|






