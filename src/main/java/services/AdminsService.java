package services;

import org.json.JSONObject;
import org.testng.Assert;

import base.BaseClass;
import base.TestBase;
import endpoint.Routes;
import utililties.JsonFileManager;

public class AdminsService extends BaseClass {

	private static AdminsService adminsService=null;
	
	private AdminsService() {
		
	}
	
	public static AdminsService getInstance() {
		if(adminsService==null) {
			adminsService= new AdminsService();
		}
		
		return adminsService;
	}
	
	public  void signUpAdmin(String payload) {
		apiInstannce.postRequest(Routes.POST_SIGNUP_ADMIN, payload);
	}

	public  void loginAdmin(String payload) {
		apiInstannce.postRequest(Routes.POST_LOGIN_ADMIN, payload);
	}

	public  void resetPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_ADMIN_RESET_PASSWORD, payload);
	}

	public  void recoverPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_ADMIN_RECOVER_PASSWORD, payload);
	}

	public  void printAPIResponse() {
		apiInstannce.printResponse();
	}

	public  void validateAdminsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public  void validateAdminDetails(String payloadName) {
		JSONObject AdminRes = apiInstannce.parseResponseJsonObject();
		JSONObject info = (JSONObject) AdminRes.get("info");
		System.out.println("Expected Email: " + JsonFileManager.getJsonData(payloadName, "email"));
		System.out.println("Expected Password: " + JsonFileManager.getJsonData(payloadName, "password"));
		System.out.println("Expected Adminname: " + JsonFileManager.getJsonData(payloadName, "Adminname"));

		Assert.assertEquals(info.getString("email"), JsonFileManager.getJsonData(payloadName, "email"));
		Assert.assertEquals(info.getString("Adminname"), JsonFileManager.getJsonData(payloadName, "Adminname"));
	}

	public  String getAdminsToken() {
		return apiInstannce.parseResponseJsonObject().getString("token");
	}

}
