package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ApiTest {
	
	@Test
	public void getValidData() throws JSONException {

		RestAssured.baseURI = "https://api.bcqa.bc2.customers.biocatch.com/api/v6/score";	
		RequestSpecification httpRequest = RestAssured.given();	
	
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("customerId", "bcqa"); // Cast
		requestParams.put("action", "getScore");		 
		requestParams.put("uuid", "bioTest1");
		requestParams.put("customerSessionID", "rgrsemgfloxgsm0jdxhgu797jjnochpg");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toString());
		
		httpRequest.post();
		Response response = httpRequest.request(Method.POST);
			
		String responseBody = response.getBody().asString();
		JSONObject jsonResult = new JSONObject(responseBody);
			
		System.out.println("Response Body is =>  " + jsonResult.getString("bcStatus"));
		
		Assert.assertEquals("tested", jsonResult.getString("bcStatus"));
	}
	
	@Test
	public void getInvalidData() throws JSONException {

		RestAssured.baseURI = "https://api.bcqa.bc2.customers.biocatch.com/api/v6/score";	
		RequestSpecification httpRequest = RestAssured.given();	
	
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("customerId", "bcqa"); // Cast
		requestParams.put("action", "getScore");		 
		requestParams.put("uuid", "bioTest1");
		requestParams.put("customerSessionID", "rgrsemgfloxgsm0jdxhgu797jjnochp");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toString());
		
		httpRequest.post();
		Response response = httpRequest.request(Method.POST);
			
		String responseBody = response.getBody().asString();
		JSONObject jsonResult = new JSONObject(responseBody);
			
		System.out.println("Response Body is =>  " + jsonResult.getString("bcStatus"));
		
		Assert.assertEquals("client_data_not_collected", jsonResult.getString("bcStatus"));
	}
	
	
	@Test
	public void getValidAndInvalidData() throws JSONException {

		RestAssured.baseURI = "https://api.bcqa.bc2.customers.biocatch.com/api/v6/score";	
		RequestSpecification httpRequest = RestAssured.given();	
	
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("customerId", "bcqa"); // Cast
		requestParams.put("action", "getScore");		 
		requestParams.put("uuid", "bioTest1");
		requestParams.put("customerSessionID", "rgrsemgfloxgsm0jdxhgu797jjnochpg");
		requestParams.put("score", "900");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toString());
		
		httpRequest.post();
		Response response = httpRequest.request(Method.POST);
			
		String responseBody = response.getBody().asString();
		JSONObject jsonResult = new JSONObject(responseBody);
			
		System.out.println("Response Body is =>  " + responseBody);
		
		Assert.assertEquals("tested", jsonResult.getString("bcStatus"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
