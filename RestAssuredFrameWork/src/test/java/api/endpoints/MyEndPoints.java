package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Payload2;
import io.restassured.response.Response;

public class MyEndPoints 
{
	public static Response response;

	public static Response createUser(Payload2 data)
	{
		response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(data)
				.when()
				.post(MyRoutes.post_URL)
				;
		return response;
	}

	public static Response getUser(String id)
	{
		response= given()
				.pathParam("id", id)
				.when()
				.get(MyRoutes.get_URL);
		return response;

	}

	public static Response updateUser(Payload2 data,String id)
	{
		response = given()
				.contentType("application/json")
				.accept("application/json")
				.pathParam("id", id)
				.body(data)

				.when()
				.put(MyRoutes.put_URL)
				;

		return response;
	}

	public static Response  deleteUser(String id)
	{
		response = given()
				.pathParam("id", id)
				.when()
				.delete(MyRoutes.delete_URL);
		return response;
	}

}
