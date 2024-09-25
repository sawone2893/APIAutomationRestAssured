package services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;
import io.github.shabryn2893.utils.JsonFileManager;

public class AdminsService{

	private static final Logger logger = Logger.getLogger(AdminsService.class.getName());
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
		BaseClass.doPostRequest(Routes.POST_SIGNUP_ADMIN, payload);
	}

	public  void loginAdmin(String payload) {
		BaseClass.doPostRequest(Routes.POST_LOGIN_ADMIN, payload);
	}

	public  void resetPassword(String payload) {
		BaseClass.doPostRequest(Routes.POST_ADMIN_RESET_PASSWORD, payload);
	}

	public  void recoverPassword(String payload) {
		BaseClass.doPostRequest(Routes.POST_ADMIN_RECOVER_PASSWORD, payload);
	}

	public  void printAdminsAPIResponse() {
		BaseClass.doPrintAPIResponse();
	}

	public  void validateAdminsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(BaseClass.doGetAPIStatusCode(), expectedStatusCode);
	}

	public  void validateAdminDetails(String payloadName) {
		JSONObject adminRes = BaseClass.doParseResponseJsonObject();
		JSONObject infoData = (JSONObject) adminRes.get("info");
		
		String eMail=JsonFileManager.getJsonData(payloadName, "email");
		String paswd=JsonFileManager.getJsonData(payloadName, "password");
		String adminName= JsonFileManager.getJsonData(payloadName, "Adminname");
		
		logger.log(Level.INFO,"Expected Email: {0}",eMail);
		logger.log(Level.INFO,"Expected Password: {0}", paswd);
		logger.log(Level.INFO,"Expected Adminname: {0}",adminName);

		Assert.assertEquals(infoData.getString("email"), eMail);
		Assert.assertEquals(infoData.getString("Adminname"), adminName);
	}

	public  String getAdminsToken() {
		return BaseClass.doParseResponseJsonObject().getString("token");
	}

}
