package gamesys.hr.raffle.cucumber.stepdef;

import java.io.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class JsonReader {
	
	private static HttpResponse response;
	static HttpClient httpclient;
	
	public static HttpResponse makeHttpPost(String requestUrl, JSONObject jsonInputData) throws IOException, JSONException{
		httpclient = new DefaultHttpClient();
		System.out.println(requestUrl);
		HttpPost httppost = new HttpPost(requestUrl);
		StringEntity se = new StringEntity(jsonInputData.toString());
		httppost.setHeader("Content-type", "application/json");
		httppost.setEntity(se);
		response = httpclient.execute(httppost);
		response.getStatusLine().getStatusCode();
		System.out.println("The response Code is: " + response.toString());
		return response;
	}
	
	public static HttpResponse makeHttpGet(String requestUrl) throws IOException, JSONException{
		httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(requestUrl);
		httpGet.addHeader("accept", "application/json");
		response = httpclient.execute(httpGet);
		response.getStatusLine().getStatusCode();
		return response;
	}
	}
