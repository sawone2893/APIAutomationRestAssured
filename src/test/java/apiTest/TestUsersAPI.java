package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import utililties.DataGenerator;
import utililties.JsonFileManager;

public class TestUsersAPI extends TestBase {

	@Test
	public void validateUserSignup() {
		serviceObjectsManager.getCommonService().createUser();
	}

	@Test
	public void validateUserLogin() {
		serviceObjectsManager.getCommonService().createUser();
		JsonFileManager.setJsonData("login", "email", JsonFileManager.getJsonData("users", "email"));
		JsonFileManager.setJsonData("login", "password", JsonFileManager.getJsonData("users", "password"));
		serviceObjectsManager.getUsersService().loginUser(JsonFileManager.generateStringPayload("login"));
		serviceObjectsManager.getUsersService().printAPIResponse();
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
	}

	@Test
	public void validateResetPassword() {
		serviceObjectsManager.getCommonService().createUser();
		JsonFileManager.setJsonData("resetPassword", "email", JsonFileManager.getJsonData("users", "email"));
		serviceObjectsManager.getUsersService().resetPassword(JsonFileManager.generateStringPayload("resetPassword"));
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().printAPIResponse();
	}

	@Test
	public void validateRecoverPassword() {
		serviceObjectsManager.getCommonService().createUser();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		JsonFileManager.setJsonData("recoverPassword", "token", serviceObjectsManager.getUsersService().getUsersToken());
		JsonFileManager.setJsonData("recoverPassword", "password", password);
		JsonFileManager.setJsonData("recoverPassword", "confirm_password", password);
		serviceObjectsManager.getUsersService().recoverPassword(JsonFileManager.generateStringPayload("recoverPassword"));
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().printAPIResponse();
	}

}
