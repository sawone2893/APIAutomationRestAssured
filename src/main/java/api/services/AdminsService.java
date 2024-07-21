package api.services;

import org.json.JSONObject;
import org.testng.Assert;

import api.endpoint.Routes;
import base.TestBase;
import utililties.JsonFileManager;

public class AdminsService extends TestBase {

	public static void signUpAdmin(String payload) {
		apiInstannce.postRequest(Routes.POST_SIGNUP_ADMIN, payload);
	}

	public static void loginAdmin(String payload) {
		apiInstannce.postRequest(Routes.POST_LOGIN_ADMIN, payload);
	}

	public static void resetPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_ADMIN_RESET_PASSWORD, payload);
	}

	public static void recoverPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_ADMIN_RECOVER_PASSWORD, payload);
	}

	public static void printAPIResponse() {
		apiInstannce.printResponse();
	}

	public static void validateAdminsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public static void validateAdminDetails(String payloadName) {
		JSONObject AdminRes = apiInstannce.parseResponseJsonObject();
		JSONObject info = (JSONObject) AdminRes.get("info");
		System.out.println("Expected Email: " + JsonFileManager.getJsonData(payloadName, "email"));
		System.out.println("Expected Password: " + JsonFileManager.getJsonData(payloadName, "password"));
		System.out.println("Expected Adminname: " + JsonFileManager.getJsonData(payloadName, "Adminname"));

		Assert.assertEquals(info.getString("email"), JsonFileManager.getJsonData(payloadName, "email"));
		Assert.assertEquals(info.getString("Adminname"), JsonFileManager.getJsonData(payloadName, "Adminname"));
	}

	public static String getAdminsToken() {
		return apiInstannce.parseResponseJsonObject().getString("token");
	}

}
