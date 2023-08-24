package org.example.resttests;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PestStoreApiTest {


    @Epic("API Testing")
    @Feature("Rest tests")
    @Story("Pet store story")
    @Step("Verify Pet store get test")
    @Test
    public void petStoreGetTest() throws IOException {
//        List<String> statuses =
        RequestSpecification requestSpecification = RestAssured.given()
                .when()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .param("status", "available")
                .baseUri("https://petstore.swagger.io/")
                .request();

        List<String> statuses = requestSpecification
                .get("v2/pet/findByStatus")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("status");

        Assertions.assertTrue(statuses.stream().allMatch(e -> e.equals("available")));
        stepRun(1, "firstRun");
        getBytes("user.json");
    }

    @Step("just using additional method with value {value} and name {runName}")
    public void stepRun(int value, String runName) {

    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/java/resources", resourceName));
    }
}
