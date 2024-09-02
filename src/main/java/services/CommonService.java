package services;

import serviceObjects.ServiceObjectsManager;
import utililties.DataGenerator;
import utililties.JsonFileManager;

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

	public  void createAdmin() {
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData("users", "email", email);
		JsonFileManager.setJsonData("users", "password", password);
		JsonFileManager.setJsonData("users", "username", username);
		serviceObjectsManager.getAdminsService().signUpAdmin(JsonFileManager.generateStringPayload("users"));
		serviceObjectsManager.getAdminsService().printAPIResponse();
		serviceObjectsManager.getAdminsService().validateAdminsAPIStatusCode(200);
		serviceObjectsManager.getAdminsService().validateAdminDetails("users");
	}

	public  void createUser() {
		
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData("users", "email", email);
		JsonFileManager.setJsonData("users", "password", password);
		JsonFileManager.setJsonData("users", "username", username);
		serviceObjectsManager.getUsersService().signUpUser(JsonFileManager.generateStringPayload("users"));
		serviceObjectsManager.getUsersService().printAPIResponse();
		serviceObjectsManager.getUsersService().validateUsersAPIStatusCode(200);
		serviceObjectsManager.getUsersService().validateUserDetails("users");
	}

	public  void createBrand() {
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);
		serviceObjectsManager.getBrandsService().createBrand(JsonFileManager.generateStringPayload("brands"));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails("brands");
	}
}
