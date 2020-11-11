package smartbytesRestAPI.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.http.ContentType;
import smartbytes.restassured.util.SmartBytesUtil;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestCustomerAPI extends BaseTest{
	
	
	@Test(priority = 1, enabled = true)
	public void test_create_customer() {  //create customer//POST operation
		System.out.println("Test for creating new customer ....");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body("{\n" + 
				"    \"firstName\": \"Mohammad\",\n" + 
				"    \"lastName\": \"Mamu\",\n" + 
				"    \"city\": \"Jamaica\",\n" + 
				"    \"county\": \"Usa\",\n" + 
				"    \"state\": \"NY\",\n" + 
				"    \"zip\": \"11435\",\n" + 
				"    \"phone1\": \"123-456-789\",\n" + 
				"    \"phone2\": \"123-456-789\",\n" + 
				"    \"email\": \"mamun@smartbytes.com\",\n" + 
				"    \"web\": \"http://v-logics.com\"\n" + 
				"}")
		.post("/customer/add")
		.then()
		.statusCode(HttpStatus.SC_CREATED)
		
		.extract().response().prettyPrint();
	}
	
	@Test(priority = 2, enabled = true)
	public void test_update_customer() {  //update customer //PUT operation
		System.out.println("Test for updating customer ......");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("id","4" )
		.body("{\n" + 
				"    \"firstName\": \"Abdullah\",\n" + 
				"    \"lastName\": \"AL\",\n" + 
				"    \"city\": \"Jamaica\",\n" + 
				"    \"county\": \"Usa\",\n" + 
				"    \"state\": \"NY\",\n" + 
				"    \"zip\": \"11435\",\n" + 
				"    \"phone1\": \"777-777-777\",\n" + 
				"    \"phone2\": \"123-456-789\",\n" + 
				"    \"email\": \"mamun@smartbytes.com\",\n" + 
				"    \"web\": \"http://v-logics.com\"\n" + 
				"}")
		.put("/customer/update/{id}")
		.then().statusCode(HttpStatus.SC_OK)
		.body("firstName", equalTo("Abdullah")) 
		
		.extract().response().prettyPrint();
	
	}
	
	@Test(priority = 3 , enabled = true)
	public void test_delete_customer() {  //Delete customer...........
		System.out.println("Test to Delete customer......");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("id", "11")
		
		.delete("/customer/delete/{id}")
		.then().statusCode(HttpStatus.SC_OK);
	}
	
	@Test(priority = 4, enabled = true)
	public void test_search_customer_with_ID() { //GET operation with query parameter
		System.out.println("Test to search customer with ID.......");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.queryParam("id", "478")
		
		.get("/customer/show")
		.then()
		.statusCode(HttpStatus.SC_OK)
		.body("firstName", equalTo("Mohammad"))
		
		
		.extract().response().prettyPrint();
		
	}
	
	@Test(priority = 5, enabled = true)
	public void test_search_customer_with_CITY() {
		System.out.println("Test to search customer with CIty......");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON);
		
		get("/customer/list/json/state/NY")
		.then()
		.statusCode(HttpStatus.SC_OK)
		.extract().response().prettyPrint();	
	}
	
	

}













