package smartbytesRestAPI.restassured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;


import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import smartbytes.restassured.util.SmartBytesUtil;
import static io.restassured.path.json.JsonPath.*;
public class ExtractComplexJSON {

	@BeforeClass
	public static void init(){
		System.out.println("initialized the base URL....");
		baseURI = SmartBytesUtil.BASE_URI;
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println("Completed test execution ....");
	}
	
	
	@Test(enabled = false)
	public void extract_ComplexJSON_data() {
		Response responsedata = get("/test/medications/json");
		List<String> labsName = from(responsedata.asString()).get("labs.name");
		List<String> labsLocationOnlyPrimaryCareClinic = from(responsedata.asString())
				.get("labs.findAll {it.location == 'Primary Care Clinic'}.name");
		
		System.out.println("=======  All Labs name with location name  -> 'Primary care Clinic' =========");
		for(String lab:labsLocationOnlyPrimaryCareClinic) {
			System.out.println(lab);
		}
	}
	
	
	
}
