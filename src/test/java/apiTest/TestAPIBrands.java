package apiTest;

import org.testng.annotations.Test;

import api.pojo.Brands;
import api.services.BrandsService;
import base.TestBase;
import utililties.DataGenerator;
import utililties.PojoObjectToGson;

public class TestAPIBrands extends TestBase {

	@Test(enabled = false)
	public void validateGetAllBrands() {
		BrandsService.getAllBrands();
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
	}

	@Test
	public void validateCreateBrands() {
		Brands brand1 = new Brands();
		brand1.setName(DataGenerator.generateData().company().name());
		brand1.setDescription(DataGenerator.generateData().company().industry());
		BrandsService.createBrand(PojoObjectToGson.convertToGson(brand1));
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
		BrandsService.validateCteatedBarndDetails(brand1);
	}

}
