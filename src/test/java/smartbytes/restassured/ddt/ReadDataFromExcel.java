package smartbytes.restassured.ddt;

import java.util.List;

import smartbytes.restassured.util.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws InterruptedException {
		
		String excelFilePath="/Users/mamun/smartbytesRestAPI/resources/SmartBytes_API_TestData.xlsx";
		String sheetName="Products";
		
		List<List<String>> productRecords = ExcelUtility.readExcelData(excelFilePath, sheetName);
		
		for(List<String>productRecord : productRecords) {
			
			System.out.println(productRecord.get(0) +"\t" +productRecord.get(2));
			
		}
		
		
	}
}


