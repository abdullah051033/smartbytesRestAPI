package authenticationTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import smartbytes.restassured.util.SmartBytesUtil;

public class BasicAuthTest {
	
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
	public void test_with_valid_credentials() {
		System.out.println("Entered test_with_valid_credentials");
		Response response = 
				given().
				auth().preemptive().basic("admin", "admin").				
				get("/user/list").
				
				then().
				statusCode(200).extract().response();		
				response.prettyPrint();
				System.out.println("Exit test_with_valid_credentials");
	}
	
	@Test
	public void test_with_invalid_credentials() {
		System.out.println("Entered test_with_invalid_credentials");
				given().
				auth().preemptive().basic("ad", "admin").
				
				get("/user/list").
				then().
				statusCode(401)	;
				System.out.println("Exit test_with_invalid_credentials");
	}
	
	
	
	
	
	
	
	
	
	
	

}
