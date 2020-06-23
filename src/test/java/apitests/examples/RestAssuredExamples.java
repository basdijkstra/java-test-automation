package apitests.examples;

import apitests.dataentities.Address;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class RestAssuredExamples {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

    @Test
    public void getUserAndCheckTheirName() {

        given().
        when().
            get("http://jsonplaceholder.typicode.com/users/1").
        then().
            assertThat().
        body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void getUserAndCheckResponseHeaders() {

        given().
        when().
            get("http://jsonplaceholder.typicode.com/users/1").
        then().
            assertThat().
            statusCode(200).
        and().
            header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void useQueryParameter() {

        given().
                queryParam("text","testcase").
                when().
                get("http://md5.jsontest.com").
                then().
                assertThat().
                body("md5", equalTo("7489a25fc99976f06fecb807991c61cf"));
    }

    @Test
    public void usePathParameter() {

        given().
            pathParam("userid", "1").
        when().
            get("http://jsonplaceholder.typicode.com/users/{userid}").
        then().
            assertThat().
            body("name", equalTo("Leanne Graham"));
    }

    @DataProvider
    public static Object[][] userData() {
        return new Object[][] {
                {1,"Leanne Graham"},
                {2,"Ervin Howell"}
        };
    }

    @Test
    @UseDataProvider("userData")
    public void checkNameForUserId
            (int userId, String expectedName) {

        given().
            pathParam("userid",userId).
        when().
            get("http://jsonplaceholder.typicode.com/users/{userid}").
        then().
            assertThat().
            body("name", equalTo(expectedName));
    }

    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createResponseSpec() {

        responseSpec =
                new ResponseSpecBuilder().
                        expectStatusCode(200).
                        expectContentType(ContentType.JSON).
                        build();
    }

    @Test
    public void useResponseSpec() {

        given().
        when().
            get("http://jsonplaceholder.typicode.com/users/1").
        then().
            spec(responseSpec).
        and().
            body("name", equalTo("Leanne Graham"));
    }

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpec() {

        requestSpec =
                new RequestSpecBuilder().
                        setBaseUri("http://jsonplaceholder.typicode.com").
                        build();
    }

    @Test
    public void useRequestSpec() {

        given().
            spec(requestSpec).
        when().
            get("/users/1").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void serializeAddressToJson() {

        Address myAddress = new Address("My street", 1, 1234, "Amsterdam");

        given().
                body(myAddress).
                when().
                post("http://localhost:9876/address").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void deserializeJsonToAddress() {

        Address myAddress =

                given().
                        when().
                        get("http://localhost:9876/address").
                        as(Address.class);

        Assert.assertEquals("Amsterdam", myAddress.getCity());
    }
}