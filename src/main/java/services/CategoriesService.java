package services;

import org.testng.Assert;

import base.BaseClass;
import endpoint.Routes;

public class CategoriesService{

	private static CategoriesService categoriesService = null;

	private CategoriesService() {
	}

	public static CategoriesService getInstance() {
		if (categoriesService == null) {
			categoriesService = new CategoriesService();
		}
		return categoriesService;
	}
	
	public void getAllCategories() {
		BaseClass.doGetRequest(Routes.GET_ALL_CATEGORIES);
	}
	
	public void createCategories(String payLoad,String bToken) {
		BaseClass.doPostRequest(Routes.POST_CATEGORIES,payLoad,bToken);
	}
	
	public void getCategories(String categoriesId) {
		BaseClass.doGetRequest(Routes.GET_CATEGORIES+"/"+categoriesId);
	}
	
	public void updateCategories(String categoriesId,String payLoad,String bToken) {
		BaseClass.doPutRequest(Routes.PUT_CATEGORIES+"/"+categoriesId,payLoad);
	}
	
	public void deleteCategories(String categoriesId,String bToken) {
		BaseClass.doDeleteRequest(Routes.DELETE_CATEGORIES+"/"+categoriesId);
	}
	
	public void printCategoriesAPIResponse() {
		BaseClass.doPrintAPIResponse();
	}

	public void validateCategoriesAPIStatusCode(int expectedStatusCode) {
		Assert.assertEquals(BaseClass.doGetAPIStatusCode(), expectedStatusCode);
	}

	public String getCategoriesId() {
		return BaseClass.doParseResponseJsonObject().getString("_id");
	}

}
