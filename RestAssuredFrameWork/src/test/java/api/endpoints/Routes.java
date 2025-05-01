package api.endpoints;


/*
 * Base URL = https://petstore.swagger.io/v2
 * POST = https://petstore.swagger.io/v2/user
 * GET = https://petstore.swagger.io/v2/user/{username}
 * PUT = https://petstore.swagger.io/v2/user/{username}
 * DELETE = https://petstore.swagger.io/v2/user/{username}
 */
public class Routes 
{
	// User Module URLs...
	
	public static String base_url = "https://petstore.swagger.io/v2/user/";
	public static String get_url = base_url+"{username}";
	public static String post_url = base_url;
	public static String put_url = base_url+"{username}";
	public static String delete_url = base_url+"{username}";

}
