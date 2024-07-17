package utililties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadGenerator {
	public static String generateStringPayload(String filePath) {
		System.out.println("Fetching Payload from location:[" + filePath + "]");
		String payload = null;
		try {
			payload = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return payload;
	}

}
