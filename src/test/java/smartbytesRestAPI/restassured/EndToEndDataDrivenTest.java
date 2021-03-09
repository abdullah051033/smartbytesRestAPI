package smartbytesRestAPI.restassured;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import smartbytes.restassured.util.ExcelUtility;
import static io.restassured.RestAssured.*;

public class EndToEndDataDrivenTest {
	
	
	@Test
	public void EndToEndDataDrivenAPItest() {
		
		
		String excelFilePath = "/Users/mamun/smartbytesRestAPI/resources/SmartBytes_API_TestData.xlsx";
		String SheetName="CustomerAPI";
		
		List<List<String>> testCases = ExcelUtility.readExcelData(excelFilePath, SheetName);
		
		String method="";
		String testCaseName="";
		String restURI="";
		String reqBody="";
		String reqContentType="";
		String respContentType="";
		int respStatusCode;
		
		for(List<String> testCase : testCases) {
			
			method = testCase.get(0);
			testCaseName = testCase.get(1);
			restURI = testCase.get(2);
			reqContentType = testCase.get(3);
			reqBody = testCase.get(4);
			respStatusCode = (int)Double.parseDouble(testCase.get(5));
			
			
//			System.out.println("----------------------------------------------------------");
//			System.out.println("Request Method:" +method);
//			System.out.println("Test Case:" + testCaseName);
//			System.out.println("\tRequest URI :" + restURI);
//			System.out.println("\tRequest Body:" + reqBody);
//			System.out.println("\tRequest Content Type:" + reqContentType);
//			System.out.println("\tResp Code :" + respStatusCode);
//			System.out.println("\tResp Content Type:" + respContentType);
//			System.out.println("-----------------------------------------------------------");
			
						
			if(method.equalsIgnoreCase("Get")) {
				System.out.println("Test Case : " + testCaseName);
				
				given()
				.contentType(reqContentType)
				
				.get(restURI)
				.then()
				.statusCode(respStatusCode);				
								
//				.extract()
//				.response().prettyPrint();
				
			}else if(method.equals("POST")) {
				System.out.println("Test Case : " + testCaseName);
				given()
				.contentType(reqContentType)
				.body(reqBody)
				
				.post(restURI)
				.then()
				.statusCode(respStatusCode).extract().response().prettyPrint();
			}
			
		}
		
		
	}

}
