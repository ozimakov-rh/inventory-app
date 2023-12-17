package com.redhat.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class InventoryItemResourceTest {
    @Test
    void testItemEndpoint() {
        given()
          .when().get("/item")
          .then()
             .statusCode(200);
    }

}