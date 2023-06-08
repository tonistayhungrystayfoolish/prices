package testIT;

import io.restassured.RestAssured;
import org.antoniogl.App;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = App.class)
class PricesManagementAdapterIT {
    private static final String BASE_URI = "http://localhost:";
    private static final String PRODUCT_ID = "35455";
    private static final String BRAND_ID = "1";

    @LocalServerPort
    int port;

    private static Object[] getTestParameters() {
        return new Object[][]{
                {"2020-06-14T00:00:00", 35.5F, 1, "2020-06-14T00:00:00", "2020-12-31T23:59:59"},
                {"2020-06-14T16:00:00", 25.45F, 2, "2020-06-14T15:00:00", "2020-06-14T18:30:00"},
                {"2020-06-14T21:00:00", 35.50F, 1, "2020-06-14T00:00:00", "2020-12-31T23:59:59"},
                {"2020-06-15T10:00:00", 30.50F, 3, "2020-06-15T00:00:00", "2020-06-15T11:00:00"},
                {"2020-06-16T21:00:00", 38.95F, 4, "2020-06-15T16:00:00", "2020-12-31T23:59:59"}
        };
    }

    @ParameterizedTest
    @MethodSource("getTestParameters")
    void shouldReturnPriceForProductAndBrand(String filterDate, float expectedPrice, int expectedPriceList, String expectedStartDate, String expectedEndDate) {
        String url = String.format("/api/v1/prices?filterDate=%s&productId=%s&brandId=%s", filterDate, PRODUCT_ID, BRAND_ID);
        RestAssured.given().contentType(JSON)
                .when().get(BASE_URI + port + url)
                .then().log().body()
                .statusCode(OK.value())
                .body("productId", equalTo(Integer.parseInt(PRODUCT_ID)))
                .body("brandId", equalTo(Integer.parseInt(BRAND_ID)))
                .body("price", is(expectedPrice))
                .body("priceList", equalTo(expectedPriceList))
                .body("startDate", equalTo(expectedStartDate))
                .body("endDate", equalTo(expectedEndDate))
                .extract();
    }
}