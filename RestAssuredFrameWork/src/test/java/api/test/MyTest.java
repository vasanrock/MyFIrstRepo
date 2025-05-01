package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.MyEndPoints;
import api.payload.Payload2;
import io.restassured.response.Response;

public class MyTest 
{
Payload2 data;
Faker faker;
String id;

	@BeforeClass
	void start()
	{
		faker = new Faker();
		data  = new Payload2();
		
		data.setName(faker.name().username());
		data.setAge(faker.number().numberBetween(20,30));
	}
	
	@Test(priority = 1)
	void postTest()
	{
		Response res = MyEndPoints.createUser(data);
		id = res.jsonPath().getString("id");
		System.out.println(id);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(),201);
	}
	@Test(priority = 2)
	void getTest()
	{
		
		Response res = MyEndPoints.getUser(id);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(),200);
	}
	
	
	
	@Test(priority = 3)
	void putTest()
	{
		data.setName(faker.name().name());
		data.setAge(faker.number().numberBetween(20,34));
		
		
		Response res = MyEndPoints.updateUser(data,id);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(),200);
	}
	
	
	@Test(priority = 4)
	void deleteTest()
	{
		
		Response res = MyEndPoints.deleteUser(id);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(),200);
	}
	
	
	
	
	
	
	}



















	

