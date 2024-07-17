package apiTest;

import org.testng.annotations.Test;

import api.services.BrandsService;
import base.TestBase;
import utililties.PayloadGenerator;

public class TC1 extends TestBase {

	@Test(enabled = false)
	public void validateGetAllBrands() {
		BrandsService.getAllBrands();
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
	}

	@Test
	public void validateCreateBrands() {
		BrandsService
				.createBrand(PayloadGenerator.generateStringPayload("./src/main/java/resources/payload/brand.json"));
		BrandsService.printBrandAPIResponse();
		BrandsService.validateBrandsAPIStatusCode(200);
	}

}
