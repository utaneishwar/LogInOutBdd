package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class PlaceOrderEcommerse extends BaseData
{
	@Test
	public void PlaceOrder()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com/";
		given()
		.header("Authorization",tokenid)
		.header("Content-Type","application/json")
		.body("{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"India\", \r\n"
				+ "        \"productOrderedId\" : \""+productID+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}")
		.when()
		.post("api/ecom/order/create-order")
		.then()
		.log().all()
		.extract()
		.response();
		
	}
}