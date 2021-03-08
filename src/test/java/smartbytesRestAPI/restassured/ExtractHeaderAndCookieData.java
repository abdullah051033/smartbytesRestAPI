package smartbytesRestAPI.restassured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import smartbytes.restassured.util.SmartBytesUtil;

public class ExtractHeaderAndCookieData {
	
	private static final String BASE_URI = "http://localhost:8080/api";
	
	@BeforeClass
	public static void init(){
		System.out.println("initialized the base URL....");
		baseURI = SmartBytesUtil.BASE_URI;
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println("Completed test execution ....");
	}
	
	
	@Test
	public void test_create_customer() {  //create customer//POST operation
		Response customerResponse =
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body("{\n" + 
				"    \"firstName\": \"aron\",\n" + 
				"    \"lastName\": \"disz\",\n" + 
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
		.extract().response();
		
	String createdBy=customerResponse.getHeader("Created_By");
	String cookieNew_customer_id = customerResponse.getCookie("new_customer_id");
	String allHeaders = customerResponse.headers().toString();
	
	System.out.println("Headervalue : " +createdBy);
	System.out.println("Cookies value : " +cookieNew_customer_id);
	System.out.println("======= All headers ========");
	System.out.println(allHeaders);
	}

}
