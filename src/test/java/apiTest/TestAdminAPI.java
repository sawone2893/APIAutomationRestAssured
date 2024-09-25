package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import utililties.DataGenerator;
import io.github.shabryn2893.utils.JsonFileManager;

public class TestAdminAPI extends TestBase {
	
	@Test(enabled=true)
	public void validateUserSignup() {
		serviceObjectsManager.getCommonService().createAdmin(getPayLoadPath("users"));
	}

	@Test(enabled=false)
	public void validateUserLogin() {
		serviceObjectsManager.getCommonService().createAdmin(getPayLoadPath("users"));
		JsonFileManager.setJsonData(getPayLoadPath("login"), "email", JsonFileManager.getJsonData(getPayLoadPath("users"), "email"));
		JsonFileManager.setJsonData(getPayLoadPath("login"), "password", JsonFileManager.getJsonData(getPayLoadPath("users"), "password"));
		serviceObjectsManager.getAdminsService().loginAdmin(JsonFileManager.generateStringPayload(getPayLoadPath("login")));
		serviceObjectsManager.getAdminsService().printAdminsAPIResponse();
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
	}

	@Test(enabled=false)
	public void validateResetPassword() {
		serviceObjectsManager.getCommonService().createAdmin(getPayLoadPath("users"));
		JsonFileManager.setJsonData(getPayLoadPath("resetPassword"), "email", JsonFileManager.getJsonData(getPayLoadPath("users"), "email"));
		serviceObjectsManager.getAdminsService().resetPassword(JsonFileManager.generateStringPayload(getPayLoadPath("resetPassword")));
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().printAdminsAPIResponse();
	}

	@Test(enabled=false)
	public void validateRecoverPassword() {
		serviceObjectsManager.getCommonService().createAdmin(getPayLoadPath("users"));
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "token", serviceObjectsManager.getAdminsService().getAdminsToken());
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "password", password);
		JsonFileManager.setJsonData(getPayLoadPath("recoverPassword"), "confirm_password", password);
		serviceObjectsManager.getAdminsService().recoverPassword(JsonFileManager.generateStringPayload(getPayLoadPath("recoverPassword")));
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().printAdminsAPIResponse();
	}

}
