package smartbytesRestAPI.restassured;

import static io.restassured.RestAssured.*;

public class TestCountryAPI {

	public static void main(String[] args) {
		
		get("http://localhost:9090/api/country/country/get/all").then().extract().response().prettyPrint();
	}

}
