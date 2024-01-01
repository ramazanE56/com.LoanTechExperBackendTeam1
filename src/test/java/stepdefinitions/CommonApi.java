package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ApiUtils;
import utilities.ConfigReader;

import static hooks.api.HooksApi.spec;

import static io.restassured.RestAssured.given;

public class CommonApi extends ApiUtils {

    public static String fullPath;
    Response response;
    String mesaj;
    JsonPath jsonPath;
    JSONObject requestBody;
    int createdID;

    @Given("The API user sets {string} path parameters")
    public void the_apı_user_sets_path_parameters(String rawPaths) {
        fullPath = pathParameters(rawPaths);
    }

    @And("The API user saves the response from the user ticket list endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheUserTicketListEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Then("The API user verifies that the status code is {int}")
    public void theAPIUserVerifiesThatTheStatusCodeIs(int status) {
        response.then()
                .assertThat()
                .statusCode(status);
    }

    @And("The API user verifies that the remark information in the response body is {string}")
    public void theAPIUserVerifiesThatTheRemarkInformationInTheResponseBodyIs(String remark) {
        response.then()
                .assertThat()
                .body("remark", Matchers.equalTo(remark));
    }


    @Then("The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized")
    public void theAPIUserRecordsTheResponseWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized() {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .get(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }

    @Then("Verify the information of the one with the id {int} in the API user response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(user_id, jsonPath.getInt("data[" + dataIndex + "].user_id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(email, jsonPath.getString("data[" + dataIndex + "].email"));
        Assert.assertEquals(ticket, jsonPath.getString("data[" + dataIndex + "].ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data[" + dataIndex + "].subject"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertEquals(priority, jsonPath.getInt("data[" + dataIndex + "].priority"));
        Assert.assertEquals(last_reply, jsonPath.getString("data[" + dataIndex + "].last_reply"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));
    }

    @And("The API user saves the response from the user ticket detail endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheUserTicketDetailEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @And("The API user verifies that the success attribute in the response body is true")
    public void theAPIUserVerifiesThatTheSuccessAttributeInTheResponseBodyIsTrue() {
        response.then()
                .assertThat()
                .body("success", Matchers.equalTo(true));
    }

    @And("The API User verifies that the message information in the response body is {string}")
    public void theAPIUserVerifiesThatTheMessageInformationInTheResponseBodyIs(String message) {
        response.then()
                .assertThat()
                .body("data.message", Matchers.equalTo(message));
    }

    @Then("The API user verifies that the content of the data field in the response body includes {int}, {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void the_apı_user_verifies_that_the_content_of_the_data_field_in_the_response_body_includes(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(name, jsonPath.getString("data.name"));
        Assert.assertEquals(email, jsonPath.getString("data.email"));
        Assert.assertEquals(ticket, jsonPath.getString("data.ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data.subject"));
        Assert.assertEquals(status, jsonPath.getInt("data.status"));
        Assert.assertEquals(priority, jsonPath.getInt("data.priority"));
        Assert.assertEquals(last_reply, jsonPath.getString("data.last_reply"));
        Assert.assertEquals(created_at, jsonPath.getString("data.created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data.updated_at"));
    }

    @And("The API user prepares a POST request containing the correct data to send to the user ticket add endpoint")
    public void theAPIUserPreparesAPOSTRequestContainingTheCorrectDataToSendToTheUserTicketAddEndpoint() {
        /*
        {
    "subject":"Test Ticket",
    "priority":"Medium",
    "message":"Test Ticket Message"
}
         */
        requestBody = new JSONObject();
        requestBody.put("subject", "Test Ticket");
        requestBody.put("priority", "Medium");
        requestBody.put("message", "Test Ticket Message");

    }

    @When("The API user sends a POST request and saves the response from the user ticket add endpoint with valid authorization information")
    public void theAPIUserSendsAPOSTRequestAndSavesTheResponseFromTheUserTicketAddEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

    @Then("The API user verifies that the message information in the response body is {string}")
    public void the_apı_user_verifies_that_the_message_information_in_the_response_body_is(String message) {
        response.then()
                .assertThat()
                .body("message", Matchers.equalTo(message));
    }

    @And("The API user prepares a POST request without data to send to the user ticket add endpoint")
    public void theAPIUserPreparesAPOSTRequestWithoutDataToSendToTheUserTicketAddEndpoint() {
        requestBody = new JSONObject();
    }

    @And("The API user prepares a POST request with missing data to send to the user ticket add endpoint.")
    public void theAPIUserPreparesAPOSTRequestWithMissingDataToSendToTheUserTicketAddEndpoint() {
        requestBody = new JSONObject();
        requestBody.put("subject", "Test Ticket");
    }

    @When("The API user sends a POST request and saves the response from the user ticket add endpoint with invalid authorization information")
    public void theAPIUserSendsAPOSTRequestAndSavesTheResponseFromTheUserTicketAddEndpointWithInvalidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

    @And("The API user verifies that the error information in the response body is {string}")
    public void theAPIUserVerifiesThatTheErrorInformationInTheResponseBodyIs(String error) {
        response.then()
                .assertThat()
                .body("message.error[0]", Matchers.equalTo(error));
    }

    @Then("The API user verifies that the id information in the response body is {int}")
    public void the_apı_user_verifies_that_the_id_information_in_the_response_body_is(int id) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data.id"));
    }

    @And("The API user saves the response from the user ticket close endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheUserTicketCloseEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .patch(fullPath);

        response.prettyPrint();
    }


    @And("The API adminuser prepares a POST request with valid authorization information and correct data \\(name, description)")
    public void theAPIAdminuserPreparesAPOSTRequestWithValidAuthorizationInformationAndCorrectDataNameDescription() {
/*
{
    "name":"Car Loan",
    "description":"If you want to buy a car, this loan is for you."
}
 */
        requestBody = new JSONObject();
        requestBody.put("name", "Car Loan");
        requestBody.put("description", "If you want to buy a car, this loan is for you.");


    }

    @When("The API adminuser sends a POST request and saves the response from the user ticket add endpoint with valid authorization information")
    public void theAPIAdminuserSendsAPOSTRequestAndSavesTheResponseFromTheUserTicketAddEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }


    @When("The API adminuser saves the response from the categories add endpoint with valid authorization information")
    public void theAPIAdminuserSavesTheResponseFromTheCategoriesAddEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

    @And("The API adminuser prepares a POST request with valid authorization information and correct data Added category id")
    public void theAPIAdminuserPreparesAPOSTRequestWithValidAuthorizationInformationAndCorrectDataNameDescriptionAddedCategoryid() {

        requestBody = new JSONObject();
        requestBody.put("data.Added category id", "Car Loan");
    }

    @When("The API adminuser saves the response from the categories add endpoint with valid authorization information get")
    public void theAPIAdminuserSavesTheResponseFromTheCategoriesAddEndpointWithValidAuthorizationInformationGet() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .get(fullPath);

        response.prettyPrint();
    }

    @And("The API adminuser verifies that the Added category id returned {int}")
    public void theAPIAdminuserVerifiesThatTheAddedCategoryIdReturned(int id) {
        response.then()
                .assertThat()
                .body("data[0].id", Matchers.equalTo(id));

    }

    @And("The API adminuser prepares a POST request containing the correct data to send to the admin categories add endpoint")
    public void theAPIAdminuserPreparesAPOSTRequestContainingTheCorrectDataToSendToTheAdminCategoriesAddEndpoint() {
         /*
{
    "name":"Car Loan",
    "description":"If you want to buy a car, this loan is for you."
}
         */
        requestBody = new JSONObject();
        requestBody.put("name", "Car Loan");
        requestBody.put("description", "If you want to buy a car, this loan is for you.");


    }

    @When("The API adminuser sends a POST request and saves the response from the admin categories add endpoint with invalid authorization information")
    public void theAPIAdminuserSendsAPOSTRequestAndSavesTheResponseFromTheAdminCategoriesAddEndpointWithInvalidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

    @And("The API adminuser prepares a POST request containing the incorrect data to send to the admin categories add endpoint")
    public void theAPIAdminuserPreparesAPOSTRequestContainingTheIncorrectDataToSendToTheAdminCategoriesAddEndpoint() {
        requestBody = new JSONObject();
        requestBody.put("name", "Car Loan");
        requestBody.put("description", "If you want to buy a car, this loan for you.");
    }

    @And("The API adminuser prepares a POST request without data to send to the admin categories add endpoint")
    public void theAPIAdminuserPreparesAPOSTRequestWithoutDataToSendToTheAdminCategoriesAddEndpoint() {
        requestBody = new JSONObject();
    }

    @Then("The API user saves the response from the user ticket close endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized")
    public void theAPIUserSavesTheResponseFromTheUserTicketCloseEndpointWithInvalidAuthorizationInformationAndVerifiesThatTheStatusCodeIsAndTheErrorMessageIsUnauthorized() {

        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .patch(fullPath);

            response.prettyPrint();
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }

    @And("The API user Verifies that the status information in the response body is {int}")
    public void theAPIUserVerifiesThatTheStatusInformationInTheResponseBodyIsStatus(int status) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(status, jsonPath.getInt("data.status"));
    }


    @And("The API adminuser saves the response from the admin subscriber list endpoint with valid authorization information")
    public void theAPIAdminuserSavesTheResponseFromTheAdminSubscriberListEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Given("The API user prepares a POST request with correct data to send to the user changepassword add endpoint.")
    public void the_apı_user_prepares_a_post_request_with_correct_data_to_send_to_the_user_changepassword_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("current_password", "Loan.741");
        requestBody.put("password", "Loan.741");

    }

    @Given("The API user saves the response from the user changepassword detail endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_changepassword_detail_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .body(requestBody.toString())
                .patch(fullPath);

        response.prettyPrint();
    }

    @Given("The API user prepare a POST request with missing data to send to the user ticket add endpoint.")
    public void the_apı_user_prepare_a_post_request_with_missing_data_to_send_to_the_user_ticket_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("current_password", "Loan.741");
        requestBody.put("password", "1234567");
    }

    @Given("The API user prepares a post request consisting of uppercase and lowercase letters and numbers to be sent to the user ticket add endpoint.")
    public void the_apı_user_prepares_a_post_request_consisting_of_uppercase_and_lowercase_letters_and_numbers_to_be_sent_to_the_user_ticket_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("current_password", "Loan.741");
        requestBody.put("password", "Ab1123");
    }

    @Given("The API user recordss the response with invalid authorization information, verifies that the status code is {string} and confirms that the error information is Unauthorized")
    public void the_apı_user_recordss_the_response_with_invalid_authorization_information_verifies_that_the_status_code_is_and_confirms_that_the_error_information_is_unauthorized(String string) {
        try {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .patch(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));

    }

    @Given("The API adminuser saves the response from the loanplans details endpoint with valid authorization information")
    public void the_apı_adminuser_saves_the_response_from_the_loanplans_details_endpoint_with_valid_authorization_information_get() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Given("The API adminuser verifies that the message information in the response body is {string}")
    public void the_apı_adminuser_verifies_that_the_message_information_in_the_response_body_is(String message) {
        response.then()
                .assertThat()
                .body("data.message", Matchers.equalTo(message));


    }
    @Given("The API user records the response with invalid authorization information,")
    public void the_apı_user_records_the_response_with_invalid_authorization_information() {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .get(fullPath);

            response.prettyPrint();
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));


    }


    @Given("The API user prepares a PATCH request containing the correct data to send to the user changepassword add endpoint")
    public void the_apı_user_prepares_a_patch_request_containing_the_correct_data_to_send_to_the_user_changepassword_add_endpoint() {

        requestBody = new JSONObject();
        requestBody.put("current_password", "Loan.741");
        requestBody.put("password", "Ab1123");
        /*
        {
    "current_password":"Abc409087.",
    "password":"123123"
}
         */
    }

    @Given("The API adminuser saves the response from the blogs add  endpoint with valid authorization information")
    public void the_apı_adminuser_saves_the_response_from_the_blogs_add_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }
    @Given("The API adminuser saves the GET response from the blogs add  endpoint with valid authorization information")
    public void the_apı_adminuser_saves_the_get_response_from_the_blogs_add_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();

    }

    @Given("The API adminuser saves the response from the user ticket delete endpoint with valid authorization information")
    public void the_apı_adminuser_saves_the_response_from_the_user_ticket_delete_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
    }
    @Then("The API adminuser saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is {string} and the error message is Unauthorized")
    public void the_apı_adminuser_saves_the_response_from_the_user_ticket_delete_endpoint_with_invalid_authorization_information_and_confirms_that_the_status_code_is_and_the_error_message_is_unauthorized(String string) {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .delete(fullPath);

            response.prettyPrint();
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));

    }
    @Given("The API adminuser saves the response from the user ticket detail endpoint with valid authorization information")
    public void the_apı_adminuser_saves_the_response_from_the_user_ticket_detail_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Given("The API user prepare a POST request containing the correct data to send to the user ticket add endpoint")
    public void the_apı_user_prepare_a_post_request_containing_the_correct_data_to_send_to_the_user_ticket_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("title", "Test Blog 3");
        requestBody.put("description", "Test açıklama 3");
    }

    @Given("The API user prepare a POST request containing the missing data to send to the user ticket add endpoint")
    public void the_apı_user_prepare_a_post_request_containing_the_missing_data_to_send_to_the_user_ticket_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("title", "Test Blog 3");
        requestBody.put("description", "");
    }

    @Given("The API user prepare a POST request containing the empty data to send to the user ticket add endpoint")
    public void the_apı_user_prepare_a_post_request_containing_the_empty_data_to_send_to_the_user_ticket_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("", "");
        requestBody.put("", "");
    }

    @Given("The API adminuser records the response with invalid authorization information,")
    public void the_apı_adminuser_records_the_response_with_invalid_authorization_information() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

}

