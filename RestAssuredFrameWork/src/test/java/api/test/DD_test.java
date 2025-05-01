package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoits;
import api.payload.Payload;
import api.utilities.DataProviderr;
import io.restassured.response.Response;

public class DD_test {
	
	@Test(priority = 1, dataProvider = "data",dataProviderClass = DataProviderr.class)
	void postTest(String UserId,String UserName,String FirstName, String LastName, String  Email, String Password,String Phone )
	{
		Payload payData = new Payload();
		int id = (int) Double.parseDouble(UserId);
		payData.setId(id);
		payData.setUsername(UserName);
		payData.setFirstName(FirstName);
		payData.setLastName(LastName);
		payData.setEmail(Email);
		payData.setPassword(Password);
		payData.setPhone(Phone);
		
			Response response = UserEndpoits.createUser(payData);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	@Test(priority = 2,dependsOnMethods ="postTest" ,  dataProvider = "username",dataProviderClass = DataProviderr.class)
	void testDeleteUser(String UserName) {

		Response response = UserEndpoits.deleteUser(UserName);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(),200);
	}
	
}
