package api.services;

import org.testng.Assert;

import api.endpoint.Routes;
import base.TestBase;

public class BrandsService extends TestBase {

	public static void getAllBrands() {
		apiInstannce.getRequest(Routes.GET_ALL_BRANDS);
	}

	public static void getBrand(int brandId) {
		apiInstannce.getRequest(Routes.GET_BRANDS + "/" + brandId);
	}

	public static void createBrand(String payload) {
		apiInstannce.postRequest(Routes.POST_BRANDS, payload);
	}

	public static void updateBrand(int brandId, String payload) {
		apiInstannce.postRequest(Routes.POST_BRANDS + "/" + brandId, payload);
	}

	public static void deleteBrand(int brandId) {
		apiInstannce.deleteRequest(Routes.DELETE_BRANDS + "/" + brandId);
	}

	public static void printBrandAPIResponse() {
		apiInstannce.printResponse();
	}

	public static void validateBrandsAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(apiInstannce.getStatusCode(), expectedStatusCode);
	}

	public static int getBrandId() {
		return apiInstannce.parseResponseJsonObject().getInt("_id");
	}

}
