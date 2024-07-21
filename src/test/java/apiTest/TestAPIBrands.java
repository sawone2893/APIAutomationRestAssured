package apiTest;

import org.testng.annotations.Test;

import api.services.BrandsService;
import api.services.CommonService;
import base.TestBase;
import utililties.DataGenerator;
import utililties.JsonFileManager;

public class TestAPIBrands extends TestBase {

	@Test
	public void validateGetAllBrands() {
		BrandsService.getAllBrands();
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
	}

	@Test
	public void validateCreateBrands() {
		CommonService.createBrand();
	}

	@Test
	public void validateUpdateBrands() {
		CommonService.createBrand();
		String brandId = BrandsService.getBrandId();
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);

		BrandsService.updateBrand(brandId, JsonFileManager.generateStringPayload("brands"));
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.validateBrandDetails("brands");
	}

	@Test
	public void validateDeleteBrands() {
		CommonService.createBrand();
		String brandId = BrandsService.getBrandId();
		BrandsService.deleteBrand(brandId);
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.getBrand(brandId);
		BrandsService.validateBrandsAPIStatusCode(404);
	}

	@Test
	public void e2eFlowBrands() {
		CommonService.createBrand();
		String brandId = BrandsService.getBrandId();
		BrandsService.getBrand(brandId);
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.validateBrandDetails("brands");

		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData("brands", "name", name);
		JsonFileManager.setJsonData("brands", "description", description);

		BrandsService.updateBrand(brandId, JsonFileManager.generateStringPayload("brands"));
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.validateBrandDetails("brands");

		BrandsService.deleteBrand(brandId);
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.getBrand(brandId);
		BrandsService.validateBrandsAPIStatusCode(404);
	}

}
