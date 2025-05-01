package api.endpoints;

import static io.restassured.RestAssured.*;

/*import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
*/
import api.payload.Payload;
import io.restassured.response.Response;



public class UserEndpoits {
	public static Response response;
	
	
public static Response createUser(Payload data)
{
	response = given()
		.contentType("application/json")
		.accept("application/json")
		.body(data)
		
		.when()
		.post(Routes.post_url);
	
	return response;
		
	}
	
public static Response getUser(String username)
{
	response = given()
	.pathParam("username", username)	
		.when()
		.get(Routes.get_url);
	return response;
	}
	
public static Response updateUser(Payload data,String username)
{
	response = given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		.body(data)
		
		.when()
		.put(Routes.put_url);
	
	return response;
		
	}

public static Response deleteUser(String username)
{
	 response = given()
	.pathParam("username", username)	
		.when()
		.delete(Routes.delete_url);
	return response;
	}
	
	
	
	
	
	
	

}
