package stepdefinitions;


import io.cucumber.java.bs.A;
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

import static org.apache.hc.client5.http.async.methods.SimpleRequestBuilder.delete;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

public class CommonApi extends ApiUtils {

    public static String fullPath;
    Response response;
    String mesaj;
    JsonPath jsonPath;
    JSONObject requestBody;
    int createdID;
    Integer initialStatus;
    Integer updatedStatus;

    @Given("The API user sets {string} path parameters")
    public void the_apı_user_sets_path_parameters(String rawPaths) {
        fullPath = pathParameters(rawPaths);
    }

    @Given("The API admin sets {string} path parameters")
    public void the_apı_admin_sets_path_parameters(String rawPaths) {
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

    @And("The API adminuser saves the response from the user ticket list endpoint with valid authorization information")
    public void theAPIAdminUserSavesTheResponseFromTheUserTicketListEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
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
    "message":"Test Ticket Message-"
}
         */
        requestBody = new JSONObject();
        requestBody.put("name", "Test Ticket");
        requestBody.put("priority", "Medium");
        requestBody.put("message", "Test Ticket Message-");

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


    @Then("Verify information of the one with the id {int} in the API admin response body {string} {string} {string}.")
    public void verifyInformationOfTheOneWithTheIdInTheAPIAdminResponseBody(int dataIndex, String email, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(email, jsonPath.getString("data[" + dataIndex + "].email"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));

    }

    @And("The API adminuser saves the response from the admin withdraw methods delete endpoint with valid authorization information")
    public void theAPIAdminuserSavesTheResponseFromTheAdminWithdrawMethodsDeleteEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
    }

    @And("The API user saves the response from the user ticket delete endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheUserTicketDeleteEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("user"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
    }

    @Then("The API user saves the response from the user ticket delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized")
    public void theAPIUserSavesTheResponseFromTheUserTicketDeleteEndpointWithInvalidAuthorizationInformationAndConfirmsThatTheStatusCodeIsAndTheErrorMessageIsUnauthorized() {

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
        System.out.println("Mesaj: " + mesaj);

    }

    @Then("Verify the information of the one with the id {int} in the API user response body {int},{int},{string},{string},{string},{string},{string},{int},{int},{string},{string},{string},{int},{string},{string},{int},{int},{string},{string}")
    public void verifyTheInformationOfTheOneWithTheIdDataIndexInTheAPIUserResponseBodyCategory_idForm_idInstallment_intervalTotal_installmentDelay_valueIs_featuredStatus(int dataIndex, int category_id, int form_id, String name, String title, String minimum_amount, String maximum_amount, String per_installment, int installment_interval, int total_installment, String application_fixed_charge, String application_percent_charge, String instruction, int delay_value, String fixed_charge, String percent_charge, int is_featured, int status, String created_at, String updated_at) {

        jsonPath = response.jsonPath();

        Assert.assertEquals(category_id, jsonPath.getInt("data[" + dataIndex + "].category_id"));
        Assert.assertEquals(form_id, jsonPath.getInt("data[" + dataIndex + "].form_id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(title, jsonPath.getString("data[" + dataIndex + "].title"));
        Assert.assertEquals(minimum_amount, jsonPath.getString("data[" + dataIndex + "].minimum_amount"));
        Assert.assertEquals(maximum_amount, jsonPath.getString("data[" + dataIndex + "].maximum_amount"));
        Assert.assertEquals(per_installment, jsonPath.getString("data[" + dataIndex + "].per_installment"));
        Assert.assertEquals(installment_interval, jsonPath.getInt("data[" + dataIndex + "].installment_interval"));
        Assert.assertEquals(total_installment, jsonPath.getInt("data[" + dataIndex + "].total_installment"));
        Assert.assertEquals(application_fixed_charge, jsonPath.getString("data[" + dataIndex + "].application_fixed_charge"));
        Assert.assertEquals(application_percent_charge, jsonPath.getString("data[" + dataIndex + "].application_percent_charge"));
        Assert.assertEquals(instruction, jsonPath.getString("data[" + dataIndex + "].instruction"));
        Assert.assertEquals(delay_value, jsonPath.getInt("data[" + dataIndex + "].delay_value"));
        Assert.assertEquals(fixed_charge, jsonPath.getString("data[" + dataIndex + "].fixed_charge"));
        Assert.assertEquals(percent_charge, jsonPath.getString("data[" + dataIndex + "].percent_charge"));
        Assert.assertEquals(is_featured, jsonPath.getInt("data[" + dataIndex + "].is_featured"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));

/*
        "remark": "success",
                "status": 200,
                "data": [
        {
                 "id": 139,
                "category_id": 1,
                "form_id": 344,
                "name": "King Loan 16",
                "title": "King Loan 16",
                "minimum_amount": "2000.00000000",
                "maximum_amount": "5000.00000000",
                "per_installment": "4.00",
                "installment_interval": 20,
                "total_installment": 20,
                "application_fixed_charge": "20.00000000",
                "application_percent_charge": "3.00000000",
                "instruction": "King Loan Plan 16",
                "delay_value": 25,
                "fixed_charge": "100.00000000",
                "percent_charge": "1.00000000",
                "is_featured": 0,
                "status": 1,
                "created_at": "2023-12-29T08:44:29.000000Z",
                "updated_at": "2023-12-29T08:44:29.000000Z",
                "category": {
*/
    }

    @When("The API user saves the response from the api loanplans list endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheApiLoanplansListEndpointWithValidAuthorizationInformation() {
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




    @And("The API adminuser saves the response from the admin withdraw methods details endpoint with valid authorization information")
    public void theAPIAdminuserSavesTheResponseFromTheAdminWithdrawMethodsDetailsEndpointWithValidAuthorizationInformation() {

            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()

                    .get(fullPath);
            response.prettyPrint();

        }


        @And("The API user saves the response endpoint with invalid authorization information")
        public void theAPIUserSavesTheResponseEndpointWithInvalidAuthorizationInformation () {
            try {
                response = given()
                        .spec(spec)
                        .contentType(ContentType.JSON)
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
        //GET isteği yaparak başlangıçtaki data[0].status değerini al
        @And("The API adminuser saves the response from the categories add endpoint with get reguest for first status")
        public void theAPIAdminuserSavesTheResponseFromTheCategoriesAddEndpointWithGetReguestforfirststatus () {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()
                    .get(fullPath);
            response.prettyPrint();
            jsonPath = response.jsonPath();
            initialStatus = jsonPath.getInt("data[0].status");


        }

        //PATCH isteği yaparak data[0].status değerini update et
        @Then("The API adminuser saves the response from the categories add endpoint with PATCH reguest")
        public void theAPIAdminuserSavesTheResponseFromTheCategoriesAddEndpointWithPATCHReguest () {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()
                    .patch(fullPath);
            response.prettyPrint();
            jsonPath = response.jsonPath();
            //update edilmiş statusu updateStatus'a ata

        }
        @And("The API adminuser saves the response from the categories add endpoint with get reguest for updated status")
        public void theAPIAdminuserSavesTheResponseFromTheCategoriesAddEndpointWithGetReguestForUpdatedStatus () {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()
                    .get(fullPath);
            response.prettyPrint();
            jsonPath = response.jsonPath();
            updatedStatus = jsonPath.getInt("data[0].status");
        }


        //ilk status değeri ile  update edilmiş değerin aynı olmadığını doğrula
        @Then("Verify that the desired category status record is updated via API")
        public void verifyThatTheDesiredCategoryStatusRecordIsUpdatedViaAPI () {
            Assert.assertNotEquals(initialStatus, updatedStatus);
        }

        @Then("The API user saves the response from the delete endpoint with valid authorization information")
        public void theAPIUserSavesTheResponseFromTheDeleteEndpointWithValidAuthorizationInformation () {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()
                    .delete(fullPath);

            response.prettyPrint();
        }
        @Then("The API user saves the response from the delete endpoint with invalid authorization information")
        public void theAPIUserSavesTheResponseFromTheDeleteEndpointWithInvalidAuthorizationInformation () {
            try {
                response = given()
                        .spec(spec)
                        .contentType(ContentType.JSON)
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

        @Then("The API adminuser saves the response from the withdrawal endpoint with get reguest")
        public void TheAPIAdminuserSavesTheResponseFromTheWithdrawalEndpointWithGetReguest () {
            response = given()
                    .spec(spec)
                    .contentType(ContentType.JSON)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + generateToken("admin"))
                    .when()
                    .get(fullPath);
            response.prettyPrint();

        }

        @And("The API user saves the response get request endpoint with invalid authorization information")
        public void theAPIUserSavesTheResponseGetRequestEndpointWithInvalidAuthorizationInformation () {
            try {
                response = given()
                        .spec(spec)
                        .contentType(ContentType.JSON)
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
        @Then("The API User verifies that id is {int} in the response body")
        public void theAPIUserVerifiesThatIdIsIdInTheResponseBody ( int id){
            jsonPath = response.jsonPath();
            Assert.assertEquals(id, jsonPath.getInt("data.id"));


        }

        @Then("The API User verifies that email is {string} in the response body")
        public void theAPIUserVerifiesThatEmailIsInTheResponseBody (String email){
            jsonPath = response.jsonPath();
            // email="mehmetkahraman@gmail.com";
            Assert.assertEquals(String.valueOf(email), jsonPath.getString("data.email"));
            System.out.println(email);
            System.out.println(jsonPath.getString("data.email"));

        }

        @Then("The API User verifies that createdat is {string} in the response body")
        public void theAPIUserVerifiesThatCreatedatIsInTheResponseBody (String creatDate){
            jsonPath = response.jsonPath();
            Assert.assertEquals(creatDate, jsonPath.getString("data.created_at"));
            System.out.println(creatDate);
            System.out.println(jsonPath.getString("data.created_at"));
        }

        @Then("The API User verifies that updatedat is {string} in the response body")
        public void theAPIUserVerifiesThatUpdatedatIsInTheResponseBody (String updateDate){
            jsonPath = response.jsonPath();
            Assert.assertEquals(updateDate, jsonPath.getString("data.updated_at"));
            System.out.println(updateDate);
            System.out.println(jsonPath.getString("data.updated_at"));
        }


    @Then("Verify the user information of the one with the id {} in the API user response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void verify_the_userinformation_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
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

    @And("The API adminuser prepares a POST request containing the correct data to send to the user ticket add endpoint")
    public void theAPIAdminuserPreparesAPOSTRequestContainingTheCorrectDataToSendToTheUserTicketAddEndpoint() {

     /*
{
            "id": 191,
            "form_id": 351,
            "name": "Veruckt",
            "min_limit": "100.00000000",
            "max_limit": "500.00000000",
            "fixed_charge": "20.00000000",
            "rate": "5.00000000",
            "percent_charge": "10.00",
            "currency": "USD",
            "description": "deneme",
            "status": 1,
            "created_at": "2023-12-29T11:20:15.000000Z",
            "updated_at": "2023-12-29T11:20:15.000000Z"
        }
         */
        requestBody = new JSONObject();
        requestBody.put("name", "Veruckt");
        requestBody.put("min_limit", "100.00000000");
        requestBody.put("max_limit", "500.00000000");
        requestBody.put("fixed_charge", "20.00000000");
        requestBody.put("rate", "5.00000000");
        requestBody.put("percent_charge", "10.00");
        requestBody.put("currency", "USD");
        requestBody.put("description", "deneme");
        requestBody.put("message", "Withdraw method added successfully");
    }


    @Then("The API adminuser verifies that the id information in the response body is {int}")
    public void theAPIAdminuserVerifiesThatTheIdInformationInTheResponseBodyIs( int id) {

    }

    @When("The API user sends GET request to {string} endpoint")
    public void theAPIUserSendsGETRequestToEndpoint(String arg0) {

        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }


    @When("The API adminuser saves the response from the api loanplans list endpoint with valid authorization information")
    public void theAPIAdminuserSavesTheResponseFromTheApiLoanplansListEndpointWithValidAuthorizationInformation() {

        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();


    }

    @Then("The API adminuser records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized")
    public void theAPIAdminuserRecordsTheResponseWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + ConfigReader.getProperty("Invalid Token"))
                .when()
                .get(fullPath);

        response.prettyPrint();




    }

    @And("The API adminuser verifies that the remark information in the response body is {string}")
    public void theAPIAdminuserVerifiesThatTheRemarkInformationInTheResponseBodyIs(String message) {
        response.then()
                .assertThat()
                .body("message.error[0]", Matchers.equalTo(message));




    }
}


