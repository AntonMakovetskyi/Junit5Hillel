package org.example.resttests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersApiTest {
    @Test
    public void usersTest() {
        BaseApiTest.setBaseRestAssuredSpec();
        List<UserObject> users = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .extract()
                .jsonPath()
                .getList("data", UserObject.class);

        Assertions.assertTrue(users.stream().allMatch(e -> e.getEmail().contains("@reqres.in")));
    }

    @Description(value = "it is register user test")
    @Test
    public void registerTest() throws IOException {
        BaseApiTest.setBaseRestAssuredSpec();
        RegisterObj credentials = new RegisterObj("eve.holt@reqres.in", "eve.holt@reqres.in", "pistol");
        given()
                .when()
//                .body("{\"email\":\"eve.holt@reqres.in\",\"username\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}")
                .body(credentials)
                .post("api/register")
                .then()
                .body("id", Matchers.equalTo(4))
                .body("token", Matchers.equalToCompressingWhiteSpace("  QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void baseAuthTest() {
        given()
                .when()
                .auth()
                .basic("postman", "password")
                .contentType(ContentType.JSON)
                .get("https://postman-echo.com/basic-auth")
                .then()
                .log().all()
                .statusCode(200);
    }
}
