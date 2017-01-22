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

public class RegisterPlayerStep {
	
	final Logger logger = LoggerFactory.getLogger(RegisterPlayerStep.class);
	JSONObject actualJson;
	JSONObject jsonResponse;
	private HttpResponse statusCode;
	private static BufferedReader br;
	
	@Given("^a url for registering player \"([^\"]*)\"$")
	public void a_url_for_registering_player(String registerPlayerUrl) throws UnsupportedEncodingException {
		logger.info("http query = " + registerPlayerUrl);
	}
	
	@When("^I make the rest call using player data$")
	public void I_make_the_rest_call_using_player_data(String actualJsonStr) throws IOException, JSONException { 
		actualJson = new JSONObject(actualJsonStr);
		logger.info("Response = " + actualJson.toString());
	}

	@Then("^status code for the valid player data \"([^\"]*)\" should be (\\d+)$")
	public void status_code_for_the_valid_data_should_be(String registerPlayerUrl, int expectedStatusCode) throws IOException, JSONException {
		statusCode = JsonReader.makeHttpPost(registerPlayerUrl, actualJson);
		if (HttpStatus.SC_OK == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_OK);
			assertEquals(expectedStatusCode, HttpStatus.SC_OK);
		}
	}

	@Then("^response for the valid player data should contain:$")
	public void response_for_creating_the_valid_player_data_should_contain_JSON(String expectedJsonStr) throws JSONException, IOException {
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
	
	@Then("^response for the valid player data should contain \"(.+)\"")
	public void response_for_the_valid_player_data_should_contain(String expectedJsonStr) throws JSONException, IOException {
		response_for_creating_the_valid_player_data_should_contain_JSON(expectedJsonStr);
	}
	
	@When("^I make the rest call using invalid email id$")
	public void I_make_the_rest_call_using_invalid_email_id(String actualJsonStr) throws IOException, JSONException { 
		actualJson = new JSONObject(actualJsonStr);
		logger.info("Response = " + actualJson.toString());
	}

	@Then("^status code for the invalid player email id \"([^\"]*)\" should be (\\d+)$")
	public void status_code_for_the_invalid_player_email_id_should_be(String registerPlayerUrl, int expectedStatusCode) throws Throwable {
		statusCode = JsonReader.makeHttpPost(registerPlayerUrl, actualJson);
		if (HttpStatus.SC_BAD_REQUEST == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_BAD_REQUEST);
			assertEquals(expectedStatusCode, HttpStatus.SC_BAD_REQUEST);
		}
	}
	
	@Then("^response for the invalid player email id should contain:$")
	public void response_for_creating_the_invalid_player_email_id_should_contain_JSON(String expectedJsonStr) throws JSONException, IOException {
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
	
	@Then("^response for the invalid player email id should contain \"(.+)\"")
	public void response_for_the_invalid_player_email_id_should_contain(String expectedJsonStr) throws JSONException, IOException {
		response_for_creating_the_valid_player_data_should_contain_JSON(expectedJsonStr);
	}
	
	@When("^I make the rest call using invalid dob$")
	public void I_make_the_rest_call_using_invalid_dob(String actualJsonStr) throws IOException, JSONException { 
		actualJson = new JSONObject(actualJsonStr);
		logger.info("Response = " + actualJson.toString());
	}
	
	@Then("^status code for the invalid player dob \"([^\"]*)\" should be (\\d+)$")
	public void status_code_for_the_invalid_player_dob_should_be(String registerPlayerUrl, int expectedStatusCode) throws Throwable {
		statusCode = JsonReader.makeHttpPost(registerPlayerUrl, actualJson);
		if (HttpStatus.SC_BAD_REQUEST == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_BAD_REQUEST);
			assertEquals(expectedStatusCode, HttpStatus.SC_BAD_REQUEST);
		}
	}

	@Then("^response for the invalid player dob should contain:$")
	public void response_for_creating_the_invalid_player_dob_should_contain_JSON(String expectedJsonStr) throws JSONException, IOException {
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
	
	@Then("^response for the invalid player dob should contain \"(.+)\"")
	public void response_for_the_invalid_player_dob_should_contain(String expectedJsonStr) throws JSONException, IOException {
		response_for_creating_the_valid_player_data_should_contain_JSON(expectedJsonStr);
	}

}
