package base;

import org.testng.annotations.BeforeSuite;

import config.ConfigProp;
import serviceObjects.ServiceObjectsManager;


public class TestBase {

	public static ServiceObjectsManager serviceObjectsManager=null;
	public static BaseClass baseClass=null;

	@BeforeSuite
	public  void initAPI() {
		baseClass= new BaseClass();
		baseClass.init(ConfigProp.TOOL_NAME, ConfigProp.BASE_URI);
		serviceObjectsManager=new ServiceObjectsManager();
	}
}
