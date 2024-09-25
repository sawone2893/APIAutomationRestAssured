package apiTest;

import org.testng.annotations.Test;

import base.TestBase;

public class TestCategoriesAPI extends TestBase{
	
	@Test
	public void addCategories() {
		serviceObjectsManager.getCommonService().createCategories(getPayLoadPath("categories"));
		serviceObjectsManager.getCategoriesService().validateCategoriesAPIStatusCode(200);
		serviceObjectsManager.getCategoriesService().printCategoriesAPIResponse();
	}

}
