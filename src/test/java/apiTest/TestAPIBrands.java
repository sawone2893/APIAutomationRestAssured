package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import utililties.DataGenerator;
import utililties.JsonFileManager;

public class TestAPIBrands extends TestBase {

	@Test
	public void validateGetAllBrands() {
		serviceObjectsManager.getBrandsService().getAllBrands();
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
	}

	@Test
	public void validateCreateBrands() {
		serviceObjectsManager.getCommonService().createBrand();
	}

	@Test
	public void validateUpdateBrands() {
		serviceObjectsManager.getCommonService().createBrand();
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);

		serviceObjectsManager.getBrandsService().updateBrand(brandId, JsonFileManager.generateStringPayload("brands"));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails("brands");
	}

	@Test
	public void validateDeleteBrands() {
		serviceObjectsManager.getCommonService().createBrand();
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		serviceObjectsManager.getBrandsService().deleteBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(404);
	}

	@Test
	public void e2eFlowBrands() {
		serviceObjectsManager.getCommonService().createBrand();
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails("brands");

		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);

		serviceObjectsManager.getBrandsService().updateBrand(brandId, JsonFileManager.generateStringPayload("brands"));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails("brands");

		serviceObjectsManager.getBrandsService().deleteBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(404);
	}

}
