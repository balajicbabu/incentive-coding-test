package gamesys.hr.raffle.cucumber.stepdef;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumber.api.java.en.*;

public class PlayerRequestStep {

	final Logger logger = LoggerFactory.getLogger(PlayerRequestStep.class);
	private String playerRequestUrl;
	private HttpResponse statusCode;
	
	@Given("^a url for requesting player info \"([^\"]*)\"$")
	public void a_url_for_requesting_player_info(String playerRequestUrl) throws UnsupportedEncodingException {
		logger.info("http query = " + playerRequestUrl);
	}
	
	@When("^I make the rest call using valid player id \"([^\"]*)\"$")
	public void I_make_the_rest_call_using_valid_player_id(String id) throws IOException { 
		playerRequestUrl = "http://localhost:8080/players/"+id;
		logger.info("http query = " + playerRequestUrl);
	}
	
	@Then("^status code for requesting the player detail using valid id should be (\\d+)$")
	public void status_code_for_requesting_the_player_detail_using_valid_id_should_be(int expectedStatusCode) throws Throwable {
		statusCode = JsonReader.makeHttpGet(playerRequestUrl);
		if (HttpStatus.SC_OK == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_OK);
			assertEquals(expectedStatusCode, HttpStatus.SC_OK);
		}
	}
	
	@When("^I make the rest call using invalid player id \"([^\"]*)\"$")
	public void I_make_the_rest_call_using_invalid_player_id(String invalidId) throws IOException {
		playerRequestUrl = "http://localhost:8080/players/"+invalidId;
		logger.info("http query = " + playerRequestUrl);
	}
	
	@Then("^status code for requesting the player detail using invalid id should be (\\d+)$")
	public void status_code_for_requesting_the_player_detail_using_invalid_id_should_be(int expectedStatusCode) throws Throwable {
		statusCode = JsonReader.makeHttpGet(playerRequestUrl);
		if (HttpStatus.SC_BAD_REQUEST == statusCode.getStatusLine().getStatusCode()){
			logger.info("Expected Response Code" + HttpStatus.SC_BAD_REQUEST);
			assertEquals(expectedStatusCode, HttpStatus.SC_BAD_REQUEST);
		}
	}
}
