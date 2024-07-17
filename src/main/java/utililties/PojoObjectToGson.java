package utililties;

import com.google.gson.Gson;

public class PojoObjectToGson {

	public static String convertToGson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

}
