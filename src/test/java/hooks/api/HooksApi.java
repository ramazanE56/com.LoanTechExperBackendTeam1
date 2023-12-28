package hooks.api;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import stepdefinitions.CommonApi;
import utilities.ApiUtils;
import utilities.ConfigReader;

public class HooksApi {
    public static RequestSpecification spec;



    @Before(order=0)
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }




}
