package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoits;
import api.payload.Payload;
import io.restassured.response.Response;

public class UserTest 
{
	Faker faker;
	Payload data;
	String generatedUsername;

	@BeforeClass
	void setUp()
	{
		faker = new Faker();
		data = new Payload();

		data.setId(faker.idNumber().hashCode());
		data.setUsername(faker.name().username());
		data.setFirstName(faker.name().firstName());
		data.setLastName(faker.name().lastName());
		data.setEmail(faker.internet().emailAddress());
		data.setPassword(faker.internet().password(5,10));
		data.setPhone(faker.phoneNumber().cellPhone());
		generatedUsername = data.getUsername();
		System.out.println(generatedUsername);

	}

	@Test(priority = 1)
	void testPostUser()
	{
		Response response = UserEndpoits.createUser(data);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);
	}

	@Test(priority = 2, dependsOnMethods = "testPostUser" )
	void testGetUser()
	{
		Response response = UserEndpoits.getUser(generatedUsername);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);

	}

	@Test(priority = 3,dependsOnMethods = "testGetUser" )
	void testPutUser() {
		
		data.setFirstName(faker.name().firstName());
		data.setLastName(faker.name().lastName());
		data.setEmail(faker.internet().emailAddress());
		System.out.println(data.getEmail());

		Response response = UserEndpoits.updateUser(data,generatedUsername);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	@Test(priority = 4,dependsOnMethods = "testPutUser" )
	void testDeleteUser() {

		Response response = UserEndpoits.deleteUser(generatedUsername);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);


	}
	





}
