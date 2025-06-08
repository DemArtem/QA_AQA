package testng;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RequestMethodsTest {

    private final String baseUrl = "https://postman-echo.com";

    @Test
    public void testGetMethod() {
        Response response = RestAssured.given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get(baseUrl + "/get");

        // Проверка кода ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Код ответа должен быть 200");

        // Проверка тела ответа
        Assert.assertEquals(response.jsonPath().getString("args.foo1"), "bar1", "Значение args.foo1 неверное");
        Assert.assertEquals(response.jsonPath().getString("args.foo2"), "bar2", "Значение args.foo2 неверное");
    }
}