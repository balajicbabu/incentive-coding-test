package gamesys.hr.raffle.cucumber.stepdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import static org.junit.Assert.assertEquals;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import cucumber.api.java.en.*;
 
public class CreateRaffleStep {
	
	final Logger logger = LoggerFactory.getLogger(CreateRaffleStep.class);
	private HttpResponse statusCode;
	JSONObject actualJson;
	JSONObject jsonResponse;
	private static BufferedReader br;
	
	@Given("^a url for testing the raffle \"([^\"]*)\"$")
	public void a_url_for_testing_the_raffle(String createRaffleUrl) throws UnsupportedEncodingException {
		logger.info("http query = " + createRaffleUrl);
	}
	
	@When("^I make the rest call using raffle data$")
	public void I_make_the_rest_call_using_raffle_data(String actualJsonStr) throws IOException, JSONException {
		actualJson = new JSONObject(actualJsonStr);
		logger.info(actualJson.toString());
	}
	
	@Then("^status code for creating the raffle \"([^\"]*)\" should be (\\d+)$")
	public void status_code_for_creating_the_raffle_should_be(String createRaffleUrl, int expectedStatusCode) throws Throwable {
		statusCode = JsonReader.makeHttpPost(createRaffleUrl, actualJson);
		if (HttpStatus.SC_OK == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_OK);
			assertEquals(expectedStatusCode, HttpStatus.SC_OK);
		}
	}
	
	@Then("^response for creating the raffle should contain:$")
	public void response_for_creating_the_raffle_should_contain_JSON(String expected_json_str) throws JSONException, IOException {
		logger.info("Comparing reponse with" + expected_json_str);
		br = new BufferedReader(
	            new InputStreamReader((statusCode.getEntity().getContent())));
		String json_response;
		while ((json_response = br.readLine()) != null) {
			jsonResponse = new JSONObject(json_response.toString());
		}
		JSONObject expected_json = new JSONObject(expected_json_str);
		JSONAssert.assertEquals(expected_json, jsonResponse, JSONCompareMode.LENIENT);
	}
	
	@Then("^response for creating the raffle should contain \"(.+)\"")
	public void response_for_creating_the_raffle_should_contain(String expected_json_str) throws JSONException, IOException {
		response_for_creating_the_raffle_should_contain_JSON(expected_json_str);
	}
}
