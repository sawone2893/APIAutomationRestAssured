package base;

import org.json.JSONArray;
import org.json.JSONObject;

import io.github.shabryn2893.apicore.APIToolFactory;
import io.github.shabryn2893.apicore.IActionAPI;
import io.restassured.response.Response;

public  class BaseClass {

	private static IActionAPI apiInstannce;
	
	private BaseClass() {}
	public static void init(String toolName,String baseURI) {
		apiInstannce = APIToolFactory.getAPIToolInstance(toolName,baseURI);
	}
	
	public static void setAuthHeader(String bToken) {
		apiInstannce.setHeader("Authorization","Bearer "+bToken);
	}
	
	public static Response doGetRequest(String resourceName) {
		return apiInstannce.getRequest(resourceName);
	}
	
	public static Response doGetRequest(String resourceName,String bToken) {
		setAuthHeader(bToken);
		return apiInstannce.getRequest(resourceName);
	}
	
	public static Response doPostRequest(String resourceName,String payLoad) {
		return apiInstannce.postRequest(resourceName,payLoad);
	}
	
	public static Response doPostRequest(String resourceName,String payLoad,String bToken) {
		setAuthHeader(bToken);
		return apiInstannce.postRequest(resourceName,payLoad);
	}
	
	public static Response doPutRequest(String resourceName,String payLoad) {
		return apiInstannce.postRequest(resourceName,payLoad);
	}
	
	public static Response doPutRequest(String resourceName,String payLoad,String bToken) {
		setAuthHeader(bToken);
		return apiInstannce.putRequest(resourceName,payLoad);
	}
	
	public static Response doDeleteRequest(String resourceName) {
		return apiInstannce.deleteRequest(resourceName);
	}
	
	public static Response doDeleteRequest(String resourceName,String bToken) {
		setAuthHeader(bToken);
		return apiInstannce.deleteRequest(resourceName);
	}
	
	public static void doPrintAPIResponse() {
		apiInstannce.printResponse();
	}
	
	public static int doGetAPIStatusCode() {
		return apiInstannce.getStatusCode();
	}
	
	public static JSONObject doParseResponseJsonObject() {
		return apiInstannce.parseResponseJsonObject();
	}
	
	public static JSONArray doParsResponseJsonArray() {
		return apiInstannce.parsResponseJsonArray();
	}
	
}
