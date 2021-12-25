package apiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.*;
import utils.ReadPropertiesFile;

public class ReqresTest extends TestRunnerApi {

	Response response;
	String jsonString;

	@Before
	public void setup() throws Exception {
		ReadPropertiesFile.loadProperties();
		softAssert = new SoftAssert();
	}

	@Given("User has hit the api")
	public void user_has_hit_the_api() throws Exception {

		log.info("user_has_hit_the_api");
		RestAssured.baseURI = ReadPropertiesFile.readApiBaseUri();

		RequestSpecification request = RestAssured.given();
		request.queryParam("page", "2").header("ContentType", "application/json");
		response = request.get("/users");

	}

	@Then("Verify status code is {int}")
	public void verify_status_code_is(Integer statusCode) {
		Assert.assertEquals(response.getStatusCode(), (int) statusCode);

	}

	@Then("Verify the value of {string} for id {string} is {string}")
	public void verify_the_value_of_for_id_is(String dataFieldName, String id, String name) {
		JsonPath js = new JsonPath(response.asString());
		int dataCount = js.getInt("data.size()");
		log.info("Api response ,data count -->" + dataCount);

		for (int i = 0; i < dataCount; i++) {
			if (js.getInt("data[" + i + "].id") == Integer.valueOf(id)) {
				softAssert.assertEquals(js.getString("data[" + i + "]." + dataFieldName + ""), name);
				break;
			}
		}
	}

	@After
	public void tearDown() {
		softAssert.assertAll();
	}

}
