package endpoint;

public class Routes {

	//Admins Module
	public static final String POST_SIGNUP_ADMIN = "/admin/signup";
	public static final String POST_LOGIN_ADMIN = "/admin/login";
	public static final String POST_ADMIN_RESET_PASSWORD = "/admin/reset-password";
	public static final String POST_ADMIN_RECOVER_PASSWORD = "/admin/recover-password";

	//Users Module
	public static final String POST_SIGNUP_USER = "/user/signup";
	public static final String POST_LOGIN_USER = "/user/login";
	public static final String POST_USER_RESET_PASSWORD = "/user/reset-password";
	public static final String POST_USER_RECOVER_PASSWORD = "/user/recover-password";

	//brands Module
	public static final String GET_ALL_BRANDS = "/brands";
	public static final String GET_BRANDS = "/brands";
	public static final String POST_BRANDS = "/brands";
	public static final String PUT_BRANDS = "/brands";
	public static final String DELETE_BRANDS = "/brands";

	//Categories Module
	public static final String GET_ALL_CATEGORIES = "/categories";
	public static final String POST_CATEGORIES = "/categories";
	public static final String GET_CATEGORIES = "/categories";
	public static final String PUT_CATEGORIES = "/categories";
	public static final String DELETE_CATEGORIES = "/categories";

	//Products Module
	public static final String GET_ALL_PRODUCTS = "/products";
	public static final String POST_PRODUCTS = "/products";
	public static final String GET_PRODUCTS = "/products";
	public static final String PUT_PRODUCTS = "/products";
	public static final String DELETE_PRODUCTS = "/products";
	
	//Orders Module
	public static final String GET_ALL_ORDERS = "/order";

}
