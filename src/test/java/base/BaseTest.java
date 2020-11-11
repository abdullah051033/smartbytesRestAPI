package base;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import smartbytes.restassured.util.SmartBytesUtil;

public class BaseTest {

	
	@BeforeClass
	public static void init(){
		System.out.println("initialized the base URL....");
		baseURI = SmartBytesUtil.BASE_URI;
	}
	
	
	
	@AfterClass
	public static void tearDown(){
		System.out.println("Completed test execution ....");
	}
	
}
