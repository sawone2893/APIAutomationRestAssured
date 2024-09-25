package base;

import org.testng.annotations.BeforeSuite;

import config.ConfigProp;
import serviceObjects.ServiceObjectsManager;


public class TestBase {

	public static final ServiceObjectsManager serviceObjectsManager = new ServiceObjectsManager();
	
	@BeforeSuite
	public void initAPI() {
		BaseClass.init(ConfigProp.TOOL_NAME, ConfigProp.BASE_URI);
	}
	
	public String getPayLoadPath(String payLoadName) {
		return ConfigProp.PAYLOAD_FILE_PATH+payLoadName+".json";
	}
}
