package config;

import io.github.shabryn2893.utils.PropertyFileManager;

public class ConfigProp {

	public static final String PROP_FILE_PATH = "./resources/configProp/";
	public static final String PAYLOAD_FILE_PATH = "./resources/payloads/";
	public static final String CONFIG_ENV = "qaEnvConfig.properties";
	public static final String TOOL_NAME = "RESTASSURED";
	public static final String BASE_URI = PropertyFileManager.getProperty(PROP_FILE_PATH+CONFIG_ENV, "BASEURI");
	public static final String USER_NAME = PropertyFileManager.getProperty(PROP_FILE_PATH+CONFIG_ENV, "USERNAME");
	public static final String PASSWORD = PropertyFileManager.getProperty(PROP_FILE_PATH+CONFIG_ENV, "PASSWORD");

}
