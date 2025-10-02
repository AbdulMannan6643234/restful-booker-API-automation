package Services;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.authRequest;
import models.authResponse;

public class authProcess{
        private authRequest request;
        private RequestSpecification reqSpec;
        private ResponseSpecification resSpec;
        public authProcess(){
            reqSpec = new RequestSpecBuilder()
            .setBaseUri("https://restful-booker.herokuapp.com")
            .setContentType("application/json")
            .build();
            resSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
        }
        public authResponse requestAuth(String username,String password){
             request = new authRequest(username, password);
            authResponse response = 
            given()
            .spec(reqSpec)
            .body(request)
            .when()
            .post("/auth")
            .then()
            .spec(resSpec)
            .extract()
            .as(authResponse.class);
            return response;  
        }
}
