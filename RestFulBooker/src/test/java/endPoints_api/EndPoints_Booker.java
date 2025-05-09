package endPoints_api;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import payLoad_api.Booking;
import payLoad_api.BookingDates;
import routes_api.URL_Booking;

public class EndPoints_Booker 
{
	public static Response response;
	public static int id;

	public static Booking booking;
	public static BookingDates dates;
	public static String token;

	public static String getToken() 
	{
		token = given()
				.contentType("application/json")
				.body("{ \"username\" : \"admin\", \"password\" : \"password123\" }")
				.when()
				.post("https://restful-booker.herokuapp.com/auth")
				.then()
				.statusCode(200)
				.extract()
				.jsonPath()
				.getString("token");

		return token;
	}


	public static Response createBooking()
	{
		dates = new BookingDates("2025-04-01","2025-04-10");
		booking = new Booking("keerth","vasan",100,true, dates, "Breakfast");
		response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(booking)
				.when()
				.post(URL_Booking .post_Url);
		id = response.jsonPath().getInt("bookingid");
		System.out.println("id is "+id);

		return response;

	}

	public static Response getBooking()
	{
		response =	given()
				.contentType("application/json")
				.accept("application/json")
				.when()
				.get(URL_Booking.get_Url+id);
		return response;

	}



	public static  Response updateBooking()
	{
		dates = new BookingDates("2025-04-01","2025-04-10");
		booking = new Booking("Harini","vasan",100,true, dates, "Breakfast");

		response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(booking)
				.cookie("token", token)
				.when()
				.put(URL_Booking.put_Url+id);

		return response;

	}

	public static Response deleteBooking()
	{
		response =	given()
				.contentType("application/json")
				.accept("application/json")
				.cookie("token", token)
				.when()
				.delete(URL_Booking.delete_Url+id);
		return response;

	}



}
