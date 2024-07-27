package api.config;

import utililties.PropertyManager;

public class ConfigProp {

	public static final String PROP_FILE_PATH = "./resources/configProp/";
	public static final String PAYLOAD_FILE_PATH = "./resources/payloads/";
	public static final String CONFIG_ENV = "qaEnvConfig";
	public static final String API_DRIVER = "RestAssured";
	public static final String BASE_URI = PropertyManager.getAnyProperty(CONFIG_ENV, "BASEURI");
	public static final String USER_NAME = PropertyManager.getAnyProperty(CONFIG_ENV, "USERNAME");
	public static final String PASSWORD = PropertyManager.getAnyProperty(CONFIG_ENV, "PASSWORD");

}
