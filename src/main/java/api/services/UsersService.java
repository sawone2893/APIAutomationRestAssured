package api.services;

import org.json.JSONObject;
import org.testng.Assert;

import api.endpoint.Routes;
import base.TestBase;
import utililties.JsonFileManager;

public class UsersService extends TestBase {

	public static void signUpUser(String payload) {
		apiInstannce.postRequest(Routes.POST_SIGNUP_USER, payload);
	}

	public static void loginUser(String payload) {
		apiInstannce.postRequest(Routes.POST_LOGIN_USER, payload);
	}

	public static void resetPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_USER_RESET_PASSWORD, payload);
	}

	public static void recoverPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_USER_RECOVER_PASSWORD, payload);
	}

	public static void printAPIResponse() {
		apiInstannce.printResponse();
	}

	public static void validateUsersAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public static void validateUserDetails(String payloadName) {
		JSONObject userRes = apiInstannce.parseResponseJsonObject();
		JSONObject info = (JSONObject) userRes.get("info");
		System.out.println("Expected Email: " + JsonFileManager.getJsonData(payloadName, "email"));
		System.out.println("Expected Password: " + JsonFileManager.getJsonData(payloadName, "password"));
		System.out.println("Expected Username: " + JsonFileManager.getJsonData(payloadName, "username"));

		Assert.assertEquals(info.getString("email"), JsonFileManager.getJsonData(payloadName, "email"));
		Assert.assertEquals(info.getString("username"), JsonFileManager.getJsonData(payloadName, "username"));
	}

	public static String getUsersToken() {
		return apiInstannce.parseResponseJsonObject().getString("token");
	}

}
