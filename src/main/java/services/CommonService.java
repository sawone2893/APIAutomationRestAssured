package services;

import serviceObjects.ServiceObjectsManager;
import utililties.DataGenerator;
import config.ConfigProp;
import io.github.shabryn2893.utils.JsonFileManager;

public class CommonService {
	
private static CommonService commonService=null;

ServiceObjectsManager serviceObjectsManager=new ServiceObjectsManager();
	
	private CommonService() {
		
	}
	
	public static CommonService getInstance() {
		if(commonService==null) {
			commonService= new CommonService();
		}
		
		return commonService;
	}

	public  void createAdmin(String payLoadPath) {
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData(payLoadPath, "email", email);
		JsonFileManager.setJsonData(payLoadPath, "password", password);
		JsonFileManager.setJsonData(payLoadPath, "username", username);
		serviceObjectsManager.getAdminsService().signUpAdmin(JsonFileManager.generateStringPayload(payLoadPath));
		serviceObjectsManager.getAdminsService().printAdminsAPIResponse();
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().validateAdminDetails(payLoadPath);
	}

	public  void createUser(String payLoadPath) {
		
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData(payLoadPath, "email", email);
		JsonFileManager.setJsonData(payLoadPath, "password", password);
		JsonFileManager.setJsonData(payLoadPath, "username", username);
		serviceObjectsManager.getUsersService().signUpUser(JsonFileManager.generateStringPayload(payLoadPath));
		serviceObjectsManager.getUsersService().printUsersAPIResponse();
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().validateUserDetails(payLoadPath);
	}

	public  void createBrand(String payLoadPath) {
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData(payLoadPath, "name", name);
		JsonFileManager.setJsonData(payLoadPath, "description", description);
		serviceObjectsManager.getBrandsService().createBrand(JsonFileManager.generateStringPayload(payLoadPath));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails(payLoadPath);
	}
	
	public String getBearerToken() {
		serviceObjectsManager.getUsersService().loginUser(JsonFileManager.generateStringPayload(ConfigProp.PAYLOAD_FILE_PATH+"login.json"));
		return serviceObjectsManager.getUsersService().getUsersToken();
	}
	public void createCategories(String payLoadPath) {
		String name = DataGenerator.generateData().commerce().productName();
		JsonFileManager.setJsonData(payLoadPath, "name", name);
		
		serviceObjectsManager.getCategoriesService().createCategories(JsonFileManager.generateStringPayload(payLoadPath),getBearerToken());
	}
}
