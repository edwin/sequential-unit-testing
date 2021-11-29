package com.edw.controller;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 *     com.edw.controller.MainControllerTest
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 29 Nov 2021 14:25
 */
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("02. Class Run Second")
public class MainControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = this.port;
    }

    @Test
    @DisplayName("01. Test First")
    public void testPost() throws Exception {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("02. Test Second")
    public void testGet() throws Exception {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("03. Test Third")
    public void testPut() throws Exception {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put("/")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    @DisplayName("04. Test Forth")
    public void test404() throws Exception {
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .log()
                .all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/random-url")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
