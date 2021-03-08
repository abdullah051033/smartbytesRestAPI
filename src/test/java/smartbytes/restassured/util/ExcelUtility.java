package smartbytes.restassured.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 *
 */
public class ExcelUtility {
//	public static void main(String[] args) {
//	String excelFilePath = "/Users/sys/Documents/restassured/Book1.xlsx";
//	String sheetName="Employees";
//	List<List<String>>	excelData= readExcelData(excelFilePath, sheetName);
//	
//	for (List<String> rowData : excelData) {
//		for(String cellData: rowData) {
//			System.out.print(cellData+"\t");
//		}
//		System.out.println("");
//	}
//	}
	/**
	 * Reads data from excel sheet
	 * @param excelFilePath	 excel file location
	 * @param sheetName		 sheet name in the excel
	 * @return
	 */
	public static List<List<String>> readExcelData(String excelFilePath,String sheetName){
	       
		List<List<String>> excelData = new ArrayList<List<String>>();
		List<String> rowData = null;
		
	        FileInputStream inputStream=null;
			try {
				inputStream = new FileInputStream(new File(excelFilePath));  //FileInputSteam inputStream = new FileInputStream(new File(excelFilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	         
	        Workbook workbook=null;											//Workbook workbook;
			try {
				workbook = new XSSFWorkbook(inputStream);       			//workbook = new XSSFWorkbook(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        Sheet firstSheet = workbook.getSheet(sheetName);               //Sheet firstSheet = workbook.getSheet(sheetName);
	        Iterator<Row> iterator = firstSheet.iterator();
	        String cellValue="";
	        iterator.next();
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	            rowData = new ArrayList<String>();
	            
	            while (cellIterator.hasNext()) {
	            	cellValue="";
	                Cell cell = cellIterator.next();
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        cellValue= cell.getStringCellValue();
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        cellValue= String.valueOf(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        cellValue= String.valueOf(cell.getNumericCellValue());
	                        break;
	                }
	                //cellValue = cell.getStringCellValue();
	                rowData.add(cellValue);
	            }
	            excelData.add(rowData);
	        }
	         
	        try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	
		return excelData;
	} 
}