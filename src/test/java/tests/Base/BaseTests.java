package tests.Base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Services.authProcess;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.authResponse;

public class BaseTests {
        protected static RequestSpecification reqSpec;
        protected static ResponseSpecification successfulResSpec;
        protected static ResponseSpecification failureResSpec;
        protected static ResponseSpecification deletionResSpec;    
        private static authProcess authentication;
        private static authResponse response;
        protected static String token;
        
        
        @BeforeSuite(alwaysRun=true)
        public void setUp(){
        authentication = new authProcess();
        response = authentication.requestAuth("admin","password123");
        token = response.getToken();
        reqSpec = new RequestSpecBuilder()
            .setBaseUri("https://restful-booker.herokuapp.com")
            .setContentType("application/json")
            .addCookie("token", token)
            .build();
            successfulResSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
            failureResSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .build();
            deletionResSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
    }
    @Test(groups="smoke")
      public void ping_shouldReturn201(){
        given()
        .spec(reqSpec)
        .get("/ping")
        .then()
        .statusCode(201);
      }
}
