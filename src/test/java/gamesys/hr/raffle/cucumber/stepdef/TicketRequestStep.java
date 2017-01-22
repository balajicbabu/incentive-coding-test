package gamesys.hr.raffle.cucumber.stepdef;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.*;

public class TicketRequestStep {

	final Logger logger = LoggerFactory.getLogger(PlayerRequestStep.class);
	JSONObject actualJson;
	JSONObject jsonResponse;
	private HttpResponse statusCode;
	private static BufferedReader br;
	
	@Given("^a url for requesting ticket using player id and raffle id \"([^\"]*)\"$")
	public void a_url_for_requesting_ticket_using_player_id_and_raffle_id(String requestTicketUrl) throws UnsupportedEncodingException {
		logger.info("http query = " + requestTicketUrl);
	}
	
	@When("^I make the rest call using player id and raffle id$")
	public void I_make_the_rest_call_using_player_id_and_raffle_id(String actualJsonStr) throws IOException, JSONException {
		actualJson = new JSONObject(actualJsonStr);
		logger.info("Response = " + actualJson.toString());
	}
	
	@Then("^status code for the player and raffle id \"([^\"]*)\" should be (\\d+)$")
	public void status_code_for_the_player_and_raffle_id_should_be(String requestTicketUrl,  int expectedStatusCode) throws IOException, JSONException {
		statusCode = JsonReader.makeHttpPost(requestTicketUrl, actualJson);
		if (HttpStatus.SC_OK == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_OK);
			assertEquals(expectedStatusCode, HttpStatus.SC_OK);
		}
	}
	
	@Then("^response for the player and raffle id should contain:$")
	public void response_for_creating_the_player_and_raffle_id_should_contain_JSON(String expectedJsonStr) throws JSONException, IOException {
		logger.info("Comparing reponse with" + expectedJsonStr);
		br = new BufferedReader(
	            new InputStreamReader((statusCode.getEntity().getContent())));
		String jsonResponseStr;
		while ((jsonResponseStr = br.readLine()) != null) {
			jsonResponse = new JSONObject(jsonResponseStr.toString());
		}
		JSONObject expectedJson = new JSONObject(expectedJsonStr);
		JSONAssert.assertEquals(expectedJson, jsonResponse, JSONCompareMode.LENIENT);
	}
	
	@Then("^response for the player and raffle id should contain \"(.+)\"")
	public void response_for_the_player_and_raffle_id_should_contain(String expected_json_str) throws JSONException, IOException {
		response_for_creating_the_player_and_raffle_id_should_contain_JSON(expected_json_str);
	}
}
