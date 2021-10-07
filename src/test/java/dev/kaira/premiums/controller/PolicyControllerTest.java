package dev.kaira.premiums.controller;

import dev.kaira.premiums.DataProvider;
import dev.kaira.premiums.dto.Policy;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


@QuarkusTest
@TestHTTPEndpoint(PolicyController.class)
class PolicyControllerTest {

    @ParameterizedTest
    @ArgumentsSource(DataProvider.class)
    @DisplayName("test \"/calculate\" POST endpoint")
    void calculate(Policy policy) {
        given()
                .contentType(JSON)
                .body(policy)
                .when().post("/calculate")
                .then()
                .statusCode(200)
                .body(is("2.28"));
    }
}
