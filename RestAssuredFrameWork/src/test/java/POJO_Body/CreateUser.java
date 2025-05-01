package POJO_Body;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CreateUser {
	Response res;
	// http://localhost:3000/student
	/*
	 * "name": "KeerthiVasan har",
    "age": 20,
    "gender": "Female",
    "email": "ananya.sharma@example.com",
    "phone": "9876543210"
	 */
String id ;
	//String id;
	@Test(priority = 1)
	void getUser()
	{
		Body b = new Body();
		b.setAge("keerthi");
		b.setAge("56");


		id = given()
		.contentType("application/json")
		.body(b)

		.when()
		.post("http://localhost:3000/student")
		.jsonPath().get("id")
		;
	

	}
	@Test(priority = 4)
	void delete()
	{
		given()
		
		.when()
		.delete("http://localhost:3000/student/"+id)

		.then()
		.statusCode(200)
		.log().all()
		;
}
	//	@Test(priority = 2)
	//	void createUser() throws FileNotFoundException
	//	{
	//		FileInputStream file = new FileInputStream("./user.json");
	//		JSONTokener jt = new JSONTokener(file);
	//		JSONObject jb = new JSONObject(jt);
	//
	//	id =	given() 
	//		.contentType("application/json")
	//		.body(jb.toString())
	//
	//		.when()
	//		.post("http://localhost:3000/student")
	//		.jsonPath().get("id");
	//	}
	//		
	//		@Test(priority = 3)
	//		void updateUser()
	//		{
	//			HashMap<String, Comparable> data = new HashMap<String, Comparable>();
	//			data.put("name", "keernt");
	//			data.put("age", 11); 
	//	
	//			given()
	//			.contentType("application/json")
	//			.body(data)
	//	
	//			.when()
	//			.put("http://localhost:3000/student/"+id)
	//			
	//			.then()
	//			.statusCode(200)
	//			.log().all()
	//			;
	//		}
	//		
	

}

