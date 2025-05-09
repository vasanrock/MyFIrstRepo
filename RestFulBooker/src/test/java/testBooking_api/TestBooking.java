package testBooking_api;

import org.testng.Assert;
import org.testng.annotations.Test;

import endPoints_api.EndPoints_Booker;
import io.restassured.response.Response;

public class TestBooking 
{
	
	@Test(priority = 0)
	
	void getToken()
	{
		String token = EndPoints_Booker.getToken();
		System.out.println(token);
	}
	
	
@Test(priority = 1)
	void createBooking_Test()
	{
		Response booking = EndPoints_Booker.createBooking();
		booking
		.then()
		.log().all();
		
		Assert.assertEquals(booking.statusCode(),200);
	}


@Test(priority = 2)
void getBooking_Test()
{
	Response booking = EndPoints_Booker.getBooking();
	booking
	.then()
	.log().all();
	
	Assert.assertEquals(booking.statusCode(),200);
}



@Test(priority = 3)
void updateBooking_Test()
{
	Response booking = EndPoints_Booker.updateBooking();
	booking
	.then()
	.log().all();
	
	Assert.assertEquals(booking.statusCode(),200);
}


@Test(priority = 4)
void deleteBooking_Test()
{
	Response booking = EndPoints_Booker.deleteBooking();
	booking
	.then()
	.log().all();
	
	Assert.assertEquals(booking.statusCode(),201);
}











}
