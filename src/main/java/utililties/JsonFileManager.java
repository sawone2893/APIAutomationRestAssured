package utililties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

import api.config.ConfigProp;

public class JsonFileManager {

	private static String filePath;

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		JsonFileManager.filePath = filePath;
	}

	public static String generateStringPayload(String fileName) {
		String payload = null;
		try {
			setFilePath(ConfigProp.PAYLOAD_FILE_PATH + fileName + ".json");
			payload = new String(Files.readAllBytes(Paths.get(getFilePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return payload;
	}

	public static String getJsonData(String fileName, String keyName) {
		JSONObject jsonData = null;
		String data = generateStringPayload(fileName);
		jsonData = new JSONObject(data);
		return jsonData.getString(keyName);
	}

	public static void setJsonData(String fileName, String keyName, String value) {
		JSONObject jsonData = null;
		try {
			String data = generateStringPayload(fileName);
			jsonData = new JSONObject(data);
			jsonData.put(keyName, value);
			String updateData = jsonData.toString(4);
			Files.write(Paths.get(getFilePath()), updateData.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
