package tests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class ForHelenCheckSubscribeTest {

    @Test
    public void checksubscribeTest() {
        RestAssured.baseURI = "https://shopdemo-alex-hot.koyeb.app";
        RestAssured.port = 443;
        String requestBody = "{\"email\":\"demo@demo.com\"}";
        String response =
                given()
                        .header("authority", "shopdemo-alex-hot.koyeb.app")
                        .header("accept", "application/json, text/plain, */*")
                        .header("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                        .header("cache-control", "no-cache")
                        .header("content-type", "application/json;charset=UTF-8")
                        .header("origin", "https://shopdemo-alex-hot.koyeb.app")
                        .header("pragma", "no-cache")
                        .header("sec-ch-ua", "\"Chromium\";v=\"122\", \"Not(A:Brand\";v=\"24\", \"Google Chrome\";v=\"122\"")
                        .header("sec-ch-ua-mobile", "?1")
                        .header("sec-ch-ua-platform", "\"Android\"")
                        .header("sec-fetch-dest", "empty")
                        .header("sec-fetch-mode", "cors")
                        .header("sec-fetch-site", "same-origin")
                        .header("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Mobile Safari/537.36")
                        .body(requestBody)
                        .when()
                        .post("/api/newsletter/subscribe")
                        .then()
                        /** проверка на статус код*/
                        .statusCode(200)
                        /** вывод тела в консоль (log.all() - вся информация)*/
                        .log().body()
                        /** проверка что "success": true */
                        .body("success", equalTo(true))
                        /** запись всё в переменную response */
                        .extract().asString();
        Assert.assertTrue(response.contains("You have successfully subscribed to the newsletter"));
        System.out.println("Response:  " + response);

    }
}

