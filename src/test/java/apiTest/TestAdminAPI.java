package apiTest;

import org.testng.annotations.Test;

import api.services.CommonService;
import api.services.UsersService;
import base.TestBase;
import utililties.DataGenerator;
import utililties.JsonFileManager;

public class TestAdminAPI extends TestBase {

	@Test
	public void validateUserSignup() {
		CommonService.createUser();
	}

	@Test
	public void validateUserLogin() {
		CommonService.createUser();
		JsonFileManager.setJsonData("login", "email", JsonFileManager.getJsonData("users", "email"));
		JsonFileManager.setJsonData("login", "password", JsonFileManager.getJsonData("users", "password"));
		UsersService.loginUser(JsonFileManager.generateStringPayload("login"));
		UsersService.printAPIResponse();
		UsersService.validateUsersAPIStatusCode(200);
	}

	@Test
	public void validateResetPassword() {
		CommonService.createUser();
		JsonFileManager.setJsonData("resetPassword", "email", JsonFileManager.getJsonData("users", "email"));
		UsersService.resetPassword(JsonFileManager.generateStringPayload("resetPassword"));
		UsersService.validateUsersAPIStatusCode(200);
		UsersService.printAPIResponse();
	}

	@Test
	public void validateRecoverPassword() {
		CommonService.createUser();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		JsonFileManager.setJsonData("recoverPassword", "token", UsersService.getUsersToken());
		JsonFileManager.setJsonData("recoverPassword", "password", password);
		JsonFileManager.setJsonData("recoverPassword", "confirm_password", password);
		UsersService.recoverPassword(JsonFileManager.generateStringPayload("recoverPassword"));
		UsersService.validateUsersAPIStatusCode(200);
		UsersService.printAPIResponse();
	}

}
