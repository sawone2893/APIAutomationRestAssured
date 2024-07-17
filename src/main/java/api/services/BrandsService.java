package api.services;

import org.testng.Assert;

import api.endpoint.Routes;
import api.pojo.Brands;
import base.TestBase;

public class BrandsService extends TestBase {

	public static void getAllBrands() {
		apiInstannce.getRequest(Routes.GET_ALL_BRANDS);
	}

	public static void getBrand(String brandId) {
		apiInstannce.getRequest(Routes.GET_BRANDS + "/" + brandId);
	}

	public static void createBrand(String payload) {
		apiInstannce.postRequest(Routes.POST_BRANDS, payload);
	}

	public static void updateBrand(String brandId, String payload) {
		apiInstannce.postRequest(Routes.POST_BRANDS + "/" + brandId, payload);
	}

	public static void deleteBrand(String brandId) {
		apiInstannce.deleteRequest(Routes.DELETE_BRANDS + "/" + brandId);
	}

	public static void printBrandAPIResponse() {
		apiInstannce.printResponse();
	}

	public static void validateBrandsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public static String getBrandId() {
		return apiInstannce.parseResponseJsonObject().getString("_id");
	}

	public static void validateCteatedBarndDetails(Brands brand) {
		Assert.assertEquals(apiInstannce.parseResponseJsonObject().getString("name"), brand.getName());
		Assert.assertEquals(apiInstannce.parseResponseJsonObject().getString("description"), brand.getDescription());
	}

}
