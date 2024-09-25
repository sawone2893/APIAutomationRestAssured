package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import utililties.DataGenerator;
import io.github.shabryn2893.utils.JsonFileManager;

public class TestUsersAPI extends TestBase {

	@Test
	public void validateUserSignup() {
		serviceObjectsManager.getCommonService().createUser(getPayLoadPath("users"));
	}

	@Test
	public void validateUserLogin() {
		serviceObjectsManager.getCommonService().createUser(getPayLoadPath("users"));
		JsonFileManager.setJsonData(getPayLoadPath("login"), "email", JsonFileManager.getJsonData(getPayLoadPath("users"), "email"));
		JsonFileManager.setJsonData(getPayLoadPath("login"), "password", JsonFileManager.getJsonData(getPayLoadPath("users"), "password"));
		serviceObjectsManager.getUsersService().loginUser(JsonFileManager.generateStringPayload(getPayLoadPath("login")));
		serviceObjectsManager.getUsersService().printUsersAPIResponse();
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
	}

	@Test
	public void validateResetPassword() {
		serviceObjectsManager.getCommonService().createUser(getPayLoadPath("users"));
		JsonFileManager.setJsonData(getPayLoadPath("resetPassword"), "email", JsonFileManager.getJsonData(getPayLoadPath("users"), "email"));
		serviceObjectsManager.getUsersService().resetPassword(JsonFileManager.generateStringPayload(getPayLoadPath("resetPassword")));
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().printUsersAPIResponse();
	}

	@Test
	public void validateRecoverPassword() {
		serviceObjectsManager.getCommonService().createUser(getPayLoadPath("users"));
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "token", serviceObjectsManager.getUsersService().getUsersToken());
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "password", password);
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "confirm_password", password);
		serviceObjectsManager.getUsersService().recoverPassword(JsonFileManager.generateStringPayload(getPayLoadPath("recoverPassword")));
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().printUsersAPIResponse();
	}

}
