package com.savingspare.pages;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class APITestingStepDefs {
	
	private JSONObject jSONResponse;
	
	private JSONObject getjSONResponse() {
		return jSONResponse;
	}

	private void setjSONResponse(JSONObject jObj) {

		jSONResponse = jObj;
		 System.out.println(jSONResponse);
	}
	
	@Given("^user connects to the \"([^\"]*)\" API$")
	public void user_connects_to_the_API(String apiType) throws Throwable {
		String finalURL=null;
		
		
		if(apiType.equals("createGoal"))
		{
			finalURL = "http://localhost:9080/web";
		} else if(apiType.equals("getPaymentcategories"))
		{
			finalURL = "http://dbshack.appspot.com/payment_categories/";
		}else if(apiType.equals("getGoals"))
		{
			System.out.println("inside goals url");
			finalURL = "http://dbshack.appspot.com/goals/";
			
		}
		
		
		
		URL url = new URL(finalURL);
		WebConversation wc1 = new WebConversation();
		WebRequest getRequest1 = new GetMethodWebRequest(finalURL);
		getRequest1.setHeaderField("Accept", "application/json");
		WebResponse getResponse1 = wc1.getResource(getRequest1);
		String JSONResponseforICN = getResponse1.getText();
		System.out.println("JSONResponseforICN"+JSONResponseforICN);
		//JSONParser parser = new JSONParser();
		//JSONObject json = (JSONObject) parser.parse(stringToParse);
		
		JSONObject jObj = new JSONObject("{\"response\":"+JSONResponseforICN+"}");
		setjSONResponse(jObj);
		System.out.println("test");
		System.out.println(jObj);
	    
	}

	@Then("^the server should handle it and return a success status$")
	public void the_server_should_handle_it_and_return_a_success_status() throws Throwable {
	    
	}
	@Then("^response should contain all the following values$")
	public void response_should_contain_all_the_following_values(DataTable dataTable) throws Throwable {
		
		//JSONObject jSONObj = getjSONResponse();
		
		
		System.out.println(APITestingStepDefs.getDataTableValue(dataTable, "Date"));
		/*Assert.assertTrue(jSONObj.getString("AgencyCode")
				.equalsIgnoreCase(APITestingStepDefs.getDataTableValue(dataTable, "AGENCYID")));*/
			
	}
	   
	public static String getDataTableValue(DataTable dataTable, String key) {
		return (String) dataTable.asMap(String.class, String.class).get(key);
	}
	
	@Then("^response \"([^\"]*)\" should contain all the following values$")
	public void response_should_contain_all_the_following_values(String apicategoryType, DataTable dataTable) throws Throwable {
		JSONObject jSONObj = getjSONResponse();
		System.out.println("apicategoryType"+apicategoryType);
		/*if(apicategoryType.contains("getPaymentcategories"))
		{*/
			System.out.println("inside jason array");
			JSONArray paymentcategories = jSONObj.getJSONArray("response");
			System.out.println("paymentcategories"+paymentcategories);
			// System.out.println("Quotes"+Quote);
			JSONObject firstFirstpaymentObject = (JSONObject) paymentcategories.get(0);
			System.out.println("first"+firstFirstpaymentObject);
			System.out.println("name :"+firstFirstpaymentObject.getString("name"));
			Assert.assertTrue(firstFirstpaymentObject.getString("name")
					.equalsIgnoreCase(APITestingStepDefs.getDataTableValue(dataTable, "categoryType")));
			
		//}
	}
	
	@Then("^response getGoals should contain all the following values$")
	public void response_getGoals_should_contain_all_the_following_values(DataTable dataTable) throws Throwable {
	   
		JSONObject jSONObj = getjSONResponse();
		
			System.out.println("inside jason array");
			JSONArray paymentcategories = jSONObj.getJSONArray("response");
			System.out.println("paymentcategories"+paymentcategories);
			// System.out.println("Quotes"+Quote);
			JSONObject firstFirstpaymentObject = (JSONObject) paymentcategories.get(0);
			System.out.println("first"+firstFirstpaymentObject);
			System.out.println("name :"+firstFirstpaymentObject.getString("goalName"));
			Assert.assertTrue(firstFirstpaymentObject.getString("goalName")
					.equalsIgnoreCase(APITestingStepDefs.getDataTableValue(dataTable, "Name")));
			Assert.assertTrue(firstFirstpaymentObject.getString("goalDate")
					.equalsIgnoreCase(APITestingStepDefs.getDataTableValue(dataTable, "Date")));
			Assert.assertTrue(firstFirstpaymentObject.getString("priority")
					.equalsIgnoreCase(APITestingStepDefs.getDataTableValue(dataTable, "Priority")));
			
			
		//}
		
		
	}
	
	@Given("^user post data to \"([^\"]*)\" api$")
	public void user_post_data_to_api(String arg1) throws Throwable {
		/*final String POST_PARAMS = "{\n"+
				"\"goal\":{\n" + "\"goalName\":\"Random\",\r\n" +
        "    \"goalDate\": \"01/03/2019\",\r\n" +
        "    \"priority\": \"Low\",\r\n" +
        "    \"amount\": 1223 \n
}
}";
*/		    //System.out.println(POST_PARAMS);
		    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("POST");
		    postConnection.setRequestProperty("userId", "a1bcdefgh");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setDoOutput(true);
		  //  OutputStream os = postConnection.getOutputStream();
		  /*  os.write(POST_PARAMS.getBytes());
		    os.flush();
		    os.close();*/
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());

	}
		
	
	

}
