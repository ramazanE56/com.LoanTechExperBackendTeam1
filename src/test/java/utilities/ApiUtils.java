package utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.Arrays;

import static hooks.api.HooksApi.spec;
import static io.restassured.RestAssured.given;

public class ApiUtils {
    static JSONObject reqBody;

    static String fullPath;
    static JsonPath repJP;
    static String token;

    public static String pathParameters(String rawPaths) {

        // spec.pathParams("pp1","hub","pp2","list");
        // spec.pathParam("pp1","hub").pathParam("pp2","list");   => Bu iki ifade ayni isi yapar!

        // spec.pathParam("pp1","hub");
        // spec.pathParam("pp2","list");   => Bu iki ifade ayni isi yapar!

        // /{pp1}/{pp2}/{.}....


        String [] paths = rawPaths.split("/");

        StringBuilder tempPath = new StringBuilder("/{");

        for (int i = 0; i < paths.length ; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            spec.pathParam(key,value);

            tempPath.append( key + "}/{" );  // /{pp1}/{pp2}/{pp3}/{
        }

        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));

        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath);

        return fullPath;
    }

    public static Response postRequestAdmin(String Path,String adminUsername) {
        JSONObject reqBody = new JSONObject();

        reqBody.put("username",ConfigReader.getProperty(adminUsername));
        reqBody.put("password",ConfigReader.getProperty("adminpasswordApi"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + generateToken("admin"))
                .when().body(reqBody.toString())
                .get(Path);

        return response;

    }

    public static String generateToken(String swich) {

        JSONObject reqBody = null;

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        switch (swich) {
            case "admin":
                spec.pathParams("pp1", "api", "pp2", "admintoken");
                reqBody = new JSONObject();
                reqBody.put("username", ConfigReader.getProperty("usernameApi"));
                reqBody.put("password", ConfigReader.getProperty("adminpasswordApi"));
                break;
            case "user":
                spec.pathParams("pp1", "api", "pp2", "usertoken");
                reqBody = new JSONObject();
                reqBody.put("username", ConfigReader.getProperty("usernameApi"));
                reqBody.put("password", ConfigReader.getProperty("passwordApi"));
                break;

        }

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");


        JsonPath repJP = response.jsonPath();

        String token = repJP.getString("data.access_token");
        System.out.println("token = " + token);

        return token;
    }
    public static Response postRequestUser(String Path, String username) {
        JSONObject reqBody = new JSONObject();

        reqBody.put("username",ConfigReader.getProperty(username));
        reqBody.put("password",ConfigReader.getProperty("passwordApi"));
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + generateToken("user"))
                .when().body(reqBody.toString())
                .get(Path);

        return response;

    }
}