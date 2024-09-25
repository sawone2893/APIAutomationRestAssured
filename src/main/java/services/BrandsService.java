package services;

import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;
import io.github.shabryn2893.utils.JsonFileManager;

public class BrandsService{

	private static BrandsService brandsService = null;

	private BrandsService() {

	}

	public static BrandsService getInstance() {
		if (brandsService == null) {
			brandsService = new BrandsService();
		}

		return brandsService;
	}

	public void getAllBrands() {
		BaseClass.doGetRequest(Routes.GET_ALL_BRANDS);
	}

	public void getBrand(String brandId) {
		BaseClass.doGetRequest(Routes.GET_BRANDS + "/" + brandId);
	}

	public void createBrand(String payload) {
		BaseClass.doPostRequest(Routes.POST_BRANDS, payload);
	}

	public void updateBrand(String brandId, String payload) {
		BaseClass.doPutRequest(Routes.POST_BRANDS + "/" + brandId, payload);
	}

	public void deleteBrand(String brandId) {
		BaseClass.doDeleteRequest(Routes.DELETE_BRANDS + "/" + brandId);
	}

	public void printBrandAPIResponse() {
		BaseClass.doPrintAPIResponse();
	}

	public void validateBrandsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(BaseClass.doGetAPIStatusCode(), expectedStatusCode);
	}

	public String getBrandId() {
		return BaseClass.doParseResponseJsonObject().getString("_id");
	}

	public void validateBrandDetails(String payloadName) {
		Assert.assertEquals(BaseClass.doParseResponseJsonObject().getString("name"),
				JsonFileManager.getJsonData(payloadName, "name"));
		Assert.assertEquals(BaseClass.doParseResponseJsonObject().getString("description"),
				JsonFileManager.getJsonData(payloadName, "description"));
	}

}
