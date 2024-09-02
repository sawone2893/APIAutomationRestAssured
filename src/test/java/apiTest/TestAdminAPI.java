package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import serviceObjects.ServiceObjectsManager;
import services.CommonService;
import services.UsersService;
import utililties.DataGenerator;
import utililties.JsonFileManager;

public class TestAdminAPI extends TestBase {
	
	@Test
	public void validateUserSignup() {
		serviceObjectsManager.getCommonService().createAdmin();
	}

	@Test
	public void validateUserLogin() {
		serviceObjectsManager.getCommonService().createAdmin();
		JsonFileManager.setJsonData("login", "email", JsonFileManager.getJsonData("users", "email"));
		JsonFileManager.setJsonData("login", "password", JsonFileManager.getJsonData("users", "password"));
		serviceObjectsManager.getAdminsService().loginAdmin(JsonFileManager.generateStringPayload("login"));
		serviceObjectsManager.getAdminsService().printAPIResponse();
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
	}

	@Test
	public void validateResetPassword() {
		serviceObjectsManager.getCommonService().createAdmin();
		JsonFileManager.setJsonData("resetPassword", "email", JsonFileManager.getJsonData("users", "email"));
		serviceObjectsManager.getAdminsService().resetPassword(JsonFileManager.generateStringPayload("resetPassword"));
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().printAPIResponse();
	}

	@Test
	public void validateRecoverPassword() {
		serviceObjectsManager.getCommonService().createAdmin();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		JsonFileManager.setJsonData("recoverPassword", "token", serviceObjectsManager.getAdminsService().getAdminsToken());
		JsonFileManager.setJsonData("recoverPassword", "password", password);
		JsonFileManager.setJsonData("recoverPassword", "confirm_password", password);
		serviceObjectsManager.getAdminsService().recoverPassword(JsonFileManager.generateStringPayload("recoverPassword"));
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().printAPIResponse();
	}

}
