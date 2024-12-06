package cue.edu.ProyectoFinalPruebas.sistema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TaskControllerAPITest {

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 5432;
    }

    @Test
    public void testGetAllTasks() {
        given()
                .when()
                .get("tasks/tasks")
                .then()
                .statusCode(200)
                .body("$", not(empty())); // Verificar que no esté vacío
    }

    @Test
    public void testGetTaskById() {

        given()
                .when()
                .get("tasks/tasks/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", not(emptyOrNullString()));
    }

    @Test
    public void testCreateTask() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"Nueva Tarea\", \"description\": \"Descripción de la nueva tarea\", \"completed\": false}")
                .when()
                .post("tasks/tasks")
                .then()
                .statusCode(200)
                .body("title", equalTo("Nueva Tarea"))
                .body("description", equalTo("Descripción de la nueva tarea"))
                .body("completed", equalTo(false));
    }

    @Test
    public void testUpdateTask() {

        given()
                .contentType(ContentType.JSON)
                .body("{\"title\": \"Tarea Actualizada\", \"description\": \"Descripción actualizada\", \"completed\": true}")
                .when()
                .put("tasks/tasks/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Tarea Actualizada"))
                .body("description", equalTo("Descripción actualizada"))
                .body("completed", equalTo(true));
    }

    @Test
    public void testDeleteTask() {

        given()
                .when()
                .delete("tasks/tasks/1")
                .then()
                .statusCode(204); // No Content
    }
}
