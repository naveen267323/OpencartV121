package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

//Please use ExcelUtility.java - that java program will also read the data from excel.
//when no @DataProvider is used we can use the excelutility.java program becasue File reading logic must be inside a method.
	

//When we use @DataProvider annotation by testng - also reading data should be used using 2D array 
//becasue DataProvider method will/must return a 2D Object array (Object[][]) for TestNG to use it.
	
	
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        // Dynamic file path for portability
        String filePath = System.getProperty("user.dir") + "\\testdata\\Book1.xlsx";
        FileInputStream inputfile = new FileInputStream(filePath);
        
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputfile)) {
            XSSFSheet excelsheet = workbook.getSheet("Sheet1");

            int totalRows = excelsheet.getLastRowNum();  // Excluding header
            int totalColumns = excelsheet.getRow(0).getLastCellNum(); // Column count
            
            // Create a 2D Object array to store data
            Object[][] loginData = new Object[totalRows][totalColumns];

            for (int i = 1; i <= totalRows; i++) { // Start from 1 to skip header
                XSSFRow row = excelsheet.getRow(i);
                for (int j = 0; j < totalColumns; j++) {
                    XSSFCell cell = row.getCell(j);
                    loginData[i - 1][j] = (cell == null) ? "" : cell.toString(); // Handle null cells
                }
            }
            return loginData;
        }
    }
}