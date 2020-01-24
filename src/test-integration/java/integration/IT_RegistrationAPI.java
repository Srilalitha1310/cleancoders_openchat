package integration;

import com.eclipsesource.json.JsonObject;
import integration.dsl.OpenChatTestDSL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openchat.OpenChatApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static integration.IT_Constants.BASE_URL;
import static integration.IT_Constants.UUID_PATTERN;
import static integration.dsl.UserDSL.ITUserBuilder.aUser;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = OpenChatApplication.class)
public class IT_RegistrationAPI {

    @Test void
    register_a_new_user() {
        given()
                .contentType(JSON)
                .body(withJsonContaining("Lucy", "alki324d", "About Lucy"))
        .when()
                .post(BASE_URL + "/users")
        .then()
                .statusCode(201)
                .contentType(JSON)
                .body("id", matchesPattern(UUID_PATTERN))
                .body("username", is("Lucy"))
                .body("about", is("About Lucy"));
    }

    @Test void
    double_registration_attempt_fails() {
        OpenChatTestDSL.register(aUser().withUsername("john"));

        given()
                .contentType(JSON)
                .body(withJsonContaining("john", "anything", "About John"))
        .when()
                .post(BASE_URL + "/users")
                .prettyPeek()
        .then()
                .statusCode(400)
                .contentType(JSON)
                .body("message", is("Username already in use"));
    }

    private String withJsonContaining(String username, String password, String about) {
        return new JsonObject()
                        .add("username", username)
                        .add("password", password)
                        .add("about", about)
                        .toString();
    }
}
