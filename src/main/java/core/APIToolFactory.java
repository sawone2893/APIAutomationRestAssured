package core;

public class APIToolFactory {

	static IActionAPI actionAPI = null;

	public static IActionAPI apiDriverInstance(String apiDriverName, String baseURI) {
		switch (apiDriverName.toLowerCase()) {
		case "restassured": {
			System.out.println("Create Instance for " + apiDriverName);
			actionAPI = new RestAssuredActions(baseURI);
			break;
		}
		default: {
			System.out.println("Unsupported API Driver Name: " + apiDriverName);
		}
		}
		return actionAPI;
	}

}
