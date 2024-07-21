package base;

import org.testng.annotations.BeforeSuite;

import api.config.ConfigProp;
import base.actionInterface.IActionAPI;
import base.driverFactory.DriverFactory;

public class TestBase {

	public static IActionAPI apiInstannce = null;

	@BeforeSuite
	public static void initAPI() {
		apiInstannce = DriverFactory.apiDriverInstance(ConfigProp.API_DRIVER, ConfigProp.BASE_URI);
	}
}
