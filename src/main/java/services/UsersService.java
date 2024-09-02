package services;

import org.json.JSONObject;
import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;
import utililties.JsonFileManager;

public class UsersService extends BaseClass {

	private static UsersService usersService = null;

	private UsersService() {

	}

	public static UsersService getInstance() {
		if (usersService == null) {
			usersService = new UsersService();
		}

		return usersService;
	}

	public void signUpUser(String payload) {
		apiInstannce.postRequest(Routes.POST_SIGNUP_USER, payload);
	}

	public void loginUser(String payload) {
		apiInstannce.postRequest(Routes.POST_LOGIN_USER, payload);
	}

	public void resetPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_USER_RESET_PASSWORD, payload);
	}

	public void recoverPassword(String payload) {
		apiInstannce.postRequest(Routes.POST_USER_RECOVER_PASSWORD, payload);
	}

	public void printAPIResponse() {
		apiInstannce.printResponse();
	}

	public void validateUsersAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public void validateUserDetails(String payloadName) {
		JSONObject userRes = apiInstannce.parseResponseJsonObject();
		JSONObject info = (JSONObject) userRes.get("info");
		System.out.println("Expected Email: " + JsonFileManager.getJsonData(payloadName, "email"));
		System.out.println("Expected Password: " + JsonFileManager.getJsonData(payloadName, "password"));
		System.out.println("Expected Username: " + JsonFileManager.getJsonData(payloadName, "username"));

		Assert.assertEquals(info.getString("email"), JsonFileManager.getJsonData(payloadName, "email"));
		Assert.assertEquals(info.getString("username"), JsonFileManager.getJsonData(payloadName, "username"));
	}

	public String getUsersToken() {
		return apiInstannce.parseResponseJsonObject().getString("token");
	}

}
