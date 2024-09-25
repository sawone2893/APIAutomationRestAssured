package services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;
import io.github.shabryn2893.utils.JsonFileManager;

public class UsersService{

	private static final Logger logger = Logger.getLogger(UsersService.class.getName());
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
		BaseClass.doPostRequest(Routes.POST_SIGNUP_USER, payload);
	}

	public void loginUser(String payload) {
		BaseClass.doPostRequest(Routes.POST_LOGIN_USER, payload);
	}

	public void resetPassword(String payload) {
		BaseClass.doPostRequest(Routes.POST_USER_RESET_PASSWORD, payload);
	}

	public void recoverPassword(String payload) {
		BaseClass.doPostRequest(Routes.POST_USER_RECOVER_PASSWORD, payload);
	}

	public void printUsersAPIResponse() {
		BaseClass.doPrintAPIResponse();
	}

	public void validateUsersAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(BaseClass.doGetAPIStatusCode(), expectedStatusCode);
	}

	public void validateUserDetails(String payloadName) {
		JSONObject userRes = BaseClass.doParseResponseJsonObject();
		JSONObject infoData = (JSONObject) userRes.get("info");
		
		String eMail=JsonFileManager.getJsonData(payloadName, "email");
		String paswd=JsonFileManager.getJsonData(payloadName, "password");
		String userName= JsonFileManager.getJsonData(payloadName, "username");
		
		logger.log(Level.INFO,"Expected Email: {0}",eMail);
		logger.log(Level.INFO,"Expected Password: {0}", paswd);
		logger.log(Level.INFO,"Expected Adminname: {0}",userName);


		Assert.assertEquals(infoData.getString("email"), eMail);
		Assert.assertEquals(infoData.getString("username"), userName);
	}

	public String getUsersToken() {
		return BaseClass.doParseResponseJsonObject().getString("token");
	}

}
