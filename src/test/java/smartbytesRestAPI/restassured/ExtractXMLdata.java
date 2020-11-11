package smartbytesRestAPI.restassured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import smartbytes.restassured.util.SmartBytesUtil;

public class ExtractXMLdata {

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
	public void extract_xml_data() {
		Response responsedata = get("/test/books/xml");
		responsedata.prettyPrint();
		String firstBookAuthor = responsedata.path("catalog.book[0].author");
		System.out.println("First book author name : "+ firstBookAuthor);
		
		int bookarraySize = responsedata.path("catalog.book.size()");
		
		System.out.println("======= All books author name ===========\n");
		for(int i=0 ; i<bookarraySize; i++) {
			System.out.println("Book " +i+ " title" +responsedata.path("catalog.book["+i+"].title") +" :: Author -> " + responsedata.path("catalog.book["+i+"].author"));
		}
	}
	
	
	
	
	
	
	
		
}
