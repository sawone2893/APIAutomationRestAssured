package services;

import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;
import utililties.JsonFileManager;

public class BrandsService extends BaseClass {

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
		apiInstannce.getRequest(Routes.GET_ALL_BRANDS);
	}

	public void getBrand(String brandId) {
		apiInstannce.getRequest(Routes.GET_BRANDS + "/" + brandId);
	}

	public void createBrand(String payload) {
		apiInstannce.postRequest(Routes.POST_BRANDS, payload);
	}

	public void updateBrand(String brandId, String payload) {
		apiInstannce.putRequest(Routes.POST_BRANDS + "/" + brandId, payload);
	}

	public void deleteBrand(String brandId) {
		apiInstannce.deleteRequest(Routes.DELETE_BRANDS + "/" + brandId);
	}

	public void printBrandAPIResponse() {
		apiInstannce.printResponse();
	}

	public void validateBrandsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public String getBrandId() {
		return apiInstannce.parseResponseJsonObject().getString("_id");
	}

	public void validateBrandDetails(String payloadName) {
		Assert.assertEquals(apiInstannce.parseResponseJsonObject().getString("name"),
				JsonFileManager.getJsonData(payloadName, "name"));
		Assert.assertEquals(apiInstannce.parseResponseJsonObject().getString("description"),
				JsonFileManager.getJsonData(payloadName, "description"));
	}

}
