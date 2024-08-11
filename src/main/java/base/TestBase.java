package base;

import org.testng.annotations.BeforeSuite;

import config.ConfigProp;
import core.APIToolFactory;
import core.IActionAPI;

public class TestBase {

	public static IActionAPI apiInstannce = null;

	@BeforeSuite
	public static void initAPI() {
		apiInstannce = APIToolFactory.apiDriverInstance(ConfigProp.API_DRIVER, ConfigProp.BASE_URI);
	}
}
