package apiTest;

import org.testng.annotations.Test;

import base.TestBase;
import io.github.shabryn2893.utils.JsonFileManager;
import utililties.DataGenerator;

public class TestAPIBrands extends TestBase {
	
	@Test
	public void validateGetAllBrands() {
		serviceObjectsManager.getBrandsService().getAllBrands();
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
	}

	@Test
	public void validateCreateBrands() {
		serviceObjectsManager.getCommonService().createBrand(getPayLoadPath("brands"));
	}

	@Test
	public void validateUpdateBrands() {
		serviceObjectsManager.getCommonService().createBrand(getPayLoadPath("brands"));
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData(getPayLoadPath("brands"), "name", name);
		JsonFileManager.setJsonData(getPayLoadPath("brands"), "description", description);

		serviceObjectsManager.getBrandsService().updateBrand(brandId, JsonFileManager.generateStringPayload(getPayLoadPath("brands")));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails(getPayLoadPath("brands"));
	}

	@Test
	public void validateDeleteBrands() {
		serviceObjectsManager.getCommonService().createBrand(getPayLoadPath("brands"));
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		serviceObjectsManager.getBrandsService().deleteBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(404);
	}

	@Test
	public void e2eFlowBrands() {
		serviceObjectsManager.getCommonService().createBrand(getPayLoadPath("brands"));
		String brandId = serviceObjectsManager.getBrandsService().getBrandId();
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails(getPayLoadPath("brands"));

		String name = DataGenerator.generateData().company().name();
		String description = DataGenerator.generateData().company().industry();
		JsonFileManager.setJsonData(getPayLoadPath("brands"), "name", name);
		JsonFileManager.setJsonData(getPayLoadPath("brands"), "description", description);

		serviceObjectsManager.getBrandsService().updateBrand(brandId, JsonFileManager.generateStringPayload(getPayLoadPath("brands")));
		serviceObjectsManager.getBrandsService().printBrandAPIResponse();
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().validateBrandDetails(getPayLoadPath("brands"));

		serviceObjectsManager.getBrandsService().deleteBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(200);
		serviceObjectsManager.getBrandsService().getBrand(brandId);
		serviceObjectsManager.getBrandsService().validateBrandsAPIStatusCode(404);
	}

}
