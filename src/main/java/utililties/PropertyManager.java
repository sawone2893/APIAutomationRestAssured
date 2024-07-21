package utililties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import api.config.ConfigProp;

public class PropertyManager {

	public static String getAnyProperty(String propFileName, String configPropName) {
		String value = null;
		try {
			Properties property = new Properties();
			String filepath = ConfigProp.PROP_FILE_PATH + propFileName + ".properties";
			FileInputStream fis = new FileInputStream(new File(filepath));
			property.load(fis);
			value = property.getProperty(configPropName);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
