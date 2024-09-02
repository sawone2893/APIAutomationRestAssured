package base;

import io.github.shabryn2893.selAutoCore.apiCore.APIToolFactory;
import io.github.shabryn2893.selAutoCore.apiCore.IActionAPI;

public class BaseClass {

	public static IActionAPI apiInstannce = null;
	
	public void init(String toolName,String baseURI) {
		apiInstannce = APIToolFactory.apiDriverInstance(toolName,baseURI);
	}

}
