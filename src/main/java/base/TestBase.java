package base;

import org.testng.annotations.BeforeSuite;

import config.ConfigProp;
import io.github.shabryn2893.selAutoCore.apiCore.APIToolFactory;
import io.github.shabryn2893.selAutoCore.apiCore.IActionAPI;


public class TestBase {

	public static IActionAPI apiInstannce = null;

	@BeforeSuite
	public static void initAPI() {
		apiInstannce = APIToolFactory.apiDriverInstance(ConfigProp.TOOL_NAME, ConfigProp.BASE_URI);
	}
}
