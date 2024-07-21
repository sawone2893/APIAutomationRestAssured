package api.services;

import utililties.DataGenerator;
import utililties.JsonFileManager;

public class CommonService {

	public static void createAdmin() {
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData("users", "email", email);
		JsonFileManager.setJsonData("users", "password", password);
		JsonFileManager.setJsonData("users", "username", username);
		AdminsService.signUpAdmin(JsonFileManager.generateStringPayload("users"));
		UsersService.printAPIResponse();
		UsersService.validateUsersAPIStatusCode(200);
		UsersService.validateUserDetails("users");
	}

	public static void createUser() {
		String email = DataGenerator.generateData().internet().emailAddress();
		String password = DataGenerator.generateData().internet().password(8, 15, true, true);
		String username = DataGenerator.generateData().name().username();
		JsonFileManager.setJsonData("users", "email", email);
		JsonFileManager.setJsonData("users", "password", password);
		JsonFileManager.setJsonData("users", "username", username);
		UsersService.signUpUser(JsonFileManager.generateStringPayload("users"));
		UsersService.printAPIResponse();
		UsersService.validateUsersAPIStatusCode(200);
		UsersService.validateUserDetails("users");
	}

	public static void createBrand() {
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);
		BrandsService.createBrand(JsonFileManager.generateStringPayload("brands"));
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.validateBrandDetails("brands");
	}
}
