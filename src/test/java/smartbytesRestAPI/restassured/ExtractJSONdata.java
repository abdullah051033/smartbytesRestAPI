package smartbytesRestAPI.restassured;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import smartbytes.restassured.util.SmartBytesUtil;

public class ExtractJSONdata {
	
	//private static final String BASE_URI = "http://localhost:9090/api";
	
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
	public void extract_json_data() {
		Response response = get("/test/books/json");
	
		String firstBookTitle = response.path("books[0].title");
		System.out.println("first book title : "+firstBookTitle);
		
		int totalBooks = response.path("books.size()");
		System.out.println("total books: " +totalBooks);
		
		for(int i= 0 ; i<totalBooks; i++) {
			System.out.println("Book " +i+" Title : " + response.path("books["+i+"].title") +" :: Author name: " + response.path("books["+i+"].author"));
		}
		
	}

}









